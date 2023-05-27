package com.example.eventerplanner.ui.bottomTabs.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.Gray
import com.example.eventerplanner.presentation.theme.LightGray
import com.example.eventerplanner.ui.common.DefaultHeader
import com.example.eventerplanner.ui.common.SearchComponent

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                   MainContent()
                }
            }
        }
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier) {
        var showBottomSheet by remember { mutableStateOf(false) }

        Column {
            DefaultHeader(
                title = "МОИ СООБЩЕНИЯ",
                icon = painterResource(id = R.drawable.baseline_add_24),
                onClick = { showBottomSheet = true }
            )
            SearchComponent(modifier)
            ChatItem(modifier)
            Spacer(modifier = modifier.padding(10.dp))
            ChatItem2(modifier)
        }
    }

    @Composable
    fun ChatItem(modifier: Modifier) {

        Card(
            modifier = modifier
                .fillMaxWidth(),
            elevation = 20.dp,
            shape = RoundedCornerShape(percent = 20),
            border = BorderStroke(width = 0.8.dp, color = LightGray)
        ) {
            Column(modifier = modifier.padding(start = 20.dp, top = 8.dp, bottom = 6.dp)) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Андрей Андреев", fontSize = 14.sp)
                    Text(text = "+7 920 202 20 20", fontSize = 14.sp, color = LightGray)
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp)
                ) {
                    Box(
                        modifier
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(percent = 50))
                            .background(Gray)
                            .padding(end = 10.dp)
                    )
                    Row() {
                        Column {
                            Divider(thickness = 1.dp)
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Привет!", fontSize = 14.sp)
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_check),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ChatItem2(modifier: Modifier) {
        Card(
            modifier = modifier.fillMaxWidth(),
            elevation = 10.dp,
            shape = RoundedCornerShape(percent = 20),
            border = BorderStroke(width = 0.8.dp, color = LightGray)
        ) {
            Column(modifier = modifier.padding(start = 20.dp, top = 8.dp, bottom = 6.dp)) {
                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Андрей Андреев", fontSize = 14.sp )
                    Text(text = "+7 920 202 20 20", fontSize = 14.sp, color = LightGray)
                }
                Row(modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                ) {
                    Box(
                        modifier
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(percent = 50))
                            .background(Gray)
                            .padding(end = 10.dp)
                    )
                    Row() {
                        Column {
                            Divider(thickness = 1.dp)
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Ок!", fontSize = 14.sp)
                                Box(modifier = modifier
                                    .width(15.dp)
                                    .height(20.dp)
                                    .clip(shape = RoundedCornerShape(percent = 50))
                                    .background(color = FirstTitle),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "1", fontSize = 12.sp, color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
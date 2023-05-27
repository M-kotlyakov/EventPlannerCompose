package com.example.eventerplanner.ui.bottomTabs.home.noEditEvent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.BlueWeather
import com.example.eventerplanner.presentation.theme.DefaultStatus
import com.example.eventerplanner.presentation.theme.EventCardColor
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.LighterGray

class NoEditEventCard : Fragment() {

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
        Column(modifier.verticalScroll(rememberScrollState())) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = EventCardColor)
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        modifier = modifier.clickable { findNavController().popBackStack() },
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
                Row(horizontalArrangement = Arrangement.End) {
                    Icon(
                        modifier = modifier.clickable { },
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = null
                    )
                }
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 18.dp, top = 40.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "встреча 1", fontSize = 28.sp)
                Box(modifier = modifier
                    .clip(shape = RoundedCornerShape(percent = 35))
                    .background(color = DefaultStatus)
                ) {
                    Text(
                        modifier = modifier.padding(15.dp),
                        text = "ожидается",
                        fontSize = 16.sp
                    )
                }
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 38.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "место", fontSize = 18.sp)
                Text(text = "ул Тверская дом 1", fontSize = 14.sp)
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 38.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "начало", fontSize = 18.sp)
                Text(text = "14:00 2023 - 04 - 19", fontSize = 14.sp)
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 38.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "конец", fontSize = 18.sp)
                Text(text = "18:00 2023 - 04 - 19", fontSize = 14.sp)
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 38.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "ответственный", fontSize = 18.sp)
                Text(text = "Андрей Андреев", fontSize = 14.sp)
            }
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 38.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "погода", fontSize = 18.sp)
                Box(modifier = modifier
                    .clip(shape = RoundedCornerShape(percent = 35))
                    .background(color = BlueWeather)) {
                    Row(
                        modifier = modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            modifier = modifier.padding(end = 40.dp),
                            painter = painterResource(id = R.drawable.ic_sun),
                            contentDescription = null
                        )
                        Text(text = "+20", fontSize = 18.sp)
                    }
                }
            }
            Spacer(modifier.padding(30.dp))
            Box(modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(200.dp)
                .clip(shape = RoundedCornerShape(percent = 15))
                .background(color = LighterGray),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    modifier = modifier.padding(20.dp),
                    text = "Lorem ipsum dolor sit amet consectetur." +
                        " Viverra habitasse mauris aliquam id donec." +
                        " Ultrices pretium condimentum aliquet sit fermentum et convallis.",
                    fontSize = 18.sp
                )
            }
        }
    }
}
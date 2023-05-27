package com.example.eventerplanner.ui.bottomTabs.home.detailCategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.DefaultStatus
import com.example.eventerplanner.presentation.theme.EventCardColor
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.Green
import com.example.eventerplanner.presentation.theme.LightGray
import com.example.eventerplanner.presentation.theme.RedStatus
import com.example.eventerplanner.ui.common.DefaultHeader

class DetailCategoriesFragment : Fragment() {

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
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = EventCardColor)
                    .padding(top = 40.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        modifier = modifier.clickable { findNavController().popBackStack() },
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Категория 1",
                    modifier = modifier,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(horizontalArrangement = Arrangement.End) {
                    Icon(
                        modifier = modifier.clickable {  },
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = null
                    )
                }
            }
            Divider(modifier.fillMaxWidth(), thickness = 1.dp)
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 20.dp)
                .align(Alignment.CenterHorizontally)) {

                Box(modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .weight(1f), contentAlignment = Alignment.CenterStart) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Icon(painter = painterResource(id = R.drawable.ic_sort), contentDescription = null)
                        Text(text = "раньше")
                    }
                }

                Box(modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .weight(1f), contentAlignment = Alignment.CenterEnd) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = null)
                        Text(text = "фильтры")
                    }
                }

            }
            var randomStatusForColor by remember { mutableStateOf(DefaultStatus) }
            var randomStatusForText by remember { mutableStateOf("") }

            LazyColumn {
                items(count = 5) {
                    when(it) {
                        in 0..1-> {
                            randomStatusForColor = DefaultStatus
                            randomStatusForText = "ожидается"
                        }
                        2 -> {
                            randomStatusForColor = DefaultStatus
                            randomStatusForText = "ожидается"
                        }
                        3 -> {
                            randomStatusForColor = RedStatus
                            randomStatusForText = "пропущено"
                        }
                        4 -> {
                            randomStatusForColor = Green
                            randomStatusForText = "выполнено"
                        }
                    }
                    EventCard(
                        name = "Event $it",
                        randomStatusForText,
                        randomStatusForColor,
                        {}
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }

    @Composable
    fun EventCard(
        name: String,
        statusText: String,
        statusColor: Color,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(start = 14.dp),
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                backgroundColor = EventCardColor,
                elevation = 30.dp,
                border = BorderStroke(width = 0.6.dp, color = LightGray)
            ) {
                Row(
                    modifier = modifier.padding(start = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier.padding(top = 14.dp)) {
                        Text(
                            text = name,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "Максим Котляков",
                            fontSize = 12.sp,
                            color = LightGray
                        )
                        Spacer(modifier = modifier.height(20.dp))
                        Text(
                            text = "ул Тверская дом 1",
                            fontSize = 12.sp,
                            color = LightGray
                        )
                    }

                    Column {
                        Box(modifier = modifier
                            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 16.dp, bottomEnd = 0.dp, bottomStart = 16.dp))
                            .background(color = statusColor)
                        ) {
                            Text(
                                modifier = modifier.padding(15.dp),
                                text = statusText,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier.height(20.dp))
                        Text(
                            text = "14:00",
                            fontSize = 18.sp
                        )
                        Spacer(modifier.height(10.dp))
                        Text(
                            text = "2023 - 04 - 18",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

    }
}
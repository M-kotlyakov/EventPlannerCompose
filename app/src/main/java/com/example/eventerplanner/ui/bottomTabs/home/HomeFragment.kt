package com.example.eventerplanner.ui.bottomTabs.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.presentation.theme.DefaultStatus
import com.example.eventerplanner.presentation.theme.EventCardColor
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.Green
import com.example.eventerplanner.presentation.theme.LightGray
import com.example.eventerplanner.presentation.theme.RedStatus
import com.example.eventerplanner.ui.App
import com.example.eventerplanner.ui.MainActivity
import com.example.eventerplanner.ui.common.DefaultHeader
import com.example.eventerplanner.ui.utils.factory.ViewModelFactory
import org.orbitmvi.orbit.compose.collectSideEffect
import javax.inject.Inject
import kotlin.random.Random

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val vm by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

//    override fun onResume() {
//        super.onResume()
//        (requireActivity() as MainActivity).setHomeScreenVisible(true)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        (requireActivity() as MainActivity).setHomeScreenVisible(false)
//    }

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

        vm.collectSideEffect {
            when(it) {
                is HomeSideEffect.ShowDetailEvent -> {
                    findNavController().navigate(R.id.action_homeFragment_to_detailEventFragment)
                }
                is HomeSideEffect.ShowDetailCategories -> {
                    findNavController().navigate(R.id.action_homeFragment_to_detailCategoriesFragment)
                }
                is HomeSideEffect.AddEvent -> {
                    findNavController().navigate(R.id.action_homeFragment_to_detailEventFragment)
                }
                is HomeSideEffect.AddCardCategories -> {
                    vm.insertCardCategories(cardCategories = CardCategories())
                }
                is HomeSideEffect.ShowDetailCategories -> {
                    findNavController()
                }
                is HomeSideEffect.Event -> {
                    findNavController().navigate(R.id.action_homeFragment_to_noEditEventCard)
                }
            }
        }
        Column {
            DefaultHeader(
                title = "МОИ МЕРОПРИЯТИЯ",
                icon = painterResource(id = R.drawable.baseline_add_24),
                onClick = { vm.showDetails(1) }
            )
            LazyRow(
                modifier = modifier.padding(horizontal = 20.dp),
                contentPadding = PaddingValues(vertical = 40.dp, horizontal = 6.dp)
            ) {
                items(20) {
                    Box(modifier.padding(end = 20.dp)) {
                        CardCategoriesItem(name = it.toString(), vm::showCardCategories)
                    }
                }
                item {
                    Box(modifier.padding(end = 20.dp)) {
                        CardCategoriesButton()
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = modifier
                .fillMaxWidth()
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
            Spacer(modifier = Modifier.height(12.dp))
            val count = 1
            if (count == 0) {
                Column(modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "кажется ничего не намечается в ближайшее время",
                        fontSize = 18.sp
                    )
                    Icon(painter = painterResource(id = R.drawable.ic_empty_event_list), contentDescription = null)
                }
            } else {
                var randomStatusForColor by remember { mutableStateOf(DefaultStatus) }
                var randomStatusForText by remember { mutableStateOf("") }

                LazyColumn {
                    items(count = 20) {
                        when(it) {
                            in 0..3-> {
                                randomStatusForColor = DefaultStatus
                                randomStatusForText = "ожидается"
                            }
                            7 -> {
                                randomStatusForColor = DefaultStatus
                                randomStatusForText = "ожидается"
                            }
                            in 4..6 -> {
                                randomStatusForColor = RedStatus
                                randomStatusForText = "пропущено"
                            }
                            in 8..19 -> {
                                randomStatusForColor = Green
                                randomStatusForText = "выполнено"
                            }
                        }
                        EventCard(
                            name = "Event $it",
                            randomStatusForText,
                            randomStatusForColor,
                            vm::showEvent
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                    }
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

    @Composable
    fun CardCategoriesItem(
        name: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier.size(148.dp).clickable { onClick() },
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
            border = BorderStroke(width = 0.6.dp, color = LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_blbr),
                contentDescription = null
            )
            Column(
                modifier = modifier
                    .padding(horizontal = 10.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = name)
                Text(text = "$name мероприятий")
            }

        }
    }

    @Composable
    fun CardCategoriesButton(modifier: Modifier = Modifier) {
        Card(
            modifier = modifier.size(148.dp).clickable {  },
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
            border = BorderStroke(1.dp, Color.DarkGray),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_blbr),
                contentDescription = null
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Добавить категорию",
                    fontSize = 14.sp,
                    color = FirstTitle
                )
            }

        }
    }
}

enum class EventStatus {
    DEFAULT, MISSED, COMPLETED
}

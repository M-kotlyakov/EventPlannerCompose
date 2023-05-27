package com.example.eventerplanner.ui.bottomTabs.home.detailEvent

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.LighterGray
import com.example.eventerplanner.ui.App
import com.example.eventerplanner.ui.bottomTabs.home.HomeViewModel
import com.example.eventerplanner.ui.utils.factory.ViewModelFactory
import org.orbitmvi.orbit.compose.collectSideEffect
import javax.inject.Inject

class DetailEventFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val vm by lazy {
        ViewModelProvider(this, viewModelFactory)[DetailEventViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    // TODO: Здесь будет опция, что если нажать на изменить, то просто появится компонент изменения. Это не будет другой экран
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                    EventCard()
                }
            }
        }
    }

    @Composable
    fun EventCard(modifier: Modifier = Modifier) {

        vm.collectSideEffect {

        }

        var eventName by remember { mutableStateOf("") }
        var placeName by remember { mutableStateOf("") }
        var dateStart by remember { mutableStateOf("") }
        var timeStart by remember { mutableStateOf("") }
        var dateEnd by remember { mutableStateOf("") }
        var timeEnd by remember { mutableStateOf("") }
        var responsibilityName by remember { mutableStateOf("") }
        var status by remember { mutableStateOf("") }
        var eventDescription by remember { mutableStateOf("") }

        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = modifier.clickable { findNavController().popBackStack() },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null
                )
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Новое мероприятие",
                        modifier = modifier,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Нэйминг ивента",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = eventName,
                    label = { Text(text = "ивент") },
                    onValueChange = { eventName = it },
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = LighterGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Место",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = placeName,
                    label = { Text(text = "место") },
                    onValueChange = { placeName = it },
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = LighterGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Начало",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = modifier
                        .padding(end = 6.dp)
                        .weight(1f)) {
                        TextField(
                            value = timeStart,
                            label = { Text(text = "время") },
                            onValueChange = { timeStart = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                    }

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp)
                            .weight(2f)
                    ) {
                        TextField(
                            value = dateStart,
                            label = { Text(text = "дата") },
                            onValueChange = { dateStart = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = null,
                            modifier = modifier.align(Alignment.CenterEnd)
                        )
                    }

                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Конец",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = modifier
                        .padding(end = 6.dp)
                        .weight(1f)) {
                        TextField(
                            value = timeEnd,
                            label = { Text(text = "время") },
                            onValueChange = { timeEnd = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                    }

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp)
                            .weight(2f)
                    ) {
                        TextField(
                            value = dateEnd,
                            label = { Text(text = "дата") },
                            onValueChange = { dateEnd = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = null,
                            modifier = modifier.align(Alignment.CenterEnd)
                        )
                    }

                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Ответственный",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = responsibilityName,
                    label = { Text(text = "место") },
                    onValueChange = { responsibilityName = it },
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = LighterGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(modifier = modifier
                        .padding(end = 6.dp)
                        .weight(1f)) {
                        Text(
                            text = "Статус",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = modifier.padding(bottom = 12.dp))
                        TextField(
                            value = status,
                            label = { Text(text = "статус") },
                            onValueChange = { status = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                    }
                    Column(modifier = modifier
                        .padding(start = 6.dp)
                        .weight(1f)) {
                        Text(
                            text = "Погода",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = modifier.padding(bottom = 12.dp))
                        TextField(
                            value = status,
                            label = { Text(text = "погода") },
                            onValueChange = { status = it },
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                disabledTextColor = Color.Transparent,
                                backgroundColor = LighterGray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Описание",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                Box(
                    modifier = modifier.fillMaxWidth()
                ) {
                    TextField(
                        modifier = modifier.fillMaxWidth(),
                        value = eventDescription,
                        label = { Text(text = "описывай") },
                        onValueChange = { eventDescription = it },
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            disabledTextColor = Color.Transparent,
                            backgroundColor = LighterGray,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_attached_files),
                        contentDescription = null,
                        modifier = modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Box(modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = modifier.fillMaxWidth(),
                        onClick = {
                            val item = Event(
                                address = placeName,
                                startDateTime = dateStart + timeStart,
                                endDateTime = dateEnd + timeEnd,
                                responsibility = responsibilityName,
                                status = status,
                                description = eventDescription
                            )
                            vm.insertEvent(item)
//                            findNavController().popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = FirstTitle),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(
                            text = "Сохранить",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }
            }

        }
    }
}
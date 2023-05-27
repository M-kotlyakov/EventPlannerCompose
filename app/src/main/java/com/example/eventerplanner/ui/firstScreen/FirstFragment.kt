package com.example.eventerplanner.ui.firstScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle

class FirstFragment : Fragment() {

    // TODO: Сделать самый первый экран при скачивании приложения
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                    WithBackgroundImage {
                        MainContent()
                    }

                }
            }
        }
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 40.dp, top = 140.dp, end = 50.dp, bottom = 140.dp)
        ) {
            Column() {
                Box(
                    contentAlignment = Alignment.TopStart
                ) {
                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            text = "EVENT PLANNER",
                            fontSize = 50.sp,
                            color = FirstTitle
                        )
                        Spacer(modifier.height(100.dp))
                        Text(
                            text = "Держи все мероприятия под контролем",
                            fontSize = 22.sp
                        )
                    }
                }

                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        modifier = modifier.fillMaxWidth(),
                        onClick = { findNavController().navigate(R.id.action_firstFragment_to_signInFragment) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = FirstTitle),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(
                            text = "Начать",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

            }

        }
    }
    
    @Composable
    fun WithBackgroundImage(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
        Box(modifier = modifier.fillMaxWidth().fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.img_first_screen),
                contentDescription = null,
                modifier = modifier.fillMaxWidth()
            )
            content()
        }
    }
}
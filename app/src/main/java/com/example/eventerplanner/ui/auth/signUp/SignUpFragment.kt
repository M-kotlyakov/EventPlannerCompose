package com.example.eventerplanner.ui.auth.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.LighterGray

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                    SignUpScreen()
                }
            }
        }
    }

    @Composable
    fun SignUpScreen(modifier: Modifier = Modifier) {

        var name by remember { mutableStateOf("") }
        var mail by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var rePassword by remember { mutableStateOf("") }

        Box(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 57.dp, top = 80.dp, end = 57.dp, bottom = 83.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "EVENT PLANNER",
                        fontSize = 28.sp,
                        color = FirstTitle
                    )
                    Spacer(modifier = modifier.height(40.dp))
                    Text(
                        text = "регистрация",
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = modifier.height(30.dp))
                Text(
                    text = "создай аккаунт",
                    fontSize = 14.sp
                )
                Spacer(modifier = modifier.height(40.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = name,
                    label = { Text(text = "имя") },
                    onValueChange = { name = it },
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
                Spacer(modifier = modifier.height(30.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = mail,
                    label = { Text(text = "почта") },
                    onValueChange = { mail = it },
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
                Spacer(modifier = modifier.height(30.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = password,
                    label = { Text(text = "пароль") },
                    onValueChange = { password = it },
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
                Spacer(modifier = modifier.height(30.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = rePassword,
                    label = { Text(text = "подтверждение пароля") },
                    onValueChange = { rePassword = it },
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
                Spacer(modifier = modifier.height(30.dp))
                Button(
                    modifier = modifier.fillMaxWidth(),
                    onClick = { findNavController().navigate(R.id.tab_home) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = FirstTitle),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "завершить",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = "есть аккаунт?",
                    fontSize = 16.sp
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    modifier = modifier.clickable { findNavController().navigate(R.id.signInFragment) },
                    text = "войти",
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}
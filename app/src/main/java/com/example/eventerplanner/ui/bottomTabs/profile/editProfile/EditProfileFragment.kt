package com.example.eventerplanner.ui.bottomTabs.profile.editProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventCardColor
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.LighterGray
import kotlinx.coroutines.launch

class EditProfileFragment : Fragment() {

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

        var name by remember { mutableStateOf("") }
        var mail by remember { mutableStateOf("") }
        var jobTitle by remember { mutableStateOf("") }
        var job by remember { mutableStateOf("") }

        Column(modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .verticalScroll(rememberScrollState())
        ) {
            Row(modifier = modifier
                .fillMaxWidth()
                .background(color = EventCardColor),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(140.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = modifier.padding(bottom = 40.dp))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "имя",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = "Максим",
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
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "почта",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.padding(bottom = 12.dp))
                TextField(
                    modifier = modifier.fillMaxWidth(),
                    value = "mail5@mail.ru",
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
                            text = "компания",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = modifier.padding(bottom = 12.dp))
                        TextField(
                            value = "Яндекс",
                            label = { Text(text = "компания") },
                            onValueChange = { job = it },
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
                            text = "должность",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = modifier.padding(bottom = 12.dp))
                        TextField(
                            value = "Android-developer",
                            label = { Text(text = "долджность") },
                            onValueChange = { jobTitle = it },
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
            Box(modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = modifier.padding(vertical = 40.dp, horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = modifier.fillMaxWidth(),
                        onClick = { findNavController().popBackStack() },
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
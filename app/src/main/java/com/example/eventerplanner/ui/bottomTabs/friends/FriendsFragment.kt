package com.example.eventerplanner.ui.bottomTabs.friends

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.findNavController
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.LightGray
import com.example.eventerplanner.presentation.theme.LighterGray
import com.example.eventerplanner.ui.common.DefaultHeader
import com.example.eventerplanner.ui.common.SearchComponent
import kotlinx.coroutines.launch

class FriendsFragment : Fragment() {

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

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MainContent(modifier: Modifier = Modifier) {

        var showBoris by remember {
            mutableStateOf(false)
        }
        val sheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = sheetState
        )
        val scope = rememberCoroutineScope()

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {

                var name by remember { mutableStateOf("") }
                var mail by remember { mutableStateOf("") }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column() {
                        Row(
                            modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 20.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                modifier = modifier.clickable { scope.launch { sheetState.collapse() } },
                                painter = painterResource(id = R.drawable.ic_cancel),
                                contentDescription = null
                            )
                        }
                        Row(
                            modifier
                                .fillMaxWidth()
                                .padding(top = 23.dp, end = 20.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Новый друг",
                                fontSize = 22.sp
                            )
                        }
                        Spacer(modifier.padding(40.dp))
                        TextField(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
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
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            value = mail,
                            label = { Text(text = "телефон") },
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

                        Spacer(modifier = modifier.height(60.dp))
                        Button(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            onClick = {
                                showBoris = true
                                scope.launch { sheetState.collapse() }
                                      },
                            colors = ButtonDefaults.buttonColors(backgroundColor = FirstTitle),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = "Добавить",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = modifier.height(20.dp))
                    }

                }
            },
            sheetBackgroundColor = Color.White,
            sheetPeekHeight = 0.dp
        ) {
            Column(modifier.verticalScroll(rememberScrollState())) {
                DefaultHeader(
                    title = "МОИ ДРУЗЬЯ",
                    icon = painterResource(id = R.drawable.baseline_add_24),
                    onClick = {
                        scope.launch {
                            if(sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }
                )
                SearchComponent(modifier)
                ABlock(modifier)
                Spacer(modifier.padding(20.dp))
                if (showBoris) {
                    BBlock(modifier)

                }

            }
        }
    }

    @Composable
    fun ABlock(modifier: Modifier) {
        Column(modifier = modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)) {
            Text(
                text = "A",
                fontSize = 20.sp
            )
            Divider(
                modifier = modifier.fillMaxWidth(),
                thickness = 1.dp
            )
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 12.dp)
            ) {
                Text(text = "Андрей Андреев", fontSize = 14.sp)
                Spacer(modifier.padding(10.dp))
                Text(text = "+7 920 202 20 20", fontSize = 14.sp, color = LightGray)
            }
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 12.dp)
            ) {
                Text(text = "Андрей Васильев", fontSize = 14.sp)
                Spacer(modifier.padding(10.dp))
                Text(text = "+7 920 202 20 55", fontSize = 14.sp, color = LightGray)
            }
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 12.dp)
            ) {
                Text(text = "Антон Антонов", fontSize = 14.sp)
                Spacer(modifier.padding(10.dp))
                Text(text = "+7 920 000 20 55", fontSize = 14.sp, color = LightGray)
            }
        }
    }

    @Composable
    fun BBlock(modifier: Modifier) {
        Column(modifier = modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)) {
            Text(
                text = "B",
                fontSize = 20.sp
            )
            Divider(
                modifier = modifier.fillMaxWidth(),
                thickness = 1.dp
            )
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 12.dp)
            ) {
                Text(text = "Boris Borisov", fontSize = 14.sp)
                Spacer(modifier.padding(10.dp))
                Text(text = "+7 930 300 30 30", fontSize = 14.sp, color = LightGray)
            }

        }
    }
}
package com.example.eventerplanner.ui.bottomTabs.profile

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventCardColor
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.Gray

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                    ProfileScreen()
                }
            }
        }
    }

    @Composable
    fun ProfileScreen(modifier: Modifier = Modifier) {
        Column(modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 1.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 19.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = modifier.clickable { findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment) },
                    text = "изменить",
                    fontSize = 14.sp,
                    color = FirstTitle
                )
            }

            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = modifier) {
                    ProfileTitleBlock()
                    Spacer(modifier.height(20.dp))
                    SystemSettingsBlock()
                }
            }
        }
    }
    @Composable
    fun ProfileTitleBlock(modifier: Modifier = Modifier) {
        Card(
            modifier = modifier.padding(bottom = 18.dp),
            elevation = 16.dp,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            backgroundColor = EventCardColor
        ) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_left_profile_shape),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_right_profile_shape),
                        contentDescription = null
                    )
                }

                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_avatar),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = modifier.height(40.dp))
                    Column(
                        modifier = modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "МАКСИМ КОТЛЯКОВ",
                            fontSize = 18.sp
                        )
                        Spacer(modifier.height(10.dp))
                        Text(
                            text = "+7 999 999 99 99",
                            fontSize = 14.sp,
                            color = Gray
                        )
                        Spacer(modifier.height(20.dp))
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 90.dp, end = 90.dp, bottom = 18.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Яндекс",
                                fontSize = 14.sp
                            )
                            Text(
                                text = "Android-developer",
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun SystemSettingsBlock(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(horizontal = 20.dp, vertical = 21.dp)) {
            DefaultRow(text = "вложения", iconId = R.drawable.ic_attached)
            DefaultRow(text = "конфиденциальность", iconId = R.drawable.ic_secure)
            DefaultRow(text = "язык", iconId = R.drawable.ic_language)
            DefaultRow(text = "о приложении", iconId = R.drawable.ic_about_app)
        }
    }

    @Composable
    fun DefaultRow(
        text: String,
        iconId: Int,
        modifier: Modifier = Modifier
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 20.dp)
        ) {
            Box(contentAlignment = Alignment.CenterStart) {
                Row() {
                    Icon(painter = painterResource(id = iconId), contentDescription = null)
                    Spacer(Modifier.width(20.dp))
                    Text(
                        text = text,
                        fontSize = 16.sp
                    )
                }

            }
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = null)
            }
        }

    }
}
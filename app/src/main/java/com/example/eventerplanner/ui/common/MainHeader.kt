package com.example.eventerplanner.ui.common

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.FirstTitle
import com.example.eventerplanner.presentation.theme.LightGray

@Composable
fun DefaultHeader(
    title: String,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 25.dp, end = 43.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 22.sp
            )
            HeaderIconAdd(onClick, icon)
        }
        Spacer(modifier = modifier.height(19.dp))
        Divider(
            modifier = modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = LightGray
        )
    }
}

@Composable
fun HeaderIconAdd(onClick: () -> Unit,  icon: Painter, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .size(36.dp)
        .clip(shape = RoundedCornerShape(percent = 50))
        .background(color = FirstTitle)
        .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun ShowPreview() {
    DefaultHeader(title = "МОИ МЕРОПРИЯТИЯ", icon = painterResource(id = R.drawable.ic_add), onClick = {})
}
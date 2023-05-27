package com.example.eventerplanner.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchComponent(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    Box(modifier = modifier.padding(start = 30.dp, top = 20.dp, end = 30.dp, bottom = 40.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(fontSize = 20.sp),
            label = { Text(text = "поиск") },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
        )
    }
}
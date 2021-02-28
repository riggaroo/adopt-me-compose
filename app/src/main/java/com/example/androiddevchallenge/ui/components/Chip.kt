package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.orangeButtonLight
import com.example.androiddevchallenge.ui.theme.orangeText

@Composable
fun Chip(text: String,
         color: Color,
         textColor: Color,
         modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
        .height(24.dp)
        .clip(RoundedCornerShape(CornerSize(12.dp),CornerSize(12.dp),CornerSize(12.dp),CornerSize(12.dp)))
        .background(color),
        contentAlignment = Alignment.Center)
    {
        Text(text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp),
            style = MaterialTheme.typography.caption,
            color = textColor)
    }

}

@Preview
@Composable
fun ChipPreview() {
    Chip("Hello Chip", orangeButtonLight, orangeText)
}
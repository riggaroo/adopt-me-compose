package com.example.androiddevchallenge

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PetRepository
import com.example.androiddevchallenge.data.dog3
import com.example.androiddevchallenge.ui.theme.outlineColor
import com.example.androiddevchallenge.ui.theme.veryLightGray
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetCardListItem(pet: Pet, onPetClick: (Pet) -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp, top = 4.dp, bottom = 8.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onPetClick(pet)
                       },
        elevation = 8.dp,
        border = BorderStroke(1.dp, MaterialTheme.colors.outlineColor)
    ) {

        Column {
            CoilImage(
                data = pet.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
            )
            Text(
                pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp)
            )
            Text(
                pet.breed,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PetPreview(){
    PetCardListItem(pet = dog3, onPetClick = {  })
}
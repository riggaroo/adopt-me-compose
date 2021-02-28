package com.example.androiddevchallenge.listing

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Gender
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.PetLabel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.dog3
import com.example.androiddevchallenge.ui.components.Chip
import com.example.androiddevchallenge.ui.theme.orangeButtonLight
import com.example.androiddevchallenge.ui.theme.orangeText
import com.example.androiddevchallenge.ui.theme.outlineColor
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.purpleButtonLight
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
                fadeIn = true,
                data = pet.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                when (pet.label) {
                    PetLabel.Puppy -> {
                        Chip("Puppy",
                            color = purpleButtonLight,
                            textColor = purple500,
                        modifier = Modifier.padding(start  = 8.dp, top = 8.dp))
                    }
                    PetLabel.Adult -> {
                        Chip("Adult",
                            color = orangeButtonLight,
                            textColor = orangeText,
                            modifier = Modifier.padding(start  = 8.dp, top = 8.dp))
                    }
                }
                if (pet.gender == Gender.Male){
                    Image(painterResource(R.drawable.ic_male),
                        "male",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
                    )
                } else if (pet.gender == Gender.Female){
                    Image(painterResource(R.drawable.ic_female),
                        contentDescription = "female",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                    )
                }
            }
            Text(
                pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
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
/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.purpleButtonLight
import com.google.accompanist.coil.rememberCoilPainter

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
            Image(
                painter = rememberCoilPainter(
                    request = pet.imageUrl,
                    fadeIn = true
                ),
                contentDescription = null,
                modifier = Modifier.height(180.dp).fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                when (pet.label) {
                    PetLabel.Puppy -> {
                        Chip(
                            "Puppy",
                            color = purpleButtonLight,
                            textColor = purple500,
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                        )
                    }
                    PetLabel.Adult -> {
                        Chip(
                            "Adult",
                            color = orangeButtonLight,
                            textColor = orangeText,
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                        )
                    }
                }
                if (pet.gender == Gender.Male) {
                    Image(
                        painterResource(R.drawable.ic_male),
                        "male",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
                    )
                } else if (pet.gender == Gender.Female) {
                    Image(
                        painterResource(R.drawable.ic_female),
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
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                fontWeight = FontWeight.SemiBold
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
fun PetPreview() {
    PetCardListItem(pet = dog3, onPetClick = { })
}

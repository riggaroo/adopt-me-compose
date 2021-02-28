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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.dog
import com.example.androiddevchallenge.data.dog3
import com.example.androiddevchallenge.data.dog4

@Composable
fun PetListingScreen(navController: NavController, viewModel: PetListingViewModel) {
    val pets = viewModel.petsData.observeAsState(emptyList())
    PetListScreenContent(pets = pets.value) { pet ->
        navController.navigate(Screen.PetDetailsScreen(pet.id).getCalculatedRoute())
    }
}
@Preview
@Composable
fun PetListPreview(){
    PetListScreenContent(pets = listOf(dog, dog3, dog4), onPetSelected = { /*TODO*/ })
}

@Composable
fun PetListScreenContent(pets: List<Pet>, onPetSelected: (Pet) -> Unit){
    Surface(color = MaterialTheme.colors.background) {
        Column() {
            Row(
                modifier = Modifier.height(80.dp).fillMaxWidth().padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.pet_adopt_title),
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 32.dp,
                        bottom = 8.dp
                    )
                )
                val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.french_bulldog) }
                LottieAnimation(
                    animationSpec,
                    modifier = Modifier.fillMaxSize()
                )
            }

            PetGrid(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp
                ),
                pets
            ) { pet ->
                onPetSelected(pet)
            }
        }
    }
}
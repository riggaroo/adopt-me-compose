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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.time.ZoneId
import java.time.ZonedDateTime
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<AdoptionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel = viewModel)
            }
        }
    }
}

class AdoptionViewModel : ViewModel() {
    private val _petsData = MutableLiveData<List<Pet>>()
    val petsData: LiveData<List<Pet>>
        get() = _petsData

    init {
        // TODO This should come from a webservice if it was a real app :)
        val dog = Pet(
            "1",
            "Basil",
            PetType.Dog,
            "https://images.unsplash.com/photo-1518378188025-22bd89516ee2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
            Gender.Male,
            2.2f,
            "Cross",
            LongLatLocation(25.3f, 23.12f),
            ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
        )

        val pickle = Pet(
            "2",
            "Pickle",
            PetType.Dog,
            "https://images.unsplash.com/photo-1598133894008-61f7fdb8cc3a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
            Gender.Female,
            2.0f,
            "Cross",
            LongLatLocation(25.3f, 23.12f),
            ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
        )

        _petsData.value = listOf(dog, pickle)
    }
}

// Start building your app here!
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(viewModel: AdoptionViewModel = AdoptionViewModel()) {
    val pets = viewModel.petsData.observeAsState(emptyList())
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            content = {
                items(pets.value.size) { index ->
                    PetCard(pet = pets.value[index])
                }
            })
    }
}

@Composable
fun PetCard(pet: Pet) {
    Card(modifier = Modifier.padding(4.dp)) {
        CoilImage(
            data = pet.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(180.dp)
        )
        Column() {
            Text(
                pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                pet.breed,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

data class Pet(
    val id: String,
    val name: String,
    val type: PetType,
    val imageUrl: String,
    val gender: Gender,
    val weightKg: Float,
    val breed: String,
    val location: LongLatLocation,
    val dateOfBirth: ZonedDateTime
)

enum class PetType {
    Dog,
    Cat,
    Bunny
}

enum class Gender {
    Male,
    Female,
    NotSpecified
}

data class LongLatLocation(
    val longitude: Float,
    val latitude: Float
)
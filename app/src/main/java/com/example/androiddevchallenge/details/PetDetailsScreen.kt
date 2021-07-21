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
package com.example.androiddevchallenge.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.age
import com.example.androiddevchallenge.data.dog
import com.example.androiddevchallenge.data.dog3
import com.example.androiddevchallenge.details.mvi.PetDetailsEvent
import com.example.androiddevchallenge.details.mvi.PetDetailsModel
import com.example.androiddevchallenge.details.mvi.PetDetailsViewEffect
import com.example.androiddevchallenge.details.mvi.ViewState
import com.example.androiddevchallenge.details.ui.AboutSection
import com.example.androiddevchallenge.details.ui.AdoptButtonBar
import com.example.androiddevchallenge.details.ui.Location
import com.example.androiddevchallenge.details.ui.PetCardInformation
import com.example.androiddevchallenge.mobius.DisposableViewEffect
import com.example.androiddevchallenge.mobius.MobiusEvent
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.ui.theme.outlineColor
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purpleButtonLight
import com.google.accompanist.coil.rememberCoilPainter

typealias PetEventDelegate = (PetDetailsEvent) -> Unit

val LocalDispatcher = compositionLocalOf<PetEventDelegate> { error("No active dispatcher found!") }

@Composable
fun PetDetailsScreen(navController: NavController, petId: String, viewModel: PetDetailsViewModel) {
    LaunchedEffect(petId) {
        viewModel.dispatchEvent(PetDetailsEvent.LoadPet(petId))
    }
    val context = LocalContext.current
    val dispatchEvent = { event: PetDetailsEvent ->
        viewModel.dispatchEvent(event)
    }

    viewModel.viewEffects.DisposableViewEffect { effect ->
        handleViewEffect(context = context, navController = navController, effect = effect)
    }
    val viewState = viewModel.models.observeAsState(PetDetailsModel())
    CompositionLocalProvider(LocalDispatcher provides dispatchEvent) {
        PetDetailsViewStates(viewState = viewState.value)
    }
}

private fun handleViewEffect(
    context: Context,
    navController: NavController,
    effect: PetDetailsViewEffect
) {
    when (effect) {
        is PetDetailsViewEffect.OpenAdoptUrl -> {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(effect.url)
            )
            context.startActivity(intent)
        }
        is PetDetailsViewEffect.OpenAndroidDialer -> {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse(effect.phoneNumber)
            )
            context.startActivity(intent)
        }
        is PetDetailsViewEffect.CloseScreen -> navController.popBackStack()
    }
}

@Composable
fun PetDetailsViewStates(
    viewState: PetDetailsModel
) {
    when (viewState.viewState) {
        ViewState.LOADING -> {
           LoadingState()
        }
        ViewState.LOADED -> {
            LoadedState(viewState = viewState)
        }
    }
}
@Composable
fun LoadedState(viewState: PetDetailsModel) {
    val pet = viewState.pet
    if (pet != null) {
        PetDetails(
            pet = pet
        )
    } else {
        Text(text = "Pet not found")
    }
}

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun PetDetails(pet: Pet) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = rememberCoilPainter(
                    request = pet.imageUrl,
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(32.dp),
                            bottomStart = CornerSize(32.dp)
                        )
                    )
            )
            PetCardInformation(pet = pet)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = pet.name,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 0.dp
                    )
                )
                Text(
                    text = pet.breed,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 0.dp
                    ),
                    textAlign = TextAlign.End
                )
            }
            Location(pet = pet)
            AboutSection(pet = pet)
        }
        val dispatcher = LocalDispatcher.current
        Icon(
            Icons.Filled.ArrowBack, "back",
            modifier = Modifier
                .size(48.dp)
                .clickable {
                    dispatcher(PetDetailsEvent.BackPressed)
                }
                .padding(12.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            AdoptButtonBar(
                onAdoptClicked = {
                    dispatcher(PetDetailsEvent.AdoptClicked)
                },
                onCallClicked = {
                    dispatcher(PetDetailsEvent.CallClicked)
                }
            )
        }
    }
}


@Preview()
@Composable
fun PreviewPetDetails() {
    PetTheme {
        PetDetails(pet = dog)
    }
}

@Preview()
@Composable
fun PreviewPetDetailsDarkTheme() {
    PetTheme(darkTheme = true) {
        PetDetails(pet = dog3)
    }
}
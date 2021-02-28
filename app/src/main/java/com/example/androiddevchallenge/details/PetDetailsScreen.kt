package com.example.androiddevchallenge.details

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Pin
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.dog
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.purpleButtonLight
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetDetailsScreen(navController: NavController, petId: String, viewModel: PetDetailsViewModel) {
    // todo double check how to run something "onCreate" of the view only once.
    viewModel.loadPetInfo(petId = petId)
    Surface(color = MaterialTheme.colors.background) {
        val petState = viewModel.petData.observeAsState()
        if (petState.value != null) {
            val pet = petState.value!!
            PetDetails(pet = pet, onBackPress = { navController.popBackStack() })
        } else {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun PreviewPetDetails(){
    PetDetails(pet = dog, onBackPress = { /*TODO*/ })
}

@Composable
fun PetDetails(pet: Pet, onBackPress : () -> Unit){
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        CoilImage(
            data = pet.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
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
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
            )
            Text(text = pet.breed,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp),
                textAlign = TextAlign.End
            )
        }
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Outlined.Place, null,
                modifier = Modifier
                    .width(16.dp)
                    .padding(end = 2.dp, top = 2.dp)
            )
            Text(text = pet.location,
                style = MaterialTheme.typography.body1,
            )
        }
        Text(text = stringResource(id = R.string.about_pet_heading),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(text = pet.description,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(64.dp))
    }
    Icon(Icons.Filled.ArrowBack, "back",
        modifier = Modifier
            .size(48.dp)
            .clickable {
                onBackPress()
            }
            .padding(12.dp))
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom) {
        AdoptButtonBar()
    }
}


@Composable
fun AdoptButtonBar(){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start) {
        Button(
            modifier = Modifier
                .padding(16.dp)
                .weight(4f)
                .height(52.dp),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.adopt_button_title))
        }
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = purpleButtonLight),
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .weight(1f)
                .wrapContentWidth()
                .height(52.dp),
            onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Phone, "phone",
                tint = purple200,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp))
        }
    }
}
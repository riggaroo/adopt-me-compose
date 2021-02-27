package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.ZoneId
import java.time.ZonedDateTime

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

        val dog3 =  Pet(
            "3",
            "Spartan",
            PetType.Dog,
            "https://images.unsplash.com/photo-1503256207526-0d5d80fa2f47?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1233&q=80",
            Gender.Male,
            3.0f,
            "Border Collie",
            LongLatLocation(25.3f, 23.12f),
            ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
        )

        _petsData.value = listOf(dog, pickle, dog3)
    }
}
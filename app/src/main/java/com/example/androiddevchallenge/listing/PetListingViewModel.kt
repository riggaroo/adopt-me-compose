package com.example.androiddevchallenge.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.data.PetRepository
import kotlinx.coroutines.launch

class PetListingViewModel : ViewModel() {

    // FIXME - Real life this would use Dependency injection
    private val petRepository = PetRepository()

    private val _petsData = MutableLiveData<List<Pet>>()
    val petsData: LiveData<List<Pet>>
        get() = _petsData

    init {
        viewModelScope.launch {
            _petsData.value = petRepository.getListPets()
        }
    }
}
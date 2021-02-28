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

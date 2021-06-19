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

import com.example.androiddevchallenge.listing.mobius.PetListEffect
import com.example.androiddevchallenge.listing.mobius.PetListEvent
import com.example.androiddevchallenge.listing.mobius.PetListViewEffect
import com.example.androiddevchallenge.listing.mobius.PetModelInit
import com.example.androiddevchallenge.listing.mobius.PetModelUpdate
import com.example.androiddevchallenge.listing.mobius.PetSideEffectHandler
import com.example.androiddevchallenge.mobius.ViewEffectConsumer
import com.example.androiddevchallenge.mobius.WorkRunnersConstants
import com.example.androiddevchallenge.usecase.PetUseCase
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.android.MobiusLoopViewModel
import com.spotify.mobius.runners.WorkRunner
import com.spotify.mobius.rx3.RxMobius
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named
import com.spotify.mobius.functions.Function as MobiusFunction

@HiltViewModel
class PetListingViewModel @Inject constructor(
    val petUseCase: PetUseCase,
    @Named(WorkRunnersConstants.MAIN_THREAD_WORK_RUNNER) workRunner: WorkRunner
) : MobiusLoopViewModel<PetListModel, PetListEvent, PetListEffect, PetListViewEffect>(
    MobiusFunction<ViewEffectConsumer<PetListViewEffect>, MobiusLoop.Factory<PetListModel, PetListEvent, PetListEffect>> {
        val sideEffectHandler = PetSideEffectHandler(petUseCase = petUseCase)
        RxMobius.loop(
            PetModelUpdate(it),
            sideEffectHandler
        )
    },
    PetListModel(),
    PetModelInit(),
    workRunner,
    10
)

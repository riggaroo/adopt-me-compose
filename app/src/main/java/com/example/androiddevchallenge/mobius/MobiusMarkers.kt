package com.example.androiddevchallenge.mobius

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.spotify.mobius.android.MobiusLoopViewModel
import com.spotify.mobius.functions.Consumer


interface MobiusEffect

interface MobiusViewEffect

interface MobiusEvent

interface MobiusModel

typealias ViewEffectConsumer<T> = Consumer<T>

interface MobiusView<Model : MobiusModel, ViewEffect : MobiusViewEffect> {

    /**
     * Override this method to handle [MobiusViewEffect] emitted from [MobiusLoopViewModel].
     * [MobiusViewEffect] are emitted only once, using [com.spotify.mobius.android.LiveQueue], so these should be used for things like showing toasts/dialogs, navigation events, etc.
     */
    fun handleViewEffect(viewEffect: ViewEffect) {
        throw IllegalStateException("handleViewEffect not implemented")
    }

    /**
     * Call this method to automatically subscribe this view to the provided [MobiusLoopViewModel.getViewEffects].
     * Warning: only ONE subscriber is supported at a time, since [MobiusViewEffect] are supposed to be consumed only once by a specific view.
     *
     * This helper method will use [handleViewEffect] for handling view effects while [lifecycleOwner] is resumed.
     * When [lifecycleOwner] is paused, view effects are queued. Once [lifecycleOwner] is resumed, [handleViewEffect] will be invoked for each queued view effect.
     *
     * It's probably best to call it in `onViewCreated()` of `Fragment` or inside `onCreate()` for an `Activity`.
     */
    @CallSuper
    fun subscribeToViewEffects(
        lifecycleOwner: LifecycleOwner,
        viewModel: MobiusLoopViewModel<Model, out MobiusEvent, out MobiusEffect, ViewEffect>
    ) {
        viewModel.viewEffects.setObserver(lifecycleOwner, Observer(this::handleViewEffect), Observer { it.forEach(this::handleViewEffect) })
    }
}
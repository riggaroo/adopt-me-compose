package com.example.androiddevchallenge.mobius

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Observer
import com.spotify.mobius.android.LiveQueue

/**
 * Subscribes (and unsubscribes) to ViewEffects inside a Composable hierarchy.
 * Starts observing this LiveQueue and receives events via onViewEffect. Every time there would be new value posted into the
 * LiveQueue, the onViewEffect callback will be called.
 *
 * The inner observer will automatically be removed when this composable
 * disposes or the current LifecycleOwner moves to the Lifecycle.State.DESTROYED state.
 *
 * This pattern is similar to LiveData.observeAsState() method exposed from the Android Library.
 */
@Composable
fun <T : MobiusViewEffect> LiveQueue<T>.DisposableViewEffect(onViewEffect: (T) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(this, lifecycleOwner) {
        val observer = Observer<T> { onViewEffect(it) }
        setObserver(lifecycleOwner, observer)
        onDispose {
            clearObserver()
        }
    }
}

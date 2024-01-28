package com.kashif.yeeehhaaa

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import lifecycleRegistry.LifecycleRegistry
import lifecycleRegistry.lifecycleCallBack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
        initiateLifecycleObserver()

    }

    /**
     * A lifecycle observer to track lifecycle events
     */
    private fun initiateLifecycleObserver() {
        val lifeCycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> lifecycleCallBack(LifecycleRegistry.onResume)

                Lifecycle.Event.ON_PAUSE -> lifecycleCallBack(LifecycleRegistry.onPause)

                Lifecycle.Event.ON_CREATE -> lifecycleCallBack(LifecycleRegistry.onCreate)
                Lifecycle.Event.ON_STOP -> lifecycleCallBack(LifecycleRegistry.onStop)

                Lifecycle.Event.ON_DESTROY -> lifecycleCallBack(LifecycleRegistry.onDestroy)

                Lifecycle.Event.ON_START -> lifecycleCallBack(LifecycleRegistry.onStart)
                Lifecycle.Event.ON_ANY -> lifecycleCallBack(LifecycleRegistry.onAny)
            }
        }
        lifecycle.addObserver(lifeCycleObserver)
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
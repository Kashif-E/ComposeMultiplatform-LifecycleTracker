package lifecycleRegistry

/**
 *
 * An enum class that contains lifecycle events
 */
enum class LifecycleRegistry {
    onCreate, onStart, onResume, onPause, onStop, onDestroy, onAny
}

/**
 * This function takes an event as parameter which is passed from other platform
 */
fun lifecycleCallBack(event: LifecycleRegistry) {

    println(event.name)
}

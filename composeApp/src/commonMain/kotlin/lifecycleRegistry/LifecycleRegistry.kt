package lifecycleRegistry

enum class LifecycleRegistry {
    onCreate, onStart, onResume, onPause, onStop, onDestroy,onAny
}

fun lifecycleCallBack(event: LifecycleRegistry) {

    println(event.name)
}

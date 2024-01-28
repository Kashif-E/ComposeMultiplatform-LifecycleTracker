import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import androidx.compose.ui.window.ComposeUIViewController
import lifecycleRegistry.LifecycleRegistry
import lifecycleRegistry.lifecycleCallBack

fun MainViewController() = ComposeUIViewController(configure = {
    /**
     * A delegate to track composeViewControllers lifecycle callbacks
     */
    delegate = object : ComposeUIViewControllerDelegate {
        override fun viewDidAppear(animated: Boolean) {
            super.viewDidAppear(animated)
            lifecycleCallBack(LifecycleRegistry.onResume)
        }

        override fun viewDidLoad() {
            super.viewDidLoad()
            lifecycleCallBack(LifecycleRegistry.onCreate)
        }

        override fun viewWillDisappear(animated: Boolean) {
            super.viewWillDisappear(animated)
            lifecycleCallBack(LifecycleRegistry.onPause)
        }

        override fun viewWillAppear(animated: Boolean) {
            super.viewWillAppear(animated)
            lifecycleCallBack(LifecycleRegistry.onStart)
        }

        override fun viewDidDisappear(animated: Boolean) {
            super.viewDidDisappear(animated)
            lifecycleCallBack(LifecycleRegistry.onDestroy)
        }
    }
}) { App() }

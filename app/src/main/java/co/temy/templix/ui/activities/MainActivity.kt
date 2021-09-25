package co.temy.templix.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import co.temy.templix.R
import co.temy.templix.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    fun navigateTo(screen: Fragment, tag: String? = null){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, screen, tag)
            .commitNow()
    }
}

fun Fragment.requireMainActivity() = requireActivity() as MainActivity

inline fun ComposeView.applyContent(crossinline content: @Composable () -> Unit) = apply {
    setContent { content() }
}

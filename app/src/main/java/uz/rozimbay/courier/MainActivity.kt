package uz.rozimbay.courier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import uz.rozimbay.courier.ui.RozimbayHomeScreen
import uz.rozimbay.courier.ui.theme.RozimbayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RozimbayTheme {
                RozimbayHomeScreen()
            }
        }
    }
}

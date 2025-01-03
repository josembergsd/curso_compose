package br.com.dnsistemas.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import br.com.dnsistemas.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeCatalogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //var myText by rememberSaveable { mutableStateOf("") } //Hosting para aproveitar o valor em mais de um lugar
                    //MyTextFieldHosting(myText) { myText = it }
                    //MyButtomExample()
                    //MyImage()
                   // val videoUri = Uri.parse("https://www.youtube.com/watch?v=83G5gomM5Ys") // Replace with your video URI
                   // VideoPlayer(videoUri)
                    //MyIcon()
                    //MyProgressBar()
                    MyVideoPlayer()
                }
            }
        }
    }
}

@Composable
fun MyVideoPlayer(){
    //val videoUri = Uri.parse("https://www.youtube.com/watch?v=83G5gomM5Ys") // Replace with your video URI
    val videoUri = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    Column {
//        YouTubePlayer(
//            youtubeVideoId = "83G5gomM5Ys",
//            lifecycleOwner = LocalLifecycleOwner.current,
//        )
//        Spacer(modifier = Modifier.height(16.dp))
        MyVideoPlayerExo(videoUri = videoUri)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeCatalogoTheme {
        //var myText by rememberSaveable { mutableStateOf("") } //Hosting para aproveitar o valor em mais de um lugar
        //MyTextFieldHosting(myText) { myText = it }
        MyVideoPlayer()
    }
}
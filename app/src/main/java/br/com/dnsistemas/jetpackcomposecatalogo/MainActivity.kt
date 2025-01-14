package br.com.dnsistemas.jetpackcomposecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnsistemas.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeCatalogoTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)) { innerPadding ->

                    val myOptions = getOptions(
                        listOf(
                            "Opção 1",
                            "Opção 2",
                            "Opção 3"
                        )
                    ) //Para multiplos checkboxes

                    Column {
                        //var myText by rememberSaveable { mutableStateOf("") } //Hosting para aproveitar o valor em mais de um lugar
                        //MyTextFieldHosting(myText) { myText = it }
                        //MyButtomExample()
                        //MyImage()
                        // val videoUri = Uri.parse("https://www.youtube.com/watch?v=83G5gomM5Ys") // Replace with your video URI
                        // VideoPlayer(videoUri)
                        //MyIcon()
                        //MyProgressBar()
                        //MyProgressAdvanced(innerPadding)
                        //MySwitch(
                        // innerPadding)
                        //MyCheckBox()
                        //MyCheckBoxWithText()
                        //MyCheckBoxWithText()
                        //######################################
//                        MyTriStatusCheckBox()
//                        myOptions.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }
                        //##########################
                        //var selected by remember { mutableStateOf("Josemberg") }
                        //MyRadioButton()
                        //MyRadioButtonList(selected) { selected = it }
                        //#########################################
                        //MyCard()
                        //MyBadgedBox()
                        //MyDivider()
                        //MyDropDownMenu()
                        //BasicSlider()
                        //AdvancedSlider()
                        //MyRangeSlider()
                        var showDialog by remember { mutableStateOf(false) }
                        var count: Int by remember { mutableStateOf(0) }
                       /* Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Button(onClick = { showDialog = true }) {
                                Text("Mostrar diálogo")
                            }
                            MyDialogs(
                                show = showDialog,
                                onDismiss = { showDialog = false },
                                onConfirm = {
                                    count++
                                    Log.i("DIALOG", "Click $count")
                                }
                            )
                        }
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Button(onClick = { showDialog = true }) {
                                Text("Mostrar diálogo simples")
                            }
                            MySimpleCustomDialog(
                                show = showDialog,
                                onDismiss = { showDialog = false },
                            )
                        }
                        */
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Button(onClick = { showDialog = true }) {
                                Text("Mostrar confirm dialog")
                            }
                            //MyPersonalizedDialog(show = showDialog, onDismiss = { showDialog = false })
                            MyConfirmationDialog(show = showDialog, onDismiss = { showDialog = false })
                        }
                        //MyVideoPlayer()
                    }
                }
            }
        }
    }
}

@Composable
fun getOptions(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = "Exemplo 1",
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyVideoPlayer() {
    //val videoUri = Uri.parse("https://www.youtube.com/watch?v=83G5gomM5Ys") // Replace with your video URI
    val videoUri =
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    Column {
//        YouTubePlayer(
//            youtubeVideoId = "83G5gomM5Ys",
//            lifecycleOwner = LocalLifecycleOwner.current,
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        MyVideoPlayerExo(videoUri = videoUri)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeCatalogoTheme {
        //var myText by rememberSaveable { mutableStateOf("") } //Hosting para aproveitar o valor em mais de um lugar
        //MyTextFieldHosting(myText) { myText = it }
        //MyVideoPlayer()
        //MyProgressBar()
        //MyCheckBox()
        MyCheckBoxWithText()
    }
}
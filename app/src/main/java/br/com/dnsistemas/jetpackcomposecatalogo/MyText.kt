package br.com.dnsistemas.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
        LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp))
    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icone",
        tint = Color.Red
    )
}

@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Descrição da imagem",
        Modifier
            .alpha(0.5f)
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyButtomExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.Magenta
            ),
            border = BorderStroke(2.dp, Color.Green)
        ) {
            Text("Holá")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.Magenta
            )
        ) {
            Text("Holá")
        }

        TextButton(onClick = { }) {
            Text("Text Button")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        label = { Text("Digite seu nome") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Red

        )
    )
}

@Composable
fun MyTextFieldAvancado() {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
        },
        Modifier.fillMaxWidth(),
        label = { Text("Digite seu nome") })
}

@Composable
fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it }, Modifier.fillMaxWidth())
}

@Composable
fun MyTextFieldHosting(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged }, Modifier.fillMaxWidth())
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text("Exemplo simples")
        Text("Exemplo text color", color = Color.Red)
        Text("Exemplo de fontWeight", fontWeight = FontWeight.ExtraBold)
        Text("Exemplo de fonteWeight", fontWeight = FontWeight.Light)
        Text("Exemplo de fonteFamily", fontFamily = FontFamily.Cursive)
        Text(
            "Exemplo de style: tipo e tamanho",
            style = TextStyle(fontFamily = FontFamily.Cursive, fontSize = 20.sp)
        )
        Text(
            "Exemplo de decoration",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text("Exemplo de decoration", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            "Exemplo de decoration: combine", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text("Exemplo tamanho de fonte: 28", fontSize = 28.sp)
        Text("Exemplo simples")
    }
}

@Composable
fun MyVideoPlayerExo(
    videoUri: String
) {
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(videoUri))
    }
    val playerView = PlayerView(context)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    playerView.player = player
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
    }
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = {
            playerView
        })
}

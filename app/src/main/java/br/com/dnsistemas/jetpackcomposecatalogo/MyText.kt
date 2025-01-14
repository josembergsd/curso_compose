package br.com.dnsistemas.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
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
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var options = listOf("Opção 1", "Opção 2", "Opção 3")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
                .padding(8.dp),
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        expanded = false
                        selectedText = option
                    }
                )
            }
        }
    }
}

@Composable
fun MyDivider() {
    HorizontalDivider(Modifier.fillMaxWidth().padding(top = 16.dp), color = Color.Red)
    VerticalDivider(Modifier.fillMaxHeight(), color = Color.Red)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgedBox() {
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Badge(containerColor = Color.Cyan) {
                val badgeNumber = "13"
                Text(badgeNumber, modifier = Modifier
                    .semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })
            }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star",
            tint = Color.Blue
        )
    }
}


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = Color.Green
        ),
        elevation = CardDefaults.cardElevation(
            disabledElevation = 4.dp,
            defaultElevation = 16.dp,
            pressedElevation = 8.dp,
            focusedElevation = 24.dp,
            hoveredElevation = 4.dp,
            draggedElevation = 15.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Exemplo 1")
            Text("Exemplo 2")
            Text("Exemplo 3")
            Text("Exemplo 4")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Josemberg", onClick = { onItemSelected("Josemberg") })
            Text("Josemberg")
        }
        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Luciana", onClick = { onItemSelected("Luciana") })
            Text("Luciana")
        }
        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Ian Lucas", onClick = { onItemSelected("Ian Lucas") })
            Text("Ian Lucas")
        }
        Row(Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Analú", onClick = { onItemSelected("Analú") })
            Text("Analú")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(
        Modifier.fillMaxWidth()
    ) {
        RadioButton(
            selected = false,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Green,
            )
        )
        Text("Exemplo RadioButton")
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        when (status) {
            ToggleableState.Off -> status = ToggleableState.Off
            ToggleableState.On -> status = ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> status = ToggleableState.Off
        }
    })
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text("Exemplo 1")
    }
}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text("Exemplo 1")
    }
}


@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Blue
        )

    )
}

@Composable
fun MySwitch(innerPadding: PaddingValues) {
    var state by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Blue,
            uncheckedTrackColor = Color.Yellow,
            checkedTrackColor = Color.Cyan
        )
    )
}

@Composable
fun MyProgressAdvanced(innerPadding: PaddingValues) {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = { progressStatus },
        )
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text("Incrementar")
            }
            Button(onClick = {
                if (progressStatus >= 0) progressStatus -= 0.1f
            }) {
                Text("Decrementar")
            }
        }

    }
}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Exibir progress")
        }
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
        }
    )
}

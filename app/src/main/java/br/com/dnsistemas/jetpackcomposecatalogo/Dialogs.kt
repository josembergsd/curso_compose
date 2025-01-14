package br.com.dnsistemas.jetpackcomposecatalogo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
    if(show) {
        Dialog(
            onDismissRequest = {  onDismiss() },

        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Phone ringtone", Modifier.padding(6.dp), 24)
                HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by remember { mutableStateOf( "") }
                MyRadioButtonList(status) { status = it }
                HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = { onDismiss() }) {
                        Text("CANCEL")
                    }
                    TextButton(onClick = { onDismiss() }) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@Composable
fun MyPersonalizedDialog(
    show: Boolean,
    onDismiss: () -> Unit = {}
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Configure uma conta de backup", Modifier.padding(24.dp), 24)
                AccountItem("dnsistemas@gmail.com", R.drawable.avatar)
                AccountItem("josembergsduarte@gmail.com", R.drawable.avatar)
                AccountItem("Nova conta", R.drawable.add)
            }
        }

    }

}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text= email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(texto: String, modifier: Modifier = Modifier.padding(bottom = 6.dp), size: Int) {
    Text(
        modifier = modifier,
        text = texto,
        fontWeight = FontWeight.SemiBold,
        fontSize = size.sp,
    )
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit = {}
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text("Este é o diálogo simples")
                Text("Este é o diálogo simples")
                Text("Este é o diálogo simples")
            }
        }
    }

}

@Composable
fun MyDialogs(
    show: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("I am the title") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text("Positive")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("Negative")
                }
            },
            text = { Text("This is the message") }
        )
    }
}


package br.com.dnsistemas.jetpackcomposecatalogo

import android.net.Uri
import android.os.Looper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer (videoUri: Uri) {
    val context = LocalContext.current
    var exoPlayer by remember { mutableStateOf<androidx.media3.exoplayer.ExoPlayer?>(null) }

    // Create ExoPlayer instance
    LaunchedEffect(videoUri) {
        exoPlayer = androidx.media3.exoplayer.ExoPlayer.Builder(context).build().apply {
            setMediaItem(androidx.media3.common.MediaItem.fromUri(videoUri))
            fun run() {
                if (Looper.myLooper() == null) {
                    Looper.prepare()
                }
            }
            playWhenReady = true // Autoplay
            Looper.loop()
        }
    }

    // Dispose ExoPlayer when the composable leaves the composition
    DisposableEffect(exoPlayer) {
        onDispose {
            exoPlayer?.release()
        }
    }

    // Display the video using PlayerView
    AndroidView(factory = { context ->
        androidx.media3.ui.PlayerView(context).apply {
            player = exoPlayer
        }
    })
}
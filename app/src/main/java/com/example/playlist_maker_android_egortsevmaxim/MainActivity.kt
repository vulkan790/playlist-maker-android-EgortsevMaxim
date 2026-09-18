package com.example.playlist_maker_android_egortsevmaxim

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playlist_maker_android_egortsevmaxim.ui.theme.PlaylistmakerandroidEgortsevMaximTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaylistmakerandroidEgortsevMaximTheme {
                MainScreen(
                    onSearchClick = {
                        Log.d("PlaylistMaker", "Нажата кнопка \"Поиск\"")
                        Toast.makeText(this, "Нажата кнопка \"Поиск\"", Toast.LENGTH_SHORT).show()
                    },
                    onPlaylistClick = {
                        Log.d("PlaylistMaker", "Нажата кнопка \"Плейлисты\"")
                        Toast.makeText(this, "Нажата кнопка \"Плейлисты\"", Toast.LENGTH_SHORT).show()
                    },
                    onFavouritesClick = {
                        Log.d("PlaylistMaker", "Нажата кнопка \"Избранное\"")
                        Toast.makeText(this, "Нажата кнопка \"Избранное\"", Toast.LENGTH_SHORT).show()
                    },
                    onSettingsClick = {
                        Log.d("PlaylistMaker", "Нажата кнопка \"Настройки\"")
                        Toast.makeText(this, "Нажата кнопка \"Настройки\"", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

// Создание главной страницы приложения (обработка кнопок поиска, плейлистов, избранных и настроек)

@Composable
fun MainScreen(
    onSearchClick: () -> Unit,
    onPlaylistClick: () -> Unit,
    onFavouritesClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().background(colorResource(id = R.color.blue_background))) {
        Text(
            text = stringResource(id = R.string.header),
            color = colorResource(id = R.color.white_font),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 16.dp, top = 14.dp, bottom = 30.dp)
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(colorResource(id = R.color.white_font))
            .padding(top = 14.dp)) {
            MenuItem(text = R.string.search, icon = R.drawable.ic_search, onClick = onSearchClick)
            MenuItem(text = R.string.playlist, icon = R.drawable.ic_library, onClick = onPlaylistClick)
            MenuItem(text = R.string.favorites, icon = R.drawable.ic_favorites, onClick = onFavouritesClick)
            MenuItem(text = R.string.settings, icon = R.drawable.ic_settings, onClick = onSettingsClick)
        }
    }
}

@Composable
fun MenuItem(text: Int, icon: Int, onClick: () -> Unit)
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(24.dp),
    verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = text),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = stringResource(id = text),
            color = colorResource(id = R.color.text_color),
            fontSize = 22.sp,
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = null
        )
    }
}
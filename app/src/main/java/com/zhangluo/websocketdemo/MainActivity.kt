package com.zhangluo.websocketdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zhangluo.websocketdemo.ui.theme.WebSocketDemoTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebSocketDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp();
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WebSocketDemoTheme {
        MyApp();
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Hello", "World")
) {
    val aaa = test()
    val isShow = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box {
        Column(
            modifier
                .fillMaxSize()
                .padding(all = 10.dp)
        ) {
            for (name in names) {
                Text(text = name)
            }
            ElevatedButton(onClick = {
                if (!isShow.value) isShow.value = !isShow.value
                else {Toast.makeText(context,"设备已连接",Toast.LENGTH_SHORT).show()}
            }) {
                Text(text = "连接设备")
            }
            if (isShow.value) Text(text = "已连接") else Text(text = "未连接")
            Button(onClick = { aaa.ConnectionClient() }) {
                Text(text = "发送消息")
            }
        }
    }
}

class test : WebSocketServer {

}
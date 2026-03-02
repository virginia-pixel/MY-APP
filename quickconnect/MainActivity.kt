package com.example.quickconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickconnect.ui.theme.QUICKCONNECTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUICKCONNECTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuickConnectApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuickConnectApp(modifier: Modifier = Modifier) {

    var selectedService by remember { mutableStateOf("") }

    val services = listOf(
        "Plumber",
        "Electrician",
        "Cleaner",
        "Carpenter",
        "Painter"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "QuickConnect",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Find Trusted Local Services Near You"
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(services) { service ->
                Button(
                    onClick = { selectedService = service },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = service)
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        if (selectedService.isNotEmpty()) {
            Text(
                text = "You selected: $selectedService",
                fontSize = 18.sp
            )
        }
    }
}
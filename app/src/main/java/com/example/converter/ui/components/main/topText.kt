package com.example.converter.ui.components.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.converter.ui.theme.ConverterTheme

@Composable
fun TopText () {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column() {
            Text(
                text = "Currency",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Converter",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row() {
            Text(
                text = "Live exchange rates",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
                )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowTopBar(){
    ConverterTheme {
        TopText()
    }
}

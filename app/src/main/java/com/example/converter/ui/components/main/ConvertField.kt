package com.example.converter.ui.components.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.converter.ui.theme.ConverterTheme

@Composable
fun ConvertField() {
    var inputValue by remember { mutableStateOf("-5") }
    val codeValue by remember { mutableStateOf("USD") }
    val isError = (inputValue.toLongOrNull() ?: 0) < 0

    Box {
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            placeholder = {Text(
                text ="0.00",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary,
            )},
            readOnly = true,
            isError = isError,
            supportingText = {
                if (isError) Text(
                    text ="The value cannot be negative."
                )
            },
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.titleLarge,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                focusedTextColor = MaterialTheme.colorScheme.secondary,
                unfocusedTextColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorContainerColor = MaterialTheme.colorScheme.surface,
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorSupportingTextColor = MaterialTheme.colorScheme.error,
                errorTextColor = MaterialTheme.colorScheme.secondary,
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )
        Button (
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp, bottom = 20.dp)
        ) {
            Text(
                text = codeValue
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowConvertField(){
    ConverterTheme {
        ConvertField()
    }
}
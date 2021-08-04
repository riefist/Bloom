package com.aibangdev.bloom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aibangdev.bloom.ui.theme.BloomTheme

@Composable
fun LoginScreen() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LoginHeader()

            EmailInput()

            Spacer(Modifier.height(8.dp))

            PasswordInput()

            TermOfServiceLabel()

            Spacer(Modifier.height(16.dp))

            LoginButton()
        }
    }
}

@Composable
private fun LoginButton() {
    BloomSecondaryButton(buttonText = "Log in")
}

@Composable
private fun TermOfServiceLabel() {
    Text(
        text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy",
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .paddingFromBaseline(
                top = 24.dp
            )
    )
}

@Composable
private fun EmailInput() {
    val textState = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textState.value,
        onValueChange = { newString ->
            textState.value = newString
        },
        label = {
            Text(text = "Email Address")
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
private fun PasswordInput() {
    val textState = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textState.value,
        onValueChange = { newText ->
            textState.value = newText
        },
        label = {
            Text(text = "Password (8+ characters)")
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
private fun LoginHeader() {
    Text(
        text = "Log in with Email",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(
                top = 184.dp,
                bottom = 16.dp
            )
    )
}

@Preview
@Composable
fun PreviewDarkLoginScreen() {
    BloomTheme(darkTheme = true) {
        LoginScreen()
    }
}

@Preview
@Composable
fun PreviewLightLoginScreen() {
    BloomTheme(darkTheme = false) {
        LoginScreen()
    }
}
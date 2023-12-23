package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.DarkBlue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "By signing in, you agree to our ",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "terms and policy.",
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Register",
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text("Email Address") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = null,
                        modifier = Modifier
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = null,
                        modifier = Modifier
                    )
                },
                trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.showpassword),
                            contentDescription = null,
                            modifier = Modifier
                        )

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = Password,
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Checkbox(
                    checked = rememberPassword,
                    onCheckedChange = { rememberPassword = it },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Remember Password",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Forget Password",
                    fontSize = 13.sp,
                    color = Color.Blue,
                    modifier = Modifier
                        .clickable {}
                        .align(Alignment.CenterVertically)
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Login")
            }
        }

        Text(
            text = "Login with touch ID",
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.fingerprint),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable {}
                    .padding(4.dp)
            )
        }

        Text(
            text = "Or connect with",
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            SocialMediaIcon(drawableId = R.drawable.facebook, onClick = { })
            SocialMediaIcon(drawableId = R.drawable.instagram, onClick = {  })
            SocialMediaIcon(drawableId = R.drawable.pinterest, onClick = {  })
            SocialMediaIcon(drawableId = R.drawable.linkedin, onClick = { })
        }
    }
}

@Composable
fun SocialMediaIcon(@DrawableRes drawableId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = null,
        modifier = Modifier
            .size(39.dp)
            .clickable { onClick() }
            .padding(start = 16.dp)
    )
}




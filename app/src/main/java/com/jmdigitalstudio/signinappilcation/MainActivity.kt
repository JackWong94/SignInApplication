package com.jmdigitalstudio.signinappilcation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jmdigitalstudio.signinappilcation.ui.theme.SignInAppilcationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInAppilcationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignInAppMain()
                }
            }
        }
    }
}

@Composable
fun SignInAppMain() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "signinapp") {
        composable("signinapp") { SignInApp(navController = navController) }
        composable("loginscreen") { LoginScreen(navController = navController) }
        composable("logoutscreen") { LogoutScreen(navController = navController) }
        composable("adminscreen") { AdminScreen(navController = navController) }
    }
}

@Composable
fun SignInApp(navController: NavController, modifier: Modifier = Modifier) {
    val spaceBetweenUIElement = 10.dp
    Column (
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.application_title),
            modifier = modifier
        )
        Spacer(modifier = modifier.height(spaceBetweenUIElement))
        Button(
            onClick = { navController.navigate("loginscreen") },
            modifier = modifier
        ) {
            Text(stringResource(R.string.sign_in))
        }
        Spacer(modifier = modifier.height(spaceBetweenUIElement))
        Button(
            onClick = { navController.navigate("logoutscreen") },
            modifier = modifier
        ) {
            Text(stringResource(R.string.sign_out))
        }
        Spacer(modifier = modifier.height(spaceBetweenUIElement))
        Button(
            onClick = { navController.navigate("adminscreen") },
            modifier = modifier
        ) {
            Text(stringResource(R.string.admin))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInAppPreview() {
    SignInAppilcationTheme {
        SignInApp(rememberNavController())
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.login_page))
    }
}

@Composable
fun LogoutScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.logout_page))
    }
}

@Composable
fun AdminScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.admin_page))
    }
}
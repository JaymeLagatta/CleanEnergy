package com.example.login_home2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_home2.ui.theme.Login_home2Theme

class LoginCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_home2Theme {
                val navController = rememberNavController()
                NavHostControllerSetup(navController)
            }
        }
    }
}

@Composable
fun NavHostControllerSetup(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") { LoginPage(navController) }
        composable("principal") { PrincipalScreen(navController) }
        composable("desafios") { DesafiosScreen(navController) }
        composable("dicas") { DicasScreen(navController) }
        composable("pontuacao") { PontuacaoScreen(navController) }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    var username by remember { mutableStateOf("") }

    // Fundo azul com toda a tela
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)) // Cor de fundo cinza claro
            //.background(Color(0xFF2196F3)) // azul
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            //Spacer(modifier = Modifier.height(2.dp)) // espaçamento

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Clean Energy",
                modifier = Modifier
                    .fillMaxWidth()  // largura
                    .height(300.dp) // altura
            )

            // Texto "ESG Connect"
            Text(
                text = "Clean Energy",
                fontSize = 42.sp,
                color = (Color(0xFF2196F3)),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 36.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Campo de entrada do usuário
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuário") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 28.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(0xFF2196F3), // cor do indicador de foco
                    unfocusedIndicatorColor = Color.Gray, // cor do indicador quando não focado
                    cursorColor = Color.Black // cor do cursor
                )
            )
            // Possibilidade de campod e senha futuro
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(0xFF2196F3), // cor do indicador de foco
                    unfocusedIndicatorColor = Color.Gray, // cor do indicador quando não focado
                    cursorColor = Color.Black // cor do cursor
                )
            )

            // Botão "Login" em laranja
            Button(
                onClick = { navController.navigate("principal") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3) // laranja
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            // Texto
            //Text(
            //    text = "A energia é a força vital que impulsiona a economia global \n" +
            //            "e sustenta o modo de vida moderno.",
            //    color = (Color(0xFF2196F3)),
            //    fontSize = 24.sp,
            //    fontFamily = FontFamily.SansSerif,
            //    fontWeight = FontWeight.Bold,
            //    textAlign = TextAlign.Center,
            //    modifier = Modifier.padding(horizontal = 20.dp)
            //)
            // imagem
            Spacer(modifier = Modifier.height(12.dp))  // espaço
            Image(
                painter = painterResource(id = R.drawable.objetivos), // imagem
                contentDescription = "Imagem ilustrativa",
                modifier = Modifier
                    .fillMaxWidth()  // largura
                    .height(350.dp) // altura
            )
        }
    }
}

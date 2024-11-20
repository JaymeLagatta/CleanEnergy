package com.example.login_home2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.text.font.FontFamily

class PrincipalScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Inicializa o navController aqui
            val navController = rememberNavController()

            // Passa o navController para o PrincipalScreen
            PrincipalScreen(navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipalScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarWithMenu(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0)) // Cor de fundo cinza claro
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Texto principal
            Text(
                text = "A energia para um futuro sustentável protege o planeta \n" +
                        " da degradação ambiental \n" +
                        "e cria um mundo mais \n" +
                        " justo e próspero para todos.",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF04344d))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Cabeçalho da Tabela
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF00bfff), shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Usuário",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF04344d),
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.weight(2f),
                    fontSize = 18.sp
                )
                Text(
                    text = "Ação",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF04344d),
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
                Text(
                    text = "Pontuação",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF04344d),
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Dados da Tabela
            val usuarios = listOf(
                Triple("Jayme Lagatta", 100, "https://google.com"),
                Triple("Raphael Fernandes", 120, "https://example.com"),
                Triple("Joseffe Oliveira", 80, "https://kotlinlang.org")
            )

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(usuarios) { usuario ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Nome do Usuário
                        Text(
                            text = usuario.first,
                            modifier = Modifier.weight(2f),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 18.sp
                        )

                        // Ícone com Link
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Ação",
                            modifier = Modifier
                                .weight(1f)
                                .clip(CircleShape)
                                .background(Color(0xFF00bfff))
                                .clickable {
                                    // Aqui podemos colocar a navegação ou ação de abrir link
                                    Log.d("Ação", "Clicado no link: ${usuario.third}")
                                }
                                .padding(8.dp),
                            tint = Color.White
                        )

                        // Pontuação
                        Text(
                            text = usuario.second.toString(),
                            modifier = Modifier.weight(1f),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 18.sp,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(navController: NavController) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                "Clean Energy",
                color = Color(0xFF04344d),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF00bfff)
        ),
        actions = {
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color(0xFF04344d)
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier
                    .background(Color(0xFF04344d))
                    .width(400.dp)
                    .height(400.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                "DESAFIOS",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("desafios")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "PONTUAÇÃO",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("pontuacao")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "DICAS",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("dicas")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "CLASSIFICAÇÃO",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("principal")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "VIDEOS",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("videos")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "SAIR",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = Color(0xFF00bfff)
                            )
                        },
                        onClick = {
                            showMenu = false
                            navController.navigate("login")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    )
}

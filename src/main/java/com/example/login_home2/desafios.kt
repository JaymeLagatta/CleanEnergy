package com.example.login_home2

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.text.font.FontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesafiosScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Clean Energy",
                        color = Color(0xFF04344d),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xFF04344d)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00bfff)
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE0E0E0))
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Desafios Semanais",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF04344d),
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                val desafios = listOf(
                    Triple("Reduzir o consumo de energia em casa", "energia", 50),
                    Triple("Usar transporte público por uma semana", "mobilidade", 30),
                    Triple("Separar o lixo para reciclagem", "ambiente", 40),
                    Triple("Consumir produtos orgânicos", "saude", 20)
                )

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(desafios) { (desafio, tipo, pontos) ->
                        DesafioCard(desafio, tipo, pontos)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("principal") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF04344d))
                ) {
                    Text(
                        text = "Voltar para Principal",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    )
}

@Composable
fun DesafioCard(desafio: String, tipo: String, pontos: Int) {
    val corDesafio = when (tipo) {
        "energia" -> Color(0xFF930090)
        "mobilidade" -> Color(0xFF32CD32)
        "ambiente" -> Color(0xFF00BFFF)
        "saude" -> Color(0xFFFF6347)
        else -> Color.Gray
    }

    var concluido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { concluido = true },
        colors = CardDefaults.cardColors(containerColor = corDesafio)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (concluido) Icons.Default.Check else Icons.Filled.Star,
                contentDescription = "Ícone do desafio",
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = if (concluido) "Concluído!" else desafio,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = if (concluido) "Pontos ganhos: $pontos" else "Pontos: $pontos",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }

            Icon(
                imageVector = if (concluido) Icons.Default.Check else Icons.Outlined.Star,
                contentDescription = "Status do desafio",
                modifier = Modifier.size(30.dp),
                tint = if (concluido) Color.White else Color.Gray
            )
        }
    }
}


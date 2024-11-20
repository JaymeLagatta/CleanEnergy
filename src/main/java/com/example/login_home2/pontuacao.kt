package com.example.login_home2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.text.font.FontFamily
import com.google.ai.client.generativeai.type.content

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PontuacaoScreen(navController: NavHostController) {
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
            // Pontos por categoria
            val pontosPorCategoria = listOf(
                "Energia" to 50,
                "Mobilidade" to 30,
                "Ambiente" to 40,
                "Saúde" to 20
            )
            val totalPontos = pontosPorCategoria.sumOf { it.second }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE0E0E0)) // Cor de fundo cinza claro
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Título da tela
                Text(
                    text = "Sua Pontuação",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF04344d),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                // Pontuação total com ícone de troféu
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Troféu",
                        tint = Color(0xFF04344d),
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "💚 $totalPontos pontos",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF04344d)
                    )
                }

                // Exibição dos pontos por categoria
                pontosPorCategoria.forEach { (categoria, pontos) ->
                    PontuacaoPorCategoria(categoria, pontos)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão para voltar à tela principal
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
fun PontuacaoPorCategoria(categoria: String, pontos: Int) {
    // Definindo a cor para cada categoria
    val corCategoria = when (categoria) {
        "Energia" -> Color(0xFF930090) // Amarelo para Energia
        "Mobilidade" -> Color(0xFF32CD32) // Verde para Mobilidade
        "Ambiente" -> Color(0xFF00BFFF) // Azul para Ambiente
        "Saúde" -> Color(0xFFFF6347) // Laranja para Saúde
        else -> Color.Gray
    }

    // Card para mostrar a categoria e seus pontos
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = corCategoria)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone de estrela para representar a categoria
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Ícone da categoria",
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Texto com a categoria e a quantidade de pontos
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = categoria,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )
                Text(
                    text = "Pontos: $pontos",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }

            // Mostrar uma estrela vazada
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = "Estrela vazada",
                modifier = Modifier.size(30.dp),
                tint = Color(0xFF04344d)
            )
        }
    }
}

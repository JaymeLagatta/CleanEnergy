package com.example.login_home2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DicasScreen(navController: NavHostController) {
    val context = LocalContext.current

    Scaffold(
        // TopBar com título e botão de navegação
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
                    .background(Color(0xFFE0E0E0)) // Cor de fundo cinza claro
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Título da tela
                Text(
                    text = "Dicas de \nSustentabilidade",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF04344d),
                    lineHeight = 48.sp,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                // Lista de dicas de sustentabilidade
                val dicas = listOf(
                    "Apague as luzes ao sair de um cômodo.",
                    "Utilize sacolas reutilizáveis ao fazer compras.",
                    "Compre de produtores locais, fortaleça a comunidade.",
                    "Plante uma árvore para compensar emissões de carbono."
                )

                dicas.forEach { dica ->
                    Text(
                        text = "✔ $dica",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Texto "Saiba Mais"
                Text(
                    text = "Saiba Mais",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF04344d),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Cards com categorias ESG
                val categorias = listOf(
                    "7 - Energia" to "https://www.gnpw.com.br/energia-pt/a-energia-sustentavel-e-a-preservacao-do-planeta/",
                    "11 - Mobilidade" to "https://integridadeesg.insightnet.com.br/a-mobilidade-e-os-desafios-para-a-sustentabilidade-no-brasil/",
                    "13 - Ambiente" to "https://inovacaosebraeminas.com.br/artigo/o-que-e-governanca-ambiental-e-social-esg-e-por-que-se-preocupar-com-isso",
                    "3 - Saúde" to "https://futurodasaude.com.br/tudosobre/esg-na-saude/"
                )
                val coresCategorias = listOf(
                    Color(0xFF930090), // Energia
                    Color(0xFF32CD32), // Mobilidade
                    Color(0xFF00BFFF), // Ambiente
                    Color(0xFFFF6347)  // Saúde
                )

                categorias.forEachIndexed { index, categoria ->
                    Card(
                        modifier = Modifier
                            .requiredWidthIn(min = 200.dp, max = 350.dp)
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .clickable {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(categoria.second))
                                context.startActivity(intent)
                            },
                        colors = CardDefaults.cardColors(containerColor = coresCategorias[index])
                    ) {
                        Box(
                            modifier = Modifier.padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = categoria.first,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão para voltar à tela principal
                //Button(
                //    onClick = { navController.navigate("principal") },
                //    modifier = Modifier
                //        .fillMaxWidth()
                //        .padding(horizontal = 32.dp),
                //    colors = ButtonDefaults.buttonColors(
                //        containerColor = Color(0xFF6200EE),
                //        contentColor = MaterialTheme.colorScheme.onPrimary
                //    )
               // ) {
                    //Text(
                    //    "Voltar para Principal",
                     //   fontSize = 24.sp,
                     //   fontFamily = FontFamily.SansSerif,
                     //   fontWeight = FontWeight.Bold
                   // )
               // }
            }
        }
    )
}

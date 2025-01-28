package com.example.portalparauapebasapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.theme.Gray
import com.example.portalparauapebasapp.ui.theme.Pink
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
    NewsContent(
        onClickButtonShowMore = {  },
        modifier = modifier
    )
}

@Composable
fun NewsContent(
    onClickButtonShowMore: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Pink),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column {
            // Faixa Título e IconButton.
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "TUTORIAL DE COMO ROUBAR UMA CIDADE E NÃO SER PRESO",
                        fontSize = 10.5.sp,
                        fontFamily = fontAppBar,
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 8.dp
                        )
                    )
                }
                IconButton(
                    onClick = onClickButtonShowMore,
                    content = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = stringResource(R.string.show_more_contentButtonNews)
                        )
                    },
                    modifier = Modifier
                        .size(25.dp)
                        .padding(top = 13.dp, end = 8.dp)
                        .align(Alignment.TopEnd)
                )
            }
            // Foto Perfil, Nome Autor e Postado há.
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(R.drawable.eu),
                        contentDescription = stringResource(R.string.author_pictureDescription),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                            .padding(start = 4.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Vinicius Mendes",
                        fontSize = 8.sp,
                        fontFamily = fontAppBar,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
                Text(
                    text = "Postado há 5 minutos",
                    fontSize = 8.sp,
                    fontFamily = fontAppBar,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 8.dp)
                )
            }
        }
    }
}

@Composable
fun NewsContentDescription(modifier: Modifier = Modifier) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Gray),
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "     Tá ligado né, bagulho é e ser ninja, fazer tudo nas sombras, escondidinho, não é segredo.\n" +
                        "Depois é só fazer carreata e prometer butijão de gás para todo mundo. Amanhã eu viajo para \n" +
                        "Paris e o povo ainda me adora.\n" +
                        "     O protótipo não deveria conter tantas palavras. My name’s JOHN CENNA!!!! PANPANRANPAM",
                fontFamily = fontAppBar,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
}

@Preview
@Composable
fun NewsScreenPreview() {
    PortalParauapebasAppTheme {
        NewsScreen()
    }
}

@Preview
@Composable
fun NewsContentDescriptionPreview() {
    PortalParauapebasAppTheme {
        NewsContentDescription()
    }
}
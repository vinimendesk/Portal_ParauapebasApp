package com.example.portalparauapebasapp.ui

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.theme.Gray
import com.example.portalparauapebasapp.ui.theme.Pink
import com.example.portalparauapebasapp.ui.theme.PinkStrong
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme
import com.example.portalparauapebasapp.ui.theme.PortalViewModel

// Função responsável por exibir a tela de notícias.
@Composable
@SuppressLint("MutableCollectionMutableState")
fun NewsScreen(
    portalViewModel: PortalViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val portalUIState by portalViewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            .padding(bottom = 10.dp)
    ) {
        portalUIState.newsList.forEachIndexed { index, _ ->
            val news = portalUIState.newsList[index]
            item {
                NewsContent(
                    newsTitle = stringResource(news.title),
                    newsAuthor = stringResource(news.author),
                    newsAuthorIcon = painterResource(news.authorAvatar),
                    newsPostTime = stringResource(news.postTime),
                    moreInformation = portalUIState.moreInformartion[index] ?: false,
                    onClickButtonShowMore = {
                        portalViewModel.onClickButtonShowMore(portalUIState.moreInformartion, index)
                    }
                )
                if (portalUIState.moreInformartion[index] == true) {
                    NewsContentDescription(newsDescription = stringResource(news.description))
                }
            }
        }
    }
}

@Composable
fun NewsContent(
    newsTitle: String,
    newsAuthor: String,
    newsAuthorIcon: Painter,
    newsPostTime: String,
    moreInformation: Boolean,
    onClickButtonShowMore: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorCompose by animateColorAsState(
        targetValue = if (moreInformation) PinkStrong else Pink
    )
    val colorText by animateColorAsState(
        targetValue = if (moreInformation) Color.White else Color.Black
    )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorCompose),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .drawBehind {
                if (!moreInformation) return@drawBehind
                val shadowColor = Color.Black
                val shadowSize = 60f

                drawRect(
                    color = Gray,
                    topLeft = Offset(0f, size.height - shadowSize / 2),
                    size = Size(size.width, shadowSize),
                )
                drawRect(
                    color = shadowColor,
                    topLeft = Offset(0f, size.height - shadowSize / 2),
                    size = Size(size.width, shadowSize),
                    alpha = 0.5f
                )
            }
    ) {
        Column {
            // Faixa Título e IconButton.
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = newsTitle,
                        color = colorText,
                        fontSize = 10.5.sp,
                        fontFamily = fontAppBar,
                        textAlign = TextAlign.Justify,
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
                            imageVector = if (moreInformation) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = stringResource(R.string.show_more_contentButtonNews),
                            tint = Color.Black
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
                        painter = newsAuthorIcon,
                        contentDescription = stringResource(R.string.author_pictureDescription),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 4.dp, bottom = 4.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = newsAuthor,
                        color = colorText,
                        fontSize = 8.sp,
                        fontFamily = fontAppBar,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
                Text(
                    text = newsPostTime,
                    color = colorText,
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
fun NewsContentDescription(
    newsDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Gray),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .drawWithContent {
                drawContent()

                val shadowColor = Color.Black
                val shadowSize = 8f

                drawRect(
                    color = shadowColor,
                    size = Size(size.width, shadowSize),
                    alpha = 0.5f
                )
            }
    ) {
        Text(
            text = newsDescription,
            fontFamily = fontAppBar,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
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
        NewsContentDescription(stringResource(R.string.news_description_vini))
    }
}
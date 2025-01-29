package com.example.portalparauapebasapp.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.portalparauapebasapp.ui.theme.PinkStrong
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme


@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
    var moreInformation: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        NewsContent(
            moreInformation = moreInformation,
            onClickButtonShowMore = { moreInformation = !moreInformation },
            modifier = modifier
        )
        if (moreInformation) {
            NewsContentDescription(modifier = modifier)
        }
    }
}

@Composable
fun NewsContent(
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
                        text = stringResource(R.string.title_vini_post),
                        color = colorText,
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
                            imageVector = if (moreInformation) Icons.Default.KeyboardArrowUp
                            else Icons.Default.KeyboardArrowDown,
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
                        color = colorText,
                        fontSize = 8.sp,
                        fontFamily = fontAppBar,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
                Text(
                    text = "Postado há 5 minutos",
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
fun NewsContentDescription(modifier: Modifier = Modifier) {
        Card(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Gray),
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.news_description_vini),
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
package com.example.portalparauapebasapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.data.ProfilesList
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.components.SwitchProfileDialog
import com.example.portalparauapebasapp.ui.theme.BlueStrong
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme
import java.util.Locale

@Composable
fun ProfileScreen(
    currentProfile: Profile,
    profilesList: List<Profile>,
    onChangeCurrentProfile: (profile: Profile) -> Unit,
    modifier: Modifier = Modifier
) {
    var switchProfileDialogOpened by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        ProfileContent(
            profileNickname = currentProfile.nickname,
            profileAvatar = currentProfile.avatar,
            profileAboutMe = currentProfile.aboutMe,
            profilePosts = currentProfile.posts,
            profileFollowers = currentProfile.followers,
            onClickButtonSwitchProfile = {
                switchProfileDialogOpened = true
            }
        )
    }
    if (switchProfileDialogOpened) {
        SwitchProfileDialog(
            currentProfile = currentProfile,
            profilesList = profilesList,
            onDismissRequest = { switchProfileDialogOpened = false },
            onSwitchProfile = onChangeCurrentProfile
        )
    }
}

@Composable
fun ProfileContent(
    profileNickname: String,
    profileAvatar: Painter,
    profileAboutMe: String,
    profilePosts: Int,
    profileFollowers: Int,
    onClickButtonSwitchProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = BlueStrong),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 32.dp
            )
    ) {
        IconButton(
            onClick = onClickButtonSwitchProfile,
            content = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(R.string.switch_profile_buttonProfile),
                    tint = Color.White,
                    modifier = Modifier
                        .size(25.dp)
                        .padding(
                            start = 12.dp,
                            bottom = 5.dp
                        )
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.switch_profile_buttonProfile),
                    tint = Color.White
                )
            },
            modifier = Modifier
                .size(25.dp)
                .padding(end = 8.dp)
                .align(Alignment.End)
        )
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
            ) {
                // Foto e nome do perfil
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = profileAvatar,
                        contentDescription = stringResource(R.string.profile_pictureDescription),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = profileNickname,
                        color = Color.White,
                        fontSize = 8.sp,
                        fontFamily = fontAppBar
                    )
                }
                // Quantidade de Posts
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            start = 30.dp,
                            end = 55.dp,
                            bottom = 20.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.profile_postsIndicator),
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = fontAppBar,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "$profilePosts",
                        color = Color.White,
                        fontSize = 11.sp,
                        fontFamily = fontAppBar,
                        textAlign = TextAlign.Center
                    )
                }
                // Quantidade de Seguidores
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            end = 20.dp,
                            bottom = 20.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.profile_followersIndicator),
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = fontAppBar,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = toFollowersNotation(profileFollowers),
                        color = Color.White,
                        fontSize = 11.sp,
                        fontFamily = fontAppBar,
                        textAlign = TextAlign.Center
                    )
                }
            }
            // Seção "Sobre mim" do perfil
            Text(
                text = profileAboutMe,
                textAlign = TextAlign.Justify,
                color = Color.White,
                fontSize = 8.sp,
                fontFamily = fontAppBar,
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        start = 20.dp,
                        bottom = 40.dp,
                        end = 20.dp
                    )
            )
        }
    }
}

fun toFollowersNotation(followers: Int): String {
    return when {
        followers >= 1000000000 -> String.format(Locale.US, "%.1fb", followers / 1000000000.0).replace(",", ".")
        followers >= 1000000 -> String.format(Locale.US, "%.1fm", followers / 1000000.0).replace(",", ".")
        followers >= 1000 -> String.format(Locale.US, "%.1fk", followers / 1000.0).replace(",", ".")
        else -> followers.toString()
    }
}
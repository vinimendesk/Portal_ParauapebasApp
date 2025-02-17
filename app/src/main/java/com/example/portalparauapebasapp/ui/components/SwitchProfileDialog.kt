package com.example.portalparauapebasapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.theme.DarkPink
import com.example.portalparauapebasapp.ui.theme.DarkPurple
import com.example.portalparauapebasapp.ui.theme.Pink

@Composable
fun SwitchProfileDialog(
    currentProfile: Profile,
    profilesList: List<Profile>,
    onSwitchProfile: (profile: Profile) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnClickOutside = false),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .background(
                    color = Pink,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .width(500.dp)
                .height(400.dp)
        ) {
            IconButton(
                onClick = onDismissRequest,
                content = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_switch_profile_buttonProfile),
                        tint = Color.Black,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(
                                start = 12.dp,
                                bottom = 5.dp
                            )
                    )
                },
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 8.dp)
                    .align(Alignment.TopEnd)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.switch_profile_dialogTitle),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = fontAppBar,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(R.string.switch_profile_dialogDescription),
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = fontAppBar
                )
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    LazyColumn {
                        profilesList.forEachIndexed { index, _ ->
                            val profile = profilesList[index]
                            val isCurrentProfile = currentProfile == profile
                            item {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(45.dp)
                                        .background(
                                            color = if (isCurrentProfile) DarkPurple else DarkPink,
                                            shape = RectangleShape
                                        )
                                        .clickable {
                                            onSwitchProfile(profilesList[index])
                                            onDismissRequest()
                                        }
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(profile.avatar),
                                            contentDescription = stringResource(R.string.profile_pictureDescription),
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(CircleShape)
                                        )
                                        Text(
                                            text = stringResource(profile.nickname),
                                            color = if (isCurrentProfile) Color.White else Color.Black,
                                            fontSize = 15.sp,
                                            fontFamily = fontAppBar,
                                            modifier = Modifier.padding(start = 10.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
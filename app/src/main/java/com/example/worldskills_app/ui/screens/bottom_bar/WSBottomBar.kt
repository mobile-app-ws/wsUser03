package com.example.worldskills_app.ui.screens.bottom_bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.worldskills_app.navigation.BottomBar
import com.example.worldskills_app.ui.theme.selectedBottomBarIconColor
import com.example.worldskills_app.ui.theme.unselectedBottomBarIconColor

@Composable
fun WSBottomBar(
    currentDestination: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFFF4F4F4))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomBar.listBottomBarElements.forEach { bottomBarElement ->
                WSBottomBarElement(
                    modifier = Modifier.weight(1f),
                    iconId = bottomBarElement.resourceId,
                    name = bottomBarElement.name,
                    isSelected = currentDestination == bottomBarElement.route,
                    onClick = {
                        navController.navigate(bottomBarElement.route)
                    }
                )
            }
        }
    }

}

@Composable
fun WSBottomBarElement(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    name: String,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val color = if (isSelected)
        selectedBottomBarIconColor
    else
        unselectedBottomBarIconColor

    Column(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = color
        )
        Text(
            text = name,
            color = color
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewWSBottomBarElement() {
    BottomBar.SUPPORT.let {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            WSBottomBarElement(
                iconId = it.resourceId,
                name = it.name,
                isSelected = true
            )
            WSBottomBarElement(
                iconId = it.resourceId,
                name = it.name,
                isSelected = false
            )
        }
    }
}
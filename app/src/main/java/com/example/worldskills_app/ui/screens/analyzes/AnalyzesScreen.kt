package com.example.worldskills_app.ui.screens.analyzes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import org.koin.androidx.compose.getViewModel

@Composable
fun AnalyzesScreen(
    modifier: Modifier = Modifier,
    viewModel: AnalyzesViewModel = getViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier
    ) {
        item {
            BlockAnalyzes(
                modifier = Modifier,
                title = "Акции и новости",
            ) {
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(horizontal = 10.dp)
                ) {
                    if (state.isLoading){
                        items(3){
                            BlockNews(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                isPlaceholder = true
                            )
                        }
                    }else{
                        items(state.news) { news ->
                            BlockNews(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                image = news.image,
                                name = news.name,
                                description = news.description,
                                price = news.price
                            )
                        }
                    }

                }
            }
        }
        item {
            BlockAnalyzes(
                modifier = Modifier,
                title = "Каталог анализов",
            ) {
                //TODO
            }
        }
    }
}

@Composable
fun BlockAnalyzes(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .padding(
                    top = 32.dp,
                    bottom = 16.dp
                ),
            text = title,
            color = Color(0xFF939396),
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp,
            lineHeight = 24.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
        content()
    }
}

@Composable
fun BlockNews(
    modifier: Modifier = Modifier,
    isPlaceholder: Boolean = false,
    image: String = "",
    name: String = "",
    description: String = "",
    price: String = "",
) {
    Row(
        modifier = modifier
            .size(
                width = 270.dp,
                height = 152.dp
            )
            .clip(RoundedCornerShape(12.dp))
            .placeholder(
                visible = isPlaceholder,
                highlight = PlaceholderHighlight.fade(),
            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF76B3FF), Color.White),
                ),
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 12.dp
                )
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                lineHeight = 28.sp,
                color = Color.White
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = description,
                    lineHeight = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "$price ₽",
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                    color = Color.White
                )
            }
        }
        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .align(Alignment.Bottom),
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}
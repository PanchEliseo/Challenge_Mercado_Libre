package com.mercadolibre.challenge.presentation.searchResult.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.navigation.SearchNavigation

@Composable
fun ItemSearchResult(
    navController: NavHostController,
    results: Results,
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .semantics { contentDescription = "Item Result" }
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("Detail", results)
                navController.navigate(route = SearchNavigation.Detail.route)
            },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(results.thumbnail)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
                contentDescription = "Image",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 5.dp, start = 5.dp)
            ) {
                Text(
                    text = results.title,
                    style = TextStyle(color = Color.Black)
                )
            }
        }
    }
}
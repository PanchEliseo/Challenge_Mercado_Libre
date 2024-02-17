package com.mercadolibre.challenge.presentation.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.domain.retrofit.search.Results

/**
 * This composable expects [paddingValues] to padding content in view, [results] object with result
 * of search
 */
@Composable
fun DetailContent(
    paddingValues: PaddingValues,
    results: Results,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
    ) {
        ColumnContent(results = results)
    }
}

@Composable
fun ColumnContent(results: Results) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(results.thumbnail)
            .crossfade(true)
            .build(),
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        contentDescription = "Image detail product",
        contentScale = ContentScale.Crop
    )
    Text(
        text = results.title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
    )
    Text(
        text = stringResource(id = R.string.label_price, results.price),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
    )
    val processor = results.attributes.find {
        it.id == "PROCESSOR_MODEL"
    }
    processor?.let {
        Text(
            text = stringResource(id = R.string.label_know),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        )
        Text(
            text = it.name+": "+it.valueName,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        )
    }
    val gpuModel = results.attributes.find {
        it.id == "GPU_MODEL"
    }
    gpuModel?.let {
        Text(
            text = it.name+": "+it.valueName,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        )
    }
}

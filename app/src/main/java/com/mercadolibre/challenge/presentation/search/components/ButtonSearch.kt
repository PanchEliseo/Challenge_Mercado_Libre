package com.mercadolibre.challenge.presentation.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.model.SearchModel

/**
 * This composable expects [model] data class with text search and site id,
 * [onSearch] lambda that triggers to next view and call service
 */
@Composable
fun ButtonSearch(
    model: SearchModel,
    onSearch:(model: SearchModel) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            enabled = model.search.isNotEmpty(),
            modifier = Modifier
                .semantics { contentDescription = "Button Search" },
            onClick = {
                onSearch.invoke(model)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = stringResource(id = R.string.label_search))
        }
    }
}

package com.mercadolibre.challenge.presentation.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.mercadolibre.challenge.R

/**
 * This composable expects [valueTextField] text for validate enable or disable button,
 * [onSearch] lambda that triggers to next view and call service
 */
@Composable
fun ButtonSearch(
    valueTextField: String,
    onSearch:(product: String) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            enabled = valueTextField.isNotEmpty(),
            modifier = Modifier
                .semantics { contentDescription = "Button Search" },
            onClick = { onSearch.invoke(valueTextField) }
        ) {
            Text(text = stringResource(id = R.string.label_search))
        }
    }
}
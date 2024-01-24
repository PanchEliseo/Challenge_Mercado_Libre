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
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.navigation.SearchNavigation

@Composable
fun ButtonSearch(valueTextField: String, navController: NavHostController) {
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
            onClick = {
                navController.navigate(
                    route = SearchNavigation.Result.searchText(valueTextField)
                )
            }) {
            Text(text = stringResource(id = R.string.label_search))
        }
    }
}
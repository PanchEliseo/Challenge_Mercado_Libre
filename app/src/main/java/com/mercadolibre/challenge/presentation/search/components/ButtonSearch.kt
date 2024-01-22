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
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.navigation.ResultScreen

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
            onClick = {
                navController.navigate(
                    route = ResultScreen.Result.searchText(valueTextField)
                )
            }) {
            Text(text = stringResource(id = R.string.label_search))
        }
    }
}
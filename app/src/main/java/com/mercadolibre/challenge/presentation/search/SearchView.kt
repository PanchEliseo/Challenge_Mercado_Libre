package com.mercadolibre.challenge.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.navigation.ResultScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    navController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val valueTextField = viewModel.textValueChange.observeAsState(initial = "")
    Scaffold(
        content = {
            SearchViewContent(
                paddingValues = it,
                viewModel = viewModel,
                valueTextField = valueTextField.value
            )
        },
        bottomBar = {
            ButtonSearch(
                valueTextField = valueTextField.value,
                navController = navController
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewContent(paddingValues: PaddingValues, viewModel: SearchViewModel, valueTextField: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues = paddingValues)
    ) {
        Text(text = stringResource(id = R.string.search_label))
        OutlinedTextField(
            value = valueTextField,
            onValueChange = {
                viewModel.onChangeValueChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Icon search")
            },
            label = {
                Text(text = stringResource(id = R.string.label_search))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
        )
    }
}

@Composable
fun ButtonSearch(valueTextField: String, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(enabled = valueTextField.isNotEmpty(),
            onClick = {
                navController.navigate(route = ResultScreen.Result.route)
            }) {
            Text(text = stringResource(id = R.string.label_search))
        }
    }
}
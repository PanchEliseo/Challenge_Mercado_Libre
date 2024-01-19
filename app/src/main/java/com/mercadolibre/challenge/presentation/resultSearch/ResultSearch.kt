package com.mercadolibre.challenge.presentation.resultSearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mercadolibre.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultSearchView(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = {
            DefaultTopBar(navController)
        },
        content = {
            ResultSearchContent(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(navController: NavHostController? = null) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.result_search))
        },
        navigationIcon = {
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "TopBar")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow)
    )
}

@Composable
fun ResultSearchContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        Text(text = "Aqui mostrar resultado de busqueda")
    }
}
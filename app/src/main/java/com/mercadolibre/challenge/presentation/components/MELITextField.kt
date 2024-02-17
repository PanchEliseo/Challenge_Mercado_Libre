package com.mercadolibre.challenge.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.mercadolibre.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MELITextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    imageVector: ImageVector,
    placeHolder: Int = R.string.label_search,
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange.invoke(it)
        },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "Icon search")
        },
        label = {
            Text(text = stringResource(id = placeHolder))
        },
        modifier = modifier
    )
}

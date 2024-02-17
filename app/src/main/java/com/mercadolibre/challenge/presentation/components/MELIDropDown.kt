package com.mercadolibre.challenge.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MELIDropDown(
    modifier: Modifier = Modifier,
    size: Size = Size.Default,
    list: MutableList<ResponseSites>,
    onClick:(String) -> Unit,
) {
    val mModifier = when (size) {
        Size.Large -> modifier.fillMaxWidth()
        else -> { modifier.wrapContentWidth() }
    }
    val expanded = rememberSaveable { mutableStateOf(false) }
    val text = remember { mutableStateOf(list[0].name) }
    Box(
        modifier = mModifier
            .background(Color.White),
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = {
                expanded.value = !expanded.value }
        ) {
            OutlinedTextField(
                value = text.value,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier
                    .background(Color.White)
            ) {
                list.forEach { options ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = {
                            Text(text = options.name)
                        },
                        onClick = {
                            text.value = options.name
                            expanded.value = false
                            onClick.invoke(options.id)
                        }
                    )
                }
            }
        }
    }
}

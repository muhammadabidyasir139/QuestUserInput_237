package com.example.inputpengguna

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier

@Composable
fun FormDataDiri(modifier: Modifier
) {
    var textName by remember {mutableStateOf(value = "")}
    var testAlamat by remember { mutableStateOf(value= "") }
    var textJk by remember { mutableStateOf(value = "") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "")}
}
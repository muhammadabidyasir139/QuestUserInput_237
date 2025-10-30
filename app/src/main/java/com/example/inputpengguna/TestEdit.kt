package com.example.inputpengguna

import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.RadioButton

@Composable
fun FormDataDiri(modifier: Modifier
) {
    var textName by remember {mutableStateOf(value = "")}
    var textAlamat by remember { mutableStateOf(value= "") }
    var textJk by remember { mutableStateOf(value = "") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "")}
    var jenis by remember { mutableStateOf(value = "") }

    val gender:List<string> = listOf("Laki-laki", "Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        outlinedTextField(
            valur = textNama,
            singLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {
                textName = it
            }
        )
        Row {
            gender.forEach {
                item ->
                Row(modifier = Modifier.selectable(
                    selected = textJk == item,
                    onClick = {textJk = item}
                ), verticalAlignment = Alignment.CenterVertically)
                RadioButton(
                    selected = textJk ==item,
                    onClick = {
                        textJk = item
                    }
                )
                Text(text = item)
            }
        }
    }
    outlinedTextField(
        value = textAlamat, 
    )
}
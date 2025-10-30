package com.example.inputpengguna

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
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
        OutlinedTextField(
            value = textNama,
            singleLine = true,
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
        singleValue = true,
        modifier = Modifier.width(width = 250.dp),
        label = {Text(text = "Alamat Lengkap")},
        onValueChange = {
            textAlamat = it
        }
    )

    HorizontalDivider(
        modifier = Modifier.padding(
            bottom = dimensionResource(id = R.dimen.padding_medium),
            top = dimensionResource(
            id = R.dimen.padding_medium
        )),
        thickness = dimensionResource(1dp),
        color = Color.DarkGray
    )

    Button(
        modifier = Modifier.fillMaxWidth(fraction = 1f),
        enabled = textAlamat.isNotEmpty(),
        onClick = {
            nama=textName
            jenis=textJk
            alamat=textAlamat
        }
    ) {
        Text(text = stringResource(id = R.string.submit))
    }

    HorizontalDivider(
        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
            id = R.dimen.padding_medium
        )),
        thickness = dimensionResource(R.dimen.divider_tipis),
        color = Color.DarkGray
    )
    Button(
        modifier = Modifier.fillMaxWidth(1f),
        // the button is enabled when the user makes a selection
        enabled = textAlamat.isNotEmpty(),
        onClick = {
            nama=textNama
            jenis=textJK
            alamat=textAlamat
        }
    ) {
        Text(stringResource(R.string.submit))
    }

    HorizontalDivider(
        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
            id = R.dimen.padding_medium
        )),
        thickness = dimensionResource(R.dimen.divider_tipis),
        color = Color.DarkGray
    )

    ElevatedCard (
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .height(100.dp)
            .width(300.dp)
    )
}
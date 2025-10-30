package com.example.inputpengguna

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textName by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJk by remember { mutableStateOf("") }

    // State untuk menampilkan hasil
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text("Nama Lengkap") }
        )

        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .then(
                            Modifier // selectable opsional, tapi RadioButton sudah cukup interaktif
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJk == item,
                        onClick = { textJk = item }
                    )
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            onValueChange = { textAlamat = it },
            singleLine = false, // alamat bisa multi-line
            modifier = Modifier
                .width(250.dp)
                .padding(top = 16.dp),
            label = { Text("Alamat Lengkap") }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.width(250.dp),
            enabled = textName.isNotEmpty() && textJk.isNotEmpty() && textAlamat.isNotEmpty(),
            onClick = {
                nama = textName
                jenis = textJk
                alamat = textAlamat
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)
            ) {
                Text(text = "Nama   : $nama", color = Color.White)
                Text(text = "Gender : $jenis", color = Color.White)
                Text(text = "Alamat : $alamat", color = Color.White)
            }
        }
    }
}
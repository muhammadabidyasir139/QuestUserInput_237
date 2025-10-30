package com.example.formlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textName by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var SelectedJK by remember { mutableStateOf<string?>(null) }
    var selectedStatus by remember { mutableStatetOf<string>(null) }

    var namaHasil by remember { mutableStateOf("") }
    var alamatHasil by remember { mutableStateOf("") }
    var jkHasil by remember { mutableStateOf("") }
    var statusHasil by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val statusPerkawinan = listOf("Janda", "Lajang", "Duda")

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Pendaftaran",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.white,
            modifier = Modifier
                .fillMaxWidth()
                .background(color(0xFFBB6BD9))
                .padding(16.dp)
                .wrapContentHeight()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxWidht()
                .padding(horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Nama Lengkap",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = textName,
                    onValueChange = {textName = it},
                    singleLine = true,
                    shape = MaterialTheme.shape.medium,
                    modifier = Modifier.fillMaxWidth(),
                    label = {Text("Nama Lengkap")}
                )
                Text(
                    text = "jenis Kelamin",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    gender.forEach{item ->
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                        ) {
                            RadioButton(
                                selected = selectedJK ==item,
                                onClick = {selectedJK = item}
                            )
                            Text(text = item)
                        }
                    }
                }
                Text(
                    text = "Status Perkawinan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    statusPerkawinan.forEach { item ->
                        Row(
                        verticalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f),
                            .padding(horizontal = 4.dp)
                        ) {
                            RadioButton(
                                slected = selectedStatus ==item,
                                onClick = {selectedStatus = item}
                            )
                        Text(text = item)
                    }
                    }
                }
                Text(
                    text = "Alamat",
                    fontWeight = FontWeight
                )
            }
        }
    }
}
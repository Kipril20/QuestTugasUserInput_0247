package com.example.userinput

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.dimensionResource

@Composable
fun FormBiodataScreen() {
    var namaDepan by remember { mutableStateOf() f("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var isExpExpanded by remember { mutableStateOf(false) }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    val fieldShape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_medium))
    val textFieldColors = OutlinedTextFieldDefaults.colors()
}
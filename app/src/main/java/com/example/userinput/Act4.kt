package com.example.userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BiodataResult(
    val namaLengkap: String,
    val email: String,
    val tglLahir: String,
    val experience: String,
    val skills: List<String>
)

@Composable
fun FormBiodataScreen() {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var isExpExpanded by remember { mutableStateOf(false) }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    var submittedData by remember { mutableStateOf<BiodataResult?>(null) }

    val fieldShape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_medium))
    val textFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(id = R.color.gray_focused_border),
        unfocusedBorderColor = colorResource(id = R.color.gray_border),
        focusedContainerColor = colorResource(id = R.color.white),
        unfocusedContainerColor = colorResource(id = R.color.white),
        focusedTextColor = colorResource(id = R.color.text_primary),
        unfocusedTextColor = colorResource(id = R.color.text_primary)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.screen_background)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header Image Background
            Image(
                painter = painterResource(id = R.drawable.header_bg),
                contentDescription = stringResource(id = R.string.content_desc_header),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_height))
            )
            // Floating Box component over Scaffold
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(id = R.dimen.floating_box_top_padding))
                    .verticalScroll(rememberScrollState())
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.floating_box_horizontal_margin)
                        )
                        .padding(
                            bottom = dimensionResource(id = R.dimen.floating_box_bottom_margin)
                        ),
                    shape = RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.corner_large),
                        topEnd = dimensionResource(id = R.dimen.corner_large),
                        bottomStart = dimensionResource(id = R.dimen.corner_large),
                        bottomEnd = dimensionResource(id = R.dimen.corner_large)
                    ),
                    color = colorResource(id = R.color.card_background),
                    shadowElevation = dimensionResource(id = R.dimen.elevation_medium)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.card_padding)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Title
                        Text(
                            text = stringResource(id = R.string.form_title),
                            fontSize = dimensionResource(id = R.dimen.font_size_title).value.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.purple_title),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                        // Subtitle
                        Text(
                            text = stringResource(id = R.string.form_subtitle),
                            fontSize = dimensionResource(id = R.dimen.font_size_subtitle).value.sp,
                            color = colorResource(id = R.color.gray_subtitle),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))

                        // Row 1: Nama Depan & Nama Belakang
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                dimensionResource(id = R.dimen.spacing_medium)
                            )
                        ) {
                            OutlinedTextField(
                                value = namaDepan,
                                onValueChange = { namaDepan = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_nama_depan),
                                        fontSize = dimensionResource(id = R.dimen.font_size_input).value.sp,
                                        color = colorResource(id = R.color.gray_text_hint)
                                    )
                                },
                                shape = fieldShape,
                                colors = textFieldColors,
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )

                            OutlinedTextField(
                                value = namaBelakang,
                                onValueChange = { namaBelakang = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_nama_belakang),
                                        fontSize = dimensionResource(id = R.dimen.font_size_input).value.sp,
                                        color = colorResource(id = R.color.gray_text_hint)
                                    )
                                },
                                shape = fieldShape,
                                colors = textFieldColors,
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                        // Row 2: Email
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.hint_email),
                                    fontSize = dimensionResource(id = R.dimen.font_size_input).value.sp,
                                    color = colorResource(id = R.color.gray_text_hint)
                                )
                            },
                            shape = fieldShape,
                            colors = textFieldColors,
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                        // Row 3: Tgl Lahir & Experience
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                dimensionResource(id = R.dimen.spacing_medium)
                            )
                        ) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { tglLahir = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_tgl_lahir),
                                        fontSize = dimensionResource(id = R.dimen.font_size_input).value.sp,
                                        color = colorResource(id = R.color.gray_text_hint)
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = stringResource(id = R.string.content_desc_calendar),
                                        tint = colorResource(id = R.color.text_secondary)
                                    )
                                },
                                shape = fieldShape,
                                colors = textFieldColors,
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )

                            Box(modifier = Modifier.weight(1f)) {
                                OutlinedTextField(
                                    value = experience,
                                    onValueChange = { experience = it },
                                    readOnly = true,
                                    placeholder = {
                                        Text(
                                            text = stringResource(id = R.string.hint_experience),
                                            fontSize = dimensionResource(id = R.dimen.font_size_input).value.sp,
                                            color = colorResource(id = R.color.gray_text_hint)
                                        )
                                    },
                                    trailingIcon = {
                                        IconButton(onClick = { isExpExpanded = true }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_dropdown),
                                                contentDescription = stringResource(id = R.string.content_desc_dropdown),
                                                tint = colorResource(id = R.color.text_secondary)
                                            )
                                        }
                                    },
                                    shape = fieldShape,
                                    colors = textFieldColors,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { isExpExpanded = true },
                                    singleLine = true
                                )

                                DropdownMenu(
                                    expanded = isExpExpanded,
                                    onDismissRequest = { isExpExpanded = false }
                                ) {
                                    val expOptions = listOf(
                                        stringResource(id = R.string.exp_beginner),
                                        stringResource(id = R.string.exp_intermediate),
                                        stringResource(id = R.string.exp_advanced)
                                    )
                                    expOptions.forEach { option ->
                                        DropdownMenuItem(
                                            text = { Text(text = option) },
                                            onClick = {
                                                experience = option
                                                isExpExpanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))

                        // Pilih Skill Anda Label
                        Text(
                            text = stringResource(id = R.string.label_pilih_skill),
                            fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.text_primary),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                        // Checkboxes Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Android Checkbox
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isAndroidChecked = !isAndroidChecked }
                            ) {
                                Checkbox(
                                    checked = isAndroidChecked,
                                    onCheckedChange = { isAndroidChecked = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked),
                                        uncheckedColor = colorResource(id = R.color.checkbox_unchecked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_android),
                                    fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                                    color = colorResource(id = R.color.text_primary)
                                )
                            }

                            // UI/UX Checkbox
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isUiUxChecked = !isUiUxChecked }
                            ) {
                                Checkbox(
                                    checked = isUiUxChecked,
                                    onCheckedChange = { isUiUxChecked = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked),
                                        uncheckedColor = colorResource(id = R.color.checkbox_unchecked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_ui_ux),
                                    fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                                    color = colorResource(id = R.color.text_primary)
                                )
                            }

                            // Web Checkbox
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable { isWebChecked = !isWebChecked }
                            ) {
                                Checkbox(
                                    checked = isWebChecked,
                                    onCheckedChange = { isWebChecked = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked),
                                        uncheckedColor = colorResource(id = R.color.checkbox_unchecked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_web),
                                    fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                                    color = colorResource(id = R.color.text_primary)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_extra_large)))

                        // Proceed Button
                        Button(
                            onClick = {
                                val selectedSkills = mutableListOf<String>()
                                if (isAndroidChecked) selectedSkills.add("Android")
                                if (isUiUxChecked) selectedSkills.add("UI/UX")
                                if (isWebChecked) selectedSkills.add("Web")

                                val fullName = listOf(namaDepan.trim(), namaBelakang.trim())
                                    .filter { it.isNotEmpty() }
                                    .joinToString(" ")

                                submittedData = BiodataResult(
                                    namaLengkap = fullName.ifEmpty { "-" },
                                    email = email.ifBlank { "-" },
                                    tglLahir = tglLahir.ifBlank { "-" },
                                    experience = experience.ifBlank { "-" },
                                    skills = selectedSkills
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.button_height)),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_button)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.purple_title),
                                contentColor = colorResource(id = R.color.btn_text_color)
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_proceed),
                                fontSize = dimensionResource(id = R.dimen.font_size_button).value.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // Display Result Card when data is submitted
                        submittedData?.let { data ->
                            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))

                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_medium)),
                                colors = CardDefaults.cardColors(
                                    containerColor = colorResource(id = R.color.screen_background)
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(dimensionResource(id = R.dimen.card_padding)),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text(
                                        text = "Hasil Biodata",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.purple_title)
                                    )

                                    HorizontalDivider(color = colorResource(id = R.color.gray_border))

                                    ResultRow(label = "Nama Lengkap", value = data.namaLengkap)
                                    ResultRow(label = "Email", value = data.email)
                                    ResultRow(label = "Tanggal Lahir", value = data.tglLahir)
                                    ResultRow(label = "Experience", value = data.experience)
                                    ResultRow(
                                        label = "Skill",
                                        value = if (data.skills.isNotEmpty()) data.skills.joinToString(", ") else "-"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ResultRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_secondary)
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_primary),
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FormBiodataScreenPreview() {
    FormBiodataScreen()
}
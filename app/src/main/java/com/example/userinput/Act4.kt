package com.example.userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

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
}       ) {
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
            ){
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
                }
        }
    }
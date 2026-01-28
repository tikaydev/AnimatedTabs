package com.tikaydev.animatedtabs.presentation.component

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Float.toDp(density: Density): Dp = with(density) { this@toDp.toDp() }
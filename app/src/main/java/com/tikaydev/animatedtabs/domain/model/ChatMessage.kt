/*
 * Copyright 2026 Alex Tenkorang
 */

package com.tikaydev.animatedtabs.domain.model

data class ChatMessage(
    val id: Int,
    val text: String,
    val isFromMe: Boolean,
    val time: String
)

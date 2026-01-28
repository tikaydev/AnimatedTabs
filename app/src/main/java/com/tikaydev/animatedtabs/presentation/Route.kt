package com.tikaydev.animatedtabs.presentation

import com.tikaydev.animatedtabs.domain.model.RecentMessage

sealed class Route {
    data object Home : Route()
    data class Chat(val user: RecentMessage) : Route()
}

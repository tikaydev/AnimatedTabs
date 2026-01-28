/*
 * Copyright 2026 Alex Tenkorang
 */

package com.tikaydev.animatedtabs.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.EmojiEmotions
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.material.icons.rounded.SportsEsports
import androidx.compose.material.icons.rounded.SupervisedUserCircle
import androidx.compose.material.icons.rounded.Work

//region --- Dummy Data ---
val dummyRecents = listOf(
    RecentMessage(
        1,
        "Max Hall",
        "Hello Friend! How are you?",
        "08:30 pm",
        true,
        Icons.Rounded.Person
    ),
    RecentMessage(2, "Dan Martin", "Hi man! Do you know?...", "04:12 pm", true, Icons.Rounded.Face),
    RecentMessage(
        3,
        "Stephen Green",
        "Yes! I like it!",
        "02:05 pm",
        true,
        Icons.Rounded.EmojiEmotions
    ),
    RecentMessage(
        4,
        "Sarah Woodman",
        "How about my work?",
        "Yesterday",
        false,
        Icons.Rounded.SentimentSatisfied
    ),
    RecentMessage(5, "Peter Hopper", "At 5 pm", "01.22.201", false, Icons.Rounded.AccountCircle),
    RecentMessage(
        6,
        "Denis Ivanov",
        "Oh, no! Are you sure?",
        "01.16.201",
        false,
        Icons.Rounded.SupervisedUserCircle
    ),
    RecentMessage(7, "Alice Silver", "Hello Alex!", "01.12.201", false, Icons.Rounded.Face),
)
val dummyFavorites = listOf(
    RecentMessage(
        4,
        "Sarah Woodman",
        "How about my work?",
        "Yesterday",
        false,
        Icons.Rounded.SentimentSatisfied
    ),
    RecentMessage(5, "Peter Hopper", "At 5 pm", "01.22.201", false, Icons.Rounded.AccountCircle),
    RecentMessage(
        6,
        "Denis Ivanov",
        "Oh, no! Are you sure?",
        "01.16.201",
        false,
        Icons.Rounded.SupervisedUserCircle
    ),
    RecentMessage(7, "Alice Silver", "Hello Alex!", "01.12.201", false, Icons.Rounded.Face),
)
val dummyGroups = listOf(
    RecentMessage(
        10,
        "Design Team",
        "New mockups are ready!",
        "10:30 am",
        true,
        Icons.Rounded.Brush
    ),
    RecentMessage(
        11,
        "Weekend Trip",
        "Who is bringing the snacks?",
        "09:15 am",
        true,
        Icons.Rounded.DirectionsCar
    ),
    RecentMessage(
        12,
        "Family Group",
        "Mom: Call me when you can",
        "Yesterday",
        false,
        Icons.Rounded.Home
    ),
    RecentMessage(13, "Project Alpha", "Meeting delayed to 4 PM", "Mon", true, Icons.Rounded.Work),
    RecentMessage(14, "Gaming Squad", "Online tonight?", "Sun", false, Icons.Rounded.SportsEsports),
)

val chatDummyData = listOf(
    ChatMessage(1, "Hello Frank! How are you?", false, "12:30"),
    ChatMessage(2, "Hello I'm fine. Thanks! And you?", true, "12:28"),
    ChatMessage(3, "Fine! I have a question", false, "12:30"),
    ChatMessage(4, "Question?", true, "12:28"),
    ChatMessage(5, "How about my work?", false, "12:30"),
)

//endregion

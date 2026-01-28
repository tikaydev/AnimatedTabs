/*
 * Copyright 2026 Alex Tenkorang
 */

package com.tikaydev.animatedtabs

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tikaydev.animatedtabs.presentation.screen.detail.ChatDetailScreen
import com.tikaydev.animatedtabs.presentation.Route
import com.tikaydev.animatedtabs.presentation.component.LocalAnimatedVisibilityScope
import com.tikaydev.animatedtabs.presentation.component.LocalSharedTransitionScope
import com.tikaydev.animatedtabs.presentation.screen.home.HomeScreen

/**
 * The root navigation controller.
 * Handles state hoisting for list animations to ensure lists remain static when returning from a chat,
 * allowing the Shared Element Transition to find its target frame.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun App(
    modifier:Modifier = Modifier
) {
    var currentRoute by remember { mutableStateOf<Route>(Route.Home) }

    // -- State Hoisting --
    // We hoist the tab index so it persists when the Home screen is recreated after a back press.
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    // We hoist the animation flag.
    // true = List items fly in (App start or Tab switch).
    // false = List items are static (Return from Chat).
    var shouldAnimateList by rememberSaveable { mutableStateOf(true) }

    // We apply a solid background to the root Layout to prevent the white window background
    // from flashing through during the double-transparent cross-fade.
    SharedTransitionLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1C1B2A))
    ) {
        AnimatedContent(
            targetState = currentRoute,
            label = "ScreenTransition",
            transitionSpec = {
                // Smooth cross-fade to match the slow shared element spring
                fadeIn(
                    animationSpec = tween(durationMillis = 600)
                ) togetherWith fadeOut(
                    animationSpec = tween(durationMillis = 600)
                )
            }
        ) { targetScreen ->
            CompositionLocalProvider(
                LocalSharedTransitionScope provides this@SharedTransitionLayout,
                LocalAnimatedVisibilityScope provides this@AnimatedContent
            ) {
                when (targetScreen) {
                    is Route.Home -> {
                        HomeScreen(
                            selectedIndex = selectedTabIndex,
                            shouldAnimate = shouldAnimateList,
                            onTabSelected = { newIndex ->
                                selectedTabIndex = newIndex
                                // Tab switch -> Trigger list entrance animation
                                shouldAnimateList = true
                            },
                            onChatSelected = { user ->
                                // Navigating away -> Freeze list state for return
                                shouldAnimateList = false
                                currentRoute = Route.Chat(user)
                            }
                        )
                    }

                    is Route.Chat -> {
                        ChatDetailScreen(
                            user = targetScreen.user,
                            onBack = { currentRoute = Route.Home }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}

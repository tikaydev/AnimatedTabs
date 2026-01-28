package com.tikaydev.animatedtabs.presentation.screen.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.tikaydev.animatedtabs.domain.model.RecentMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GroupsListShared(
    items: List<RecentMessage>,
    state: LazyListState,
    onChatSelected: (RecentMessage) -> Unit,
    shouldAnimate: Boolean
) {
    BoxWithConstraints {
        val startOffset = maxWidth
        LazyColumn(
            state = state,
            contentPadding = PaddingValues(top = 16.dp, bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items) { index, item ->
                val alphaAnim = remember { Animatable(if (shouldAnimate) 0f else 1f) }
                val slideAnim =
                    remember { Animatable(if (shouldAnimate) startOffset.value else 0f) }

                if (shouldAnimate) {
                    LaunchedEffect(Unit) {
                        delay(index * 60L)
                        launch { alphaAnim.animateTo(1f, tween(400)) }
                        launch { slideAnim.animateTo(0f, spring(0.8f, Spring.StiffnessLow)) }
                    }
                }

                Box(
                    modifier = Modifier
                        .offset(x = slideAnim.value.dp)
                        .alpha(alphaAnim.value)
                ) {
                    SharedRecentItemRow(item = item, onChatSelected = onChatSelected)
                }
            }
        }
    }
}

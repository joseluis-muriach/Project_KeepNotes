package com.example.project_keepnotes

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CoverKeepNote() {
    val lazyListState = rememberLazyListState()
    var scrolled = 0f
    var previousOffset = 0

    Scaffold(
        topBar = {
            Image(
                painter = painterResource(id = R.drawable.brillo),
                contentDescription = "Imagen de brillos",
                modifier =
                Modifier.fillMaxWidth()
                    .height(70.dp),
                contentScale = ContentScale.Crop
            )
            ScaffoldTopBar() },
        floatingActionButton = { FloatingButton() }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = it.calculateTopPadding()),
        ) {
            LazyColumn(
                state = lazyListState,
                content = {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.brillo),
                            contentDescription = "Imagen de brillos",
                            modifier =
                            Modifier.graphicsLayer {
                                scrolled += lazyListState.firstVisibleItemScrollOffset -
                                        previousOffset
                                translationY = scrolled * 0.5f
                                previousOffset = lazyListState.firstVisibleItemScrollOffset
                            }
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    items(getCommentsCoff()) { commentsItem ->
                        ItemComment(
                            commentsKeep = commentsItem
                        )
                    }
                }
            )
        }
    }
}


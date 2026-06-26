package com.example.skillforge.presentation.home.components


//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.outlined.ArrowBack
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun SearchTopBar(
//    mode: FullSearchMode,
//    itemCount: Int,
//    onBackClick: () -> Unit
//) {
//    val title = when (mode) {
//        FullSearchMode.CATEGORY -> "Categories"
//        FullSearchMode.COURSE -> "Courses"
//    }
//
//    val badgeText = when (mode) {
//        FullSearchMode.CATEGORY ->
//            "$itemCount ${if (itemCount == 1) "Category" else "Categories"}"
//
//        FullSearchMode.COURSE ->
//            "$itemCount ${if (itemCount == 1) "Course" else "Courses"}"
//    }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 12.dp, vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        IconButton(onClick = onBackClick) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
//                contentDescription = "Back"
//            )
//        }
//
//        Text(
//            text = title,
//            style = MaterialTheme.typography.titleLarge.copy(
//                fontWeight = FontWeight.Bold
//            ),
//            modifier = Modifier.weight(1f)
//        )
//
//        Box(
//            modifier = Modifier
//                .clip(RoundedCornerShape(12.dp))
//                .background(Color(0xFFEAEAEA))
//                .padding(horizontal = 12.dp, vertical = 6.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = badgeText,
//                style = MaterialTheme.typography.labelMedium
//            )
//        }
//    }
//}


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.skillforge.ui.theme.labelXSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    mode: FullSearchMode,
    itemCount: Int,
    onBackClick: () -> Unit,
) {
    val title = when (mode) {
        FullSearchMode.CATEGORY -> "Categories"
        FullSearchMode.COURSE -> "Courses"
    }

    val badgeText = when (mode) {
        FullSearchMode.CATEGORY ->
            "$itemCount ${if (itemCount == 1) "Category" else "Categories"}"

        FullSearchMode.COURSE ->
            "$itemCount ${if (itemCount == 1) "Course" else "Courses"}"
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeText,
                    style = MaterialTheme.typography.labelXSmall
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFF7F7F7)
        )
    )
}
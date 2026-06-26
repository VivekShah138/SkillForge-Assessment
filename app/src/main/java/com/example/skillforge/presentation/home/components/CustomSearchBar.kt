package com.example.skillforge.presentation.home.components

//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.Search
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp

//@Composable
//fun CustomSearchBar() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .border(1.dp, Color(0xFFE3E3E3), RoundedCornerShape(16.dp))
//            .background(Color.White)
//            .padding(horizontal = 16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            Icons.Outlined.Search,
//            contentDescription = null,
//            tint = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.width(12.dp))
//
//        Text(
//            "Search courses, topics...",
//            color = Color.Gray
//        )
//    }
//}

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.ui.theme.labelXSmall

@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholderText: String = "Search categories, courses, topics...",
    onCancelClick:() -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text(
                placeholderText,
                style = MaterialTheme.typography.labelXSmall.copy(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search"
            )
        },
        trailingIcon = {
            if(query.isNotBlank()){
                Icon(
                    imageVector = Icons.Outlined.Cancel,
                    contentDescription = "Search",
                    modifier = Modifier.clickable{
                        onCancelClick()
                    }
                )
            }
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
    )
}

@Preview(showBackground = true)
@Composable
fun CustomSearchBarPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        CustomSearchBar(
            query = "",
            onQueryChange = {

            },
            onCancelClick = {

            }
        )
    }
}
package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
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
                text = placeholderText,
                style = MaterialTheme.typography.labelXSmall.copy(
                    fontSize = 12.sp,
                    color = Color.Gray
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
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
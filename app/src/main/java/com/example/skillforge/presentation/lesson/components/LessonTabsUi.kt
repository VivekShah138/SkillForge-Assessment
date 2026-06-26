package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.LessonTabs

@Composable
fun LessonTabsUi(
    selectedTab: LessonTabs,
    onSelectTab: (LessonTabs) -> Unit
) {
    val tabs = LessonTabs.entries

    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            tabs.forEach { tab ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            onSelectTab(tab)
                        }
                ) {
                    Text(
                        text = tab.displayName,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTab == tab) Color.Black else Color.Gray
                        )
                    )

                    Spacer(Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(3.dp)
                            .background(
                                if (selectedTab == tab)
                                    Color(0xFF00B8A9)
                                else
                                    Color.Transparent
                            )
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TabsPreview() {
    LessonTabsUi(
        selectedTab = LessonTabs.LESSONS,
        onSelectTab = {

        }
    )
}

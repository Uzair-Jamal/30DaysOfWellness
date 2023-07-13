package com.example.daysofwellness

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysofwellness.model.DaysOfWellness
import com.example.daysofwellness.ui.theme.DaysOfWellnessTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DaysWellnessList(
    days: List<DaysOfWellness>,
    modifier: Modifier = Modifier
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = slideInVertically(),
        exit = slideOutVertically(),
        modifier = modifier
    ) {
        LazyColumn {
            itemsIndexed(days) { index, day ->

                DaysListItem(
                    day = day,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                            )
            }

        }
    }
}


@Composable
fun DaysListItem(

    day: DaysOfWellness,
    modifier: Modifier = Modifier,
){
    var isExpanded by remember { mutableStateOf(false)}

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.padding(16.dp).clickable{isExpanded = !isExpanded}
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
        Text(
            text = stringResource(day.daysNumberRes),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(day.daysHeadingRes),
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(Modifier.height(8.dp))
    }
                Image(
                    painter = painterResource(day.daysImageRes),
                    contentDescription = null
                )

            Column(modifier = Modifier
                .padding(16.dp)
                .animateContentSize()

            ) {
                if(isExpanded)
                    Text(text = stringResource(day.daysContentRes),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines =  Int.MAX_VALUE,
                    overflow = TextOverflow.Visible,
                    softWrap = true
                )
            }
            

    }

}

@Preview
@Composable
fun DaysPreview() {
    val day = DaysOfWellness(
        R.string.second_day,
        R.string.second_head,
        R.string.second_content,
        R.drawable.second

    )
    DaysOfWellnessTheme() {
        DaysListItem(day = day)
    }
}



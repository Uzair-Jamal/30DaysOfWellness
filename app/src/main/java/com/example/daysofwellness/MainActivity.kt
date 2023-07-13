package com.example.daysofwellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.daysofwellness.model.DaysOfWellness
import com.example.daysofwellness.model.DaysRepository
import com.example.daysofwellness.ui.theme.DaysOfWellnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaysOfWellnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DaysOfWellnessApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysOfWellnessApp(){
    Scaffold(
        modifier = Modifier,
        topBar = {
                SmallTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name),
                             style = MaterialTheme.typography.displayMedium
                        )
                    },
                        modifier = Modifier,
                        colors = TopAppBarDefaults.smallTopAppBarColors
                            (
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                )
            }
    )
    {
        val days = DaysRepository.days
        DaysWellnessList(days = days, modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun DaysOfWellnessPreview(){
    DaysOfWellnessTheme {
        DaysOfWellnessApp()
    }
}




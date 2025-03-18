package com.jhw.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jhw.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var selectedNumberIdx by rememberSaveable {
        mutableIntStateOf(-1)
    }
    val numberList = listOf(
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10"
    )

    if (showDialog) {
        WheelPickerDialog(
            initIdx = selectedNumberIdx.let {
                if (it < 0) { 0 } else { it }
            },
            suffix = "th",
            onDismissRequest = {
                showDialog = false
            },
            onConfirm = { getSelectedMonth ->
                selectedNumberIdx = numberList.indexOf(getSelectedMonth.toString())
                showDialog = false
            },
            optionList = numberList
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = selectedNumberIdx.let {
                if (it < 0) { "Select Number" } else { numberList[it] + "th" }
            },
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.clickable { showDialog = true }
        )
    }
}
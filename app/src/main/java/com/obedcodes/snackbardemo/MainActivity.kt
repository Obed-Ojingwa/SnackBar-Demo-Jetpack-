package com.obedcodes.snackbardemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Display
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.ScaffoldSubcomposeInMeasureFix
import com.obedcodes.snackbardemo.ui.theme.SnackBarDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.*
import kotlin.time.Duration


/*import com.obedcodes.snackbardemo.ui.theme.SnackBarDemoTheme*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()*/
        setContent {

            SnackBarDemoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ){
                    // My fun calls
                    DisplaySnackBar()
                }
            }


        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplaySnackBar(){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember{SnackbarHostState()}


    Scaffold  (
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Button(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            "This is the message",
                            actionLabel = "Undo",
                            duration = SnackbarDuration.Indefinite
                        )
                    }
                }
            ) {
                Text("Display SnackBar")
            }
        }
    )
}






/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackBarDisplay(){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Display SnackBar") },
                icon = { Icon(Icons.Filled.Edit, contentDescription = "") },
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("This is a Snackbar",
                            actionLabel = "Undo",
                            duration = SnackbarDuration.Long)
                    }
                }
            )
        }
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplaySnackBarExample(){
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Edit, contentDescription = "") },
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Snackbar",
                            actionLabel = "Undo",
                            duration = SnackbarDuration.Long)
                    }
                }
            )
        }
    ) {

    }

}*/
/*
    Scaffold(scaffoldState = scaffoldState){
        Button(
            onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "This is the Message",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Long
                    )
                }
            }
        ) {
            Text("Display SnackBar")
        }
    }*/

package com.musaib.catfact

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.musaib.catfact.ui.theme.MainGreen
import com.musaib.catfact.viewModel.MainViewModel


@Composable
fun MainScreenUI(
    modifier: Modifier,
    fact: String,
    buttonClicked: () -> Unit = {},
) {

    Scaffold(
        modifier = modifier
            .fillMaxSize()
        ,
    ){innerPadding->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            OutlinedCard(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                    .height(IntrinsicSize.Max)
                ,
                border = BorderStroke(
                    width = 0.5.dp,
                    color = Color.Black
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.onSurface)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "New Cat Fact",
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.surface
                    )

                    Spacer(modifier.height(12.dp))


                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                        ,
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center

                    ){

                        Text(
                            text = fact,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.surface
                        )
                    }

                    Spacer(modifier.height(82.dp))

                    ElevatedButton(
                        onClick = {
                            buttonClicked()
                        },
                        modifier = modifier
                        ,
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = MainGreen,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp))

                    ) {
                        Text(
                            text = "Random Cat Fact",
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }


        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val fact by viewModel.catFact.collectAsState()
    MainScreenUI(
        modifier = modifier,
        fact = fact,
        buttonClicked = {
            viewModel.fetchCatFact()
        }
    )
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreenUI(
        Modifier,
        "Cat's are awesome"
    )
}






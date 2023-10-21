package com.charlyj21.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charlyj21.calculator.ui.theme.CalculatorTheme
import com.charlyj21.calculator.ui.theme.Cyan
import com.charlyj21.calculator.ui.theme.Red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    val calculatorButtons = remember {
                        mutableStateListOf(
                            CalculatorButton(
                                text = "AC",
                                type = CalculatorButtonType.Reset,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "C",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "%",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "/",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "7",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.seven_tail
                            ),
                            CalculatorButton(
                                text = "8",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.eight_tail
                            ),
                            CalculatorButton(
                                text = "9",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.nine_tail
                            ),
                            CalculatorButton(
                                text = "x",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "4",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.four_tail
                            ),
                            CalculatorButton(
                                text = "5",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.five_tail
                            ),
                            CalculatorButton(
                                text = "6",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.six_tail
                            ),
                            CalculatorButton(
                                text = "-",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "1",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.one_tail
                            ),
                            CalculatorButton(
                                text = "2",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.two_tail
                            ),
                            CalculatorButton(
                                text = "3",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = R.drawable.three_tail
                            ),
                            CalculatorButton(
                                text = "+",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            ),

                            CalculatorButton(
                                icon = Icons.Outlined.Refresh,
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "0",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = ".",
                                type = CalculatorButtonType.Normal,
                                backgroundImageResource = 0
                            ),
                            CalculatorButton(
                                text = "=",
                                type = CalculatorButtonType.Action,
                                backgroundImageResource = 0
                            )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            ,
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                                .background(MaterialTheme.colorScheme.primary)
                                .padding(8.dp),
                            columns = GridCells.Fixed(4),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(16.dp)
                        ){
                            items(calculatorButtons){
                                CalcButton(
                                    button = it,
                                    OnClick = {

                                    }
                                )
                            }
                        }
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier= Modifier
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                .clip(
                                    RoundedCornerShape(8.dp)
                                )
                        ){
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.ic_nightmode),
                                contentDescription = null,
                                tint = Color.White
                            )
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.ic_darkmode),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalcButton(button: CalculatorButton, OnClick : () -> Unit){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxHeight()
            .aspectRatio(1f)
            .clickable {
                OnClick()
            },
        contentAlignment = Alignment.Center
    ) {
        if (button.backgroundImageResource != 0){
            Image(
                painter = painterResource(id = button.backgroundImageResource), // Replace with your actual image resource
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
        }else{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary) // Aplica el color sólido como fondo
            )
        }
        val contentColor =
            if (button.type == CalculatorButtonType.Normal)
                Color.White
            else if (button.type == CalculatorButtonType.Action)
                Red
            else
                Cyan
        if(button.text != null){
            Text(
                button.text,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = if (button.type == CalculatorButtonType.Action) 30.sp else 25.sp,
            )
        }else{
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = button.icon!!,
                contentDescription = null,
                tint = contentColor
            )
        }
    }
}

data class CalculatorButton(
    val text: String? = null,
    val type: CalculatorButtonType,
    val icon : ImageVector? = null,
    val backgroundImageResource: Int
)

enum class CalculatorButtonType{
    Normal, Action, Reset
}
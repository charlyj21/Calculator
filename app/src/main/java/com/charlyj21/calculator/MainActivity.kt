package com.charlyj21.calculator
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charlyj21.calculator.ui.theme.CalculatorTheme
import com.charlyj21.calculator.ui.theme.Cyan
import com.charlyj21.calculator.ui.theme.Red

class MainActivity : ComponentActivity() {

    private val viewModel:AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme

                val darkModeEnabled by LocalTheme.current.darkMode.collectAsState()
                val textColor = if (darkModeEnabled) Color(0xffffffff) else Color(0xff212121)
                val themeViewModel = LocalTheme.current

                // Declare themes var and set default theme
                var currentTheme by remember {
                    mutableStateOf(CalculatorTheme.ThemeA)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    val calculatorButtons = remember {
                        mutableStateListOf(
                            CalculatorButton("AC", CalculatorButtonType.Reset, null, 0),
                            CalculatorButton("C", CalculatorButtonType.Reset, null, 0),
                            CalculatorButton("%", CalculatorButtonType.Action, null, 0),
                            CalculatorButton("/", CalculatorButtonType.Action, null, 0),
                            CalculatorButton("7", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn7
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("8", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn8
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("9", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn9
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("x", CalculatorButtonType.Action, null, 0),
                            CalculatorButton("4", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn4
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("5", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn5
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("6", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn6
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("-", CalculatorButtonType.Action, null, 0),
                            CalculatorButton("1", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn1
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("2", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn2
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("3", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn3
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton("+", CalculatorButtonType.Action, null, 0),

                            CalculatorButton(
                                icon = Icons.Outlined.Favorite,
                                type = CalculatorButtonType.Theme,
                                backgroundImageResource = 0,
                                theme = CalculatorTheme.ThemeA
                            ),
                            CalculatorButton("0", CalculatorButtonType.Normal, null, when (currentTheme) {
                                CalculatorTheme.ThemeA -> R.drawable.btn0
                                CalculatorTheme.ThemeB -> R.drawable.btn2
                                CalculatorTheme.ThemeC -> R.drawable.btn3
                            }, CalculatorTheme.ThemeA),
                            CalculatorButton(".", CalculatorButtonType.Normal, null, 0),
                            CalculatorButton("=", CalculatorButtonType.Action, null, 0)
                        )
                    }
                    val (uiText, setUiText) = remember {
                        mutableStateOf("0")
                    }
                    calculatorButtons.forEach { button ->
                        button.theme = currentTheme
                        button.updateBackgroundImage()
                    }
                    LaunchedEffect(uiText){
                        if (uiText.startsWith("0") && uiText!="0"){
                            setUiText(uiText.substring(1))
                        }
                    }
                    LaunchedEffect(currentTheme) {
                        calculatorButtons.forEach { button ->
                            button.theme = currentTheme
                            button.updateBackgroundImage()
                        }
                    }
                    val (input,setInput) = remember {
                        mutableStateOf<String?>(null)
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Column{
                            Text(modifier=Modifier.padding(horizontal = 8.dp), text = uiText, fontSize = 48.sp, fontWeight = FontWeight.Bold, color = textColor)
                            Spacer(modifier = Modifier.height(32.dp))
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
                                        textColor = textColor,
                                        OnClick = {
                                            when(it.type){
                                                CalculatorButtonType.Normal -> {
                                                    runCatching {
                                                        setUiText(uiText.toInt().toString()+it.text)
                                                    }.onFailure { throwable->
                                                        setUiText(uiText+it.text)
                                                    }
                                                    setInput((input ?: "") + it.text)
                                                    if (viewModel.action.value.isNotEmpty()){
                                                        if (viewModel.secondNumber.value == null){
                                                            viewModel.setSecondNumber(it.text!!.toDouble())
                                                        }else{
                                                            if(viewModel.secondNumber.value.toString().split(".")[1]=="0"){
                                                                viewModel.setSecondNumber((viewModel.secondNumber.value.toString().split(".").first()+it.text!!).toDouble())
                                                            }else{
                                                                viewModel.setSecondNumber((viewModel.secondNumber.value.toString()+it.text!!).toDouble())
                                                            }
                                                        }
                                                    }
                                                }
                                                CalculatorButtonType.Action -> {
                                                    if(it.text == "="){
                                                        val result = viewModel.getResult()
                                                        setUiText(result.toString())
                                                        setInput(null)
                                                        viewModel.resetAll()
                                                    }else{
                                                        runCatching {
                                                            setUiText(uiText.toInt().toString()+it.text)
                                                        }.onFailure { throwable->
                                                            setUiText(uiText+it.text)
                                                        }
                                                        if (input != null){
                                                            if (viewModel.firstNumber.value == null){
                                                                viewModel.setFirstNumber(input.toDouble())
                                                            }else{
                                                                viewModel.setSecondNumber(input.toDouble())
                                                            }
                                                            viewModel.setAction(it.text!!)
                                                            setInput(null)
                                                        }
                                                    }
                                                }
                                                CalculatorButtonType.Reset -> {
                                                    setUiText("")
                                                    setInput(null)
                                                    viewModel.resetAll()
                                                }
                                                CalculatorButtonType.Theme -> {
                                                    currentTheme = when (currentTheme) {
                                                        CalculatorTheme.ThemeA -> CalculatorTheme.ThemeB
                                                        CalculatorTheme.ThemeB -> CalculatorTheme.ThemeC
                                                        CalculatorTheme.ThemeC -> CalculatorTheme.ThemeA
                                                    }
                                                    Log.d("Calculator", "New Theme: $currentTheme")
                                                    calculatorButtons.forEach { it.updateBackgroundImage() }
                                                }
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp), contentAlignment = Alignment.TopCenter){
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier= Modifier
                                .clip(
                                    RoundedCornerShape(8.dp)
                                )
                                .background(MaterialTheme.colorScheme.primary)
                                .padding(horizontal = 15.dp, vertical = 8.dp)
                        ){
                            Icon(
                                modifier = Modifier.size(20.dp).clickable {
                                    themeViewModel.toggleTheme()
                                },
                                painter = painterResource(id = R.drawable.ic_nightmode),
                                contentDescription = null,
                                tint = if (darkModeEnabled) Color.Gray.copy(alpha = .5f) else Color.Gray
                            )
                            Icon(
                                modifier = Modifier.size(20.dp).clickable {
                                    themeViewModel.toggleTheme()
                                },
                                painter = painterResource(id = R.drawable.ic_darkmode),
                                contentDescription = null,
                                tint = if (!darkModeEnabled) Color.Gray.copy(alpha = .5f) else Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalcButton(button: CalculatorButton, textColor:Color ,OnClick : () -> Unit){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(button.theme?.let { MaterialTheme.colorScheme.primary } ?: MaterialTheme.colorScheme.secondary)
            .fillMaxHeight()
            .aspectRatio(1f)
            .clickable {
                OnClick()
            },
        contentAlignment = Alignment.Center
    ) {

        if (button.backgroundImageResource != 0){
            Image(
                painter = painterResource(id = button.backgroundImageResource),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
        }else{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary)
            )
        }
        val contentColor =
            if (button.type == CalculatorButtonType.Normal)
                textColor
            else if (button.type == CalculatorButtonType.Action)
                Red
            else
                Cyan

        if(button.text != null){
            Text(
                button.text,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                fontSize = if (button.type == CalculatorButtonType.Action) 25.sp else 20.sp,
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
    var backgroundImageResource: Int,
    var theme: CalculatorTheme? = null
){

    fun updateBackgroundImage() {
        backgroundImageResource = when (theme) {
            CalculatorTheme.ThemeA -> when (text) {
                "0" -> R.drawable.btn0
                "1" -> R.drawable.btn1
                "2" -> R.drawable.btn2
                "3" -> R.drawable.btn3
                "4" -> R.drawable.btn4
                "5" -> R.drawable.btn5
                "6" -> R.drawable.btn6
                "7" -> R.drawable.btn7
                "8" -> R.drawable.btn8
                "9" -> R.drawable.btn9
                else -> 0
            }
            CalculatorTheme.ThemeB -> when (text) {
                "0" -> R.drawable.btn4
                "1" -> R.drawable.btn4
                "2" -> R.drawable.btn4
                "3" -> R.drawable.btn4
                "4" -> R.drawable.btn4
                "5" -> R.drawable.btn4
                "6" -> R.drawable.btn4
                "7" -> R.drawable.btn4
                "8" -> R.drawable.btn4
                "9" -> R.drawable.btn4
                else -> 0
            }
            CalculatorTheme.ThemeC -> when (text) {
                "0" -> R.drawable.btn5
                "1" -> R.drawable.btn5
                "2" -> R.drawable.btn5
                "3" -> R.drawable.btn5
                "4" -> R.drawable.btn5
                "5" -> R.drawable.btn5
                "6" -> R.drawable.btn5
                "7" -> R.drawable.btn5
                "8" -> R.drawable.btn5
                "9" -> R.drawable.btn5
                else -> 0
            }
            null -> 0
        }
    }
}

enum class CalculatorButtonType{
    Normal, Action, Reset, Theme
}

enum class CalculatorTheme{
    ThemeA, ThemeB, ThemeC
}
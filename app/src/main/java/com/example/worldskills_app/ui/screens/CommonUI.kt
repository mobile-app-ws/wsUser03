package com.example.worldskills_app.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun toast(
    text: String,
    context: Context
) = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG).show()

@Composable
fun WSButton(
    modifier: Modifier = Modifier,
    text: String = "",
    enabled: Boolean = true,
    onClick: () -> Unit = {}
){
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A6FEE),
            disabledContainerColor = Color(0xFF1A6FEE).copy(0.3f),
        ),
        enabled = enabled
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .sizeIn(minWidth = 50.dp),
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewWSButton() {
    WSButton(
        modifier = Modifier,
        text = "Dalee"
    )
}

@Composable
fun WSTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
    placeholder: String = "",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        value = text,
        onValueChange = onValueChange,
        maxLines = 1,
        singleLine = true
    ) { value ->
        Column(
            modifier = Modifier
        ) {
            if (title.isNotEmpty()){
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = title,
                    color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .sizeIn(minHeight = 48.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = Color(0xFFF5F5F9)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(vertical = 14.dp, horizontal = 14.dp),
            ) {
                if (text.isEmpty()){
                    Text(
                        text = placeholder,
                        color = Color.Gray
                    )
                }else{
                    value()
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewWSTextField() {
    WSTextField(
        title = "Вход по Email",
        placeholder = "Email"
    )

}
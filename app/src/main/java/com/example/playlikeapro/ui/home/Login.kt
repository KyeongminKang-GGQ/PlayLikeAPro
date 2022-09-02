package com.example.playlikeapro.ui.home

import com.example.playlikeapro.R
import com.example.playlikeapro.TopAppBar
import com.example.playlikeapro.ui.theme.Kakao
import com.example.playlikeapro.ui.theme.PlayLikeAProTheme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playlikeapro.ui.theme.Grey20
import com.example.playlikeapro.ui.theme.Grey95

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlayLikeAProTheme {
        Login(
            onBackPress = {}
        )
    }
}

@Composable
fun Login(
    onBackPress: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(onBackPress = onBackPress)

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
        )

        Text(
            text = "로그인",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(20.dp)
            )

            InputForm(
                title = "이메일",
                hint = "example@example.com",
                onValueChange = {}
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(12.dp)
            )

            InputForm(
                title = "비밀번호",
                hint = "8자 이상의 영문, 숫자",
                onValueChange = {}
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(12.dp)
            )

            Text(
                text = "비밀번호를 잊으셨나요?",
                color = Grey20,
                style = MaterialTheme.typography.labelSmall,
            )

            Spacer(
                modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
            )

            PlapButton(
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                text = "이메일로 로그인",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(12.dp)
            )

            PlapButton(
                iconPainter = painterResource(id = R.drawable.ic_kakao),
                backgroundColor = Kakao,
                contentColor = Color.Black,
                text = "카카오로 3초만에 시작하기",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun InputForm(
    title: String,
    hint: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(12.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = onValueChange,
            placeholder = { Text(text = hint, color = Grey95) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PlapButton(
    iconPainter: Painter? = null,
    backgroundColor: Color,
    contentColor: Color,
    text: String,
    modifier: Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = modifier
    ) {
        if (iconPainter != null) {
            Icon(painter = iconPainter, contentDescription = null)
        }
        Text(text = text)
    }
}
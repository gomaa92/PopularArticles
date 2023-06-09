package com.gomaa.populararticles.presentation.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.gomaa.populararticles.domain.entity.ArticleEntity

@Composable
fun ArticleDetailsComponent(article: ArticleEntity) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Title: ${article.title}",
            style = MaterialTheme.typography.h6,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Publish Date: ${article.publishedDate}",
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.byLine, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        ClickableUrlText(article.url)
    }
}

@Composable
fun ClickableUrlText(url: String) {
    val context = LocalContext.current
    val contentColor = LocalContentColor.current
    val annotatedText = AnnotatedString.Builder("Read more: ").apply {
        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
        append(url)
        pop()
        addStringAnnotation(
            tag = "URL", annotation = url, start = length - url.length, end = length
        )
    }.toAnnotatedString()

    ClickableText(text = annotatedText, onClick = { offset ->
        annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset).firstOrNull()
            ?.let { annotation ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                context.startActivity(intent)
            }
    }, style = TextStyle(color = contentColor))
}
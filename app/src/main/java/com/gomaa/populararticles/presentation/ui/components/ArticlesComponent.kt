package com.gomaa.populararticles.presentation.ui.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gomaa.populararticles.R
import com.gomaa.populararticles.domain.entity.ArticleEntity
import com.gomaa.populararticles.presentation.ui.activities.ArticleDetailsActivity
import com.gomaa.populararticles.presentation.ui.activities.ArticleDetailsActivity.Companion.ARTICLE_DETAILS
import com.gomaa.populararticles.presentation.ui.components.ArticleItemComponentConstant.item_byline
import com.gomaa.populararticles.presentation.ui.components.ArticleItemComponentConstant.item_card
import com.gomaa.populararticles.presentation.ui.components.ArticleItemComponentConstant.item_date
import com.gomaa.populararticles.presentation.ui.components.ArticleItemComponentConstant.item_title

@Composable
fun ArticlesComponent(articles: List<ArticleEntity>) {
    LazyColumn {
        items(articles) { item ->
            ArticleItem(item)
        }
    }
}

@Composable
fun ArticleItem(article: ArticleEntity) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, ArticleDetailsActivity::class.java)
                intent.putExtra(ARTICLE_DETAILS, article)
                context.startActivity(intent)
            }
            .testTag(item_card),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.testTag(item_title)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.publish_date) + " ${article.publishedDate}",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.testTag(item_date)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = article.byLine,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.testTag(item_byline)
            )
        }
    }
}

object ArticleItemComponentConstant {
    const val item_card = "item_card"
    const val item_title = "item_title"
    const val item_date = "item_date"
    const val item_byline = "item_byline"
}

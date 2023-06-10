package com.gomaa.populararticles.domain.mapper

import com.gomaa.populararticles.data.model.Article
import com.gomaa.populararticles.domain.entity.ArticleEntity

object ArticlesDomainMapper {

    fun mapDataArticleToDomainArticle(article: Article): ArticleEntity {
        return ArticleEntity(
            title = article.title.orEmpty(),
            publishedDate = article.publishedDate.orEmpty(),
            byLine = article.byline.orEmpty(),
            url = article.url.orEmpty()
        )
    }

    fun mapDataArticlesToDomainArticles(articles: List<Article>): List<ArticleEntity> {
        return articles.map { article ->
            mapDataArticleToDomainArticle(article)
        }
    }
}

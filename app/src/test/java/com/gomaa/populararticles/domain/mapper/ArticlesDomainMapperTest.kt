package com.gomaa.populararticles.domain.mapper

import com.gomaa.populararticles.data.model.Article
import com.gomaa.populararticles.domain.entity.ArticleEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class ArticlesDomainMapperTest {

    @Test
    fun `mapDataArticleToDomainArticle should map data correctly`() {
        // Given
        val dataArticle = Article(
            id = 1L,
            media = emptyList(),
            publishedDate = "2023-06-10",
            section = "Technology",
            source = "My Source",
            subsection = "Mobile",
            title = "Sample Title",
            type = "Article",
            updated = "2023-06-10T12:00:00",
            uri = "sample:uri",
            url = "https://sample.url",
            byline = "John Doe"
        )

        val expectedDomainArticle = ArticleEntity(
            title = "Sample Title",
            publishedDate = "2023-06-10",
            byLine = "John Doe",
            url = "https://sample.url"
        )

        // When
        val mappedDomainArticle = ArticlesDomainMapper.mapDataArticleToDomainArticle(dataArticle)

        // Then
        assertEquals(expectedDomainArticle, mappedDomainArticle)
    }

    @Test
    fun `mapDataArticlesToDomainArticles should map data correctly`() {
        // Given
        val dataArticles = listOf(
            Article(
                id = 1L,
                media = emptyList(),
                publishedDate = "2023-06-10",
                section = "Technology",
                source = "My Source",
                subsection = "Mobile",
                title = "Sample Title",
                type = "Article",
                updated = "2023-06-10T12:00:00",
                uri = "sample:uri",
                url = "https://sample.url",
                byline = "John Doe"
            ),
            Article(
                id = 2L,
                media = emptyList(),
                publishedDate = "2023-06-11",
                section = "Business",
                source = "My Source",
                subsection = "Economy",
                title = "Another Sample Title",
                type = "Article",
                updated = "2023-06-11T12:00:00",
                uri = "another:uri",
                url = "https://another-sample.url",
                byline = "Jane Doe"
            )
        )

        val expectedDomainArticles = listOf(
            ArticleEntity(
                title = "Sample Title",
                publishedDate = "2023-06-10",
                byLine = "John Doe",
                url = "https://sample.url"
            ),
            ArticleEntity(
                title = "Another Sample Title",
                publishedDate = "2023-06-11",
                byLine = "Jane Doe",
                url = "https://another-sample.url"
            )
        )

        // When
        val mappedDomainArticles = ArticlesDomainMapper.mapDataArticlesToDomainArticles(dataArticles)

        // Then
        assertEquals(expectedDomainArticles, mappedDomainArticles)
    }
}
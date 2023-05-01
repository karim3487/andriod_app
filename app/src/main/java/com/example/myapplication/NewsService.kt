package com.example.myapplication

class NewsService {

    private var news = mutableListOf<News>()

    init {
        news = (1..10).map {
            News(
                id = it.toLong(),
                from = FROMS[0],
                title = "Группе И591Б подойти в 259 аудиторию на консультацию."
            )
        }.toMutableList()
    }
    fun getNews(): List<News> = news

    companion object {
        private val FROMS = mutableListOf(
            "Логунова Т.В",
            "Васюков В.М.",
            "Вальштейн К.В.",
            "Вальштейн К.В.",
            "Иванык А.О.",
            "Палехова О.А.",
            "Шимкун В.В.",
            "Ракова И.А.",
            "Жарова С.С.",
            "Логунова Т.В"
        )
    }
}
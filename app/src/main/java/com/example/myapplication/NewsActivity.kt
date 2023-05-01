package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.NewsAdapter

class NewsActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    private lateinit var from: Array<String>
    private lateinit var title: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        from = arrayOf(
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

        title = arrayOf(
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
            "Группе и591 подойти в 259 аудиторию на консультацию.",
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        val description =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae nibh aliquet urna pulvinar fringilla. In hac habitasse platea dictumst. Curabitur id faucibus lorem. Nullam elementum ac nulla in convallis. Morbi ultricies mi nunc, quis sodales risus interdum at. Quisque ullamcorper fringilla rhoncus. Integer in vulputate magna. Aenean mattis ac enim vel maximus. Nam in suscipit tortor. Vestibulum sit amet elit id magna volutpat rhoncus sed at mi. Nam venenatis luctus lacus, auctor egestas dolor molestie a. In mattis pharetra dui id lacinia. Aenean lobortis mauris et justo facilisis tempor. Proin vitae tempor elit, sed malesuada justo. Etiam diam tellus, porttitor vitae tincidunt nec, facilisis id tortor.\n\n" + "Nam faucibus, neque sit amet lacinia elementum, lorem risus dapibus diam, et aliquam mi turpis id tortor. Pellentesque pellentesque felis viverra lorem facilisis, eu dignissim diam pulvinar. Sed vel massa id diam vehicula semper at rhoncus dui. Donec nulla nunc, posuere et velit non, dapibus tempus urna. Aliquam felis ipsum, porttitor a lobortis vel, vestibulum sit amet orci. Morbi sem mi, facilisis vitae convallis sit amet, imperdiet vel velit. Phasellus scelerisque purus lorem, aliquet gravida metus tempor non.\n"
        for (i in from.indices) {
            val news = News(i.toLong(), from[i], title[i], description)
            newArrayList.add(news)
        }
        val adapter = NewsAdapter(newArrayList)
        newRecyclerView.adapter = adapter


        adapter.setOnItemClickListener(object : NewsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val fm = this@NewsActivity.supportFragmentManager
                val itemData = newArrayList[position]
                val showPopup = NewsPopup(itemData.from, itemData.title, itemData.description)
                showPopup.show(fm, "showPopup")
            }

        })
    }
}
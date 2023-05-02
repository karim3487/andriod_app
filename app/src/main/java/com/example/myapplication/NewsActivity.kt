package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.NewsAdapter
import com.google.android.material.navigation.NavigationView

class NewsActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    private lateinit var from: Array<String>
    private lateinit var title: Array<String>
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Новости"


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_books -> Toast.makeText(applicationContext, "books", Toast.LENGTH_SHORT)
                    .show()
            }
            true
        }


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        val menuView: View? = findViewById(R.id.nav_view)
        menuView?.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))

        return super.onCreateOptionsMenu(menu)
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
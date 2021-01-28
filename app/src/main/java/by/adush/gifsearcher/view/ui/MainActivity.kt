package by.adush.gifsearcher.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.adush.gifsearcher.R
import by.adush.gifsearcher.view.adapter.GifAdapter
import by.adush.gifsearcher.service.model.GifModel
import by.adush.gifsearcher.viewmodel.GifListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var gifsListViewModel : GifListViewModel
    private var gifAdapter = GifAdapter()
    private var isTrending : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gifsListViewModel  = ViewModelProvider(this).get(GifListViewModel::class.java)

        setSupportActionBar(toolBar)

        setupSearchView()

        configureRecyclerView()
        observeAnyChange()
        observeTrendingGifs()

        gifsListViewModel.trendingGifsApi(10,"g")

    }



    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                gifsListViewModel.searchGifsApi(query,3,"g")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        searchView.setOnClickListener {
            isTrending = false
        }

    }


    private fun observeTrendingGifs() {
        gifsListViewModel.getTrendingGifs().observe(this, Observer {

            if(it != null) {
                for (gifModel: GifModel in it) {
                    Log.v("Tag", "Observer " + gifModel.title + gifModel.images.original.url)
                    gifAdapter.setGifs(it)
                }
            }
        })
    }


    private fun observeAnyChange(){
        gifsListViewModel.getSearchGifs().observe(this, Observer {

            if(it != null) {
                for (gifModel: GifModel in it) {
                    Log.v("Tag", "Observer " + gifModel.title + gifModel.images.original.url)
                    gifAdapter.setGifs(it)
                }
            }
        })
    }


    private fun configureRecyclerView(){
        recyclerView.adapter = gifAdapter
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

}
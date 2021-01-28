package by.adush.gifsearcher.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.adush.gifsearcher.R
import by.adush.gifsearcher.service.model.GifModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.trending_item.view.*

class GifAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var gifs : List<GifModel> = listOf()

    private val DISPLAY_TRENDING = 1
    private val DISPLAY_SEARCH = 2
    val TRENDING : Boolean = false

    class GifViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    class GifTrendingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView : View
        if(viewType == DISPLAY_SEARCH){
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
            return GifViewHolder(itemView)
        }else{
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.trending_item,parent,false)
            return GifTrendingViewHolder(itemView)
        }
    }

    override fun getItemCount(): Int {
        return gifs.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myView : View
        val itemViewType = getItemViewType(position)
        if (itemViewType == DISPLAY_SEARCH){
            myView = (holder as GifViewHolder).itemView

            myView.titleOfGif.text = gifs[position].title
            Glide.with(myView.context).load(gifs[position].images.original.url)
                .into(myView.imageOfGif)
        }else{
            myView =(holder as GifTrendingViewHolder).itemView

            myView.titleOfTrendingGif.text = gifs[position].title
            Glide.with(myView.context).load(gifs[position].images.original.url)
                .into(myView.imageOfTrendingGif)
        }
    }


    fun setGifs(gifs : List<GifModel>){
        this.gifs = gifs
        notifyDataSetChanged()
    }


    override fun getItemViewType(position: Int): Int {
        return if (TRENDING){
            DISPLAY_TRENDING
        }else
            DISPLAY_SEARCH
    }
}

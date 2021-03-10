package com.search.searchimages

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.search.searchimages.activitys.SecondScreenActivity
import kotlinx.android.synthetic.main.tags_item.view.*


class ImageAdapter(private var tags: List<String>, private val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private lateinit var url: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.tags_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        url = tags[position]
        holder.bind(url)
//        holder.itemView.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val activity = v!!.context as AppCompatActivity
//                val secondScreenFragment = SecondScreenFragment()
//                activity.supportFragmentManager.beginTransaction()
//                    .replace(R.id.layout, secondScreenFragment).addToBackStack(null).commit()
//            }
//
//        })
        holder.itemView.context
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(url: String) {
            Glide.with(context)
                .load(url)
                .into(itemView.imageView)
//            itemView.tagTV.text = url

        }

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SecondScreenActivity::class.java)
                intent.putExtra("url", url)
                itemView.context.startActivity(intent)
            }
        }

    }
}



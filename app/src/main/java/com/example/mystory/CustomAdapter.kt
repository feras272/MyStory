package com.example.mystory

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CustomAdapter(val storiesList:ArrayList<Story>, val context:Context):RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        // we need to show the custom layout we have created
        val dataHolder:DataHolder = DataHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.cutom_layout, parent, false
        ))

        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        // take object array to put every item elements
        val story = storiesList[position]
        // we have data in our array -> we put the data in each iteration to the story data in the holder
        holder.storyTitle.text = story.title
        holder.storySubTitle.text = story.subtitle
        holder.storyLetter.text = story.title.first().toString()

        generateColors(holder, position)
//        holder.cardViewLetter.setOnClickListener {
//            Toast.makeText(context, "Card View Circle Selected", Toast.LENGTH_LONG).show()
//        }
        holder.itemView.setOnClickListener {
            val intent:Intent = Intent(context, StoryDetailsActivity::class.java)
            intent.putExtra("title", story.title)
            intent.putExtra("desc", story.description)
            context.startActivity(intent)
        }
    }

    private fun generateColors(holder:DataHolder, position: Int) {
        val r = java.util.Random()
        val red = r.nextInt(255+position)
        val grean = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red,grean,blue))


    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    // interacting with DataHolder as MainActivity -> will return cells
    class DataHolder(item:View):RecyclerView.ViewHolder(item) {
        val storyTitle:TextView = item.findViewById(R.id.tv_title_cutom_layout)
        val storySubTitle:TextView = item.findViewById(R.id.tv_subtitle_custom_layout)
        val storyLetter:TextView = item.findViewById(R.id.tv_first_letter_custom_layout)
        val cardViewLetter:CardView = item.findViewById(R.id.circle)
    }

}
package com.uttampanchasara.multitheme.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uttampanchasara.multitheme.R
import com.uttampanchasara.multitheme.model.ThemeModel
import kotlinx.android.synthetic.main.list_theme.view.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/2/2018
 */
class MultiThemeListAdapter(val listener: ThemeChangeListener) : RecyclerView.Adapter<ViewHolder>() {

    private var themesList: ArrayList<ThemeModel> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_theme, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return themesList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val themeModel = themesList[position]

        when (position) {
            0 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#008577"))
            }
            1 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#000000"))
            }
            2 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#8BC34A"))
            }
            3 -> {
                viewHolder.itemView.view.setBackgroundColor(Color.parseColor("#673AB7"))
            }
        }
        viewHolder.itemView.setOnClickListener {
            listener.onThemeChanged(themeModel)
        }
    }

    fun setData(themesList: ArrayList<ThemeModel>) {
        this.themesList = themesList
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(themeModel: ThemeModel) {
        itemView.view.setBackgroundColor(Color.parseColor("#8BC34A"))
    }
}

interface ThemeChangeListener {
    fun onThemeChanged(themeModel: ThemeModel)
}
package se.magictechnology.piax20jan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter() : RecyclerView.Adapter<ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val vh = ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

    }

}

class ShoppingViewHolder (view: View) : RecyclerView.ViewHolder(view) {



}
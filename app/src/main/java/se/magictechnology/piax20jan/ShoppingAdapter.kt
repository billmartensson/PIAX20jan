package se.magictechnology.piax20jan

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter() : RecyclerView.Adapter<ShoppingViewHolder>() {

    var shoppinglist = mutableListOf<ShopThing>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val vh = ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return shoppinglist.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        holder.itemTextview.text = shoppinglist[position].shopname

        holder.itemAmountTextview.text = shoppinglist[position].shopamount.toString() + " st"

        holder.itemRemoveButton.setOnClickListener {
            Log.i("PIAXDEBUG", "RADERA RAD " + position.toString())
            shoppinglist.removeAt(position)
            //notifyItemRemoved(position)
            notifyDataSetChanged()
        }

    }

}

class ShoppingViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var itemTextview = view.findViewById<TextView>(R.id.shoppingItemTextView)
    var itemAmountTextview = view.findViewById<TextView>(R.id.shoppingItemAmountTextview)
    var itemRemoveButton = view.findViewById<Button>(R.id.shoppingItemRemoveButton)

}
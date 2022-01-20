package se.magictechnology.piax20jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var shoppingAdapter = ShoppingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shoppingRV = findViewById<RecyclerView>(R.id.shoppingRV)

        shoppingRV.layoutManager = LinearLayoutManager(this)
        shoppingRV.adapter = shoppingAdapter

        findViewById<Button>(R.id.addButton).setOnClickListener {
            val addtext = findViewById<EditText>(R.id.addItemNameEdittext).text.toString()
            val addamount = findViewById<EditText>(R.id.addItemAmountEdittext).text.toString()

            val tempshop = ShopThing()
            tempshop.shopname = addtext

            addamount.toIntOrNull()?.let { theamount ->
                tempshop.shopamount = theamount
            }

            if(addamount.toIntOrNull() == null)
            {
                // VISA FELMEDDELANDE
                Log.i("PIAXDEBUG", "SIFFRA ÄR NULL")
                //Toast.makeText(this, "Inte siffra", Toast.LENGTH_LONG).show()
                val snack = Snackbar.make(it, "Inte en siffra", Snackbar.LENGTH_INDEFINITE)
                snack.setAction("Jepp") {

                }
                snack.show()

                return@setOnClickListener
            }

            shoppingAdapter.shoppinglist.add(tempshop)

            shoppingAdapter.notifyItemInserted(shoppingAdapter.shoppinglist.size-1)
        }

    }
}

/*

    0   Banan
    1   Kiwi
    2   Apelsin
    3   Utemöbler
    4   Ko
 */







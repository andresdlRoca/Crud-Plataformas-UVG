package com.prueba.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    })



    val items : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        creationBtn.setOnClickListener{
            addItem()
        }

        creationBtn.setOnLongClickListener{
            deleteItemClickHold()
        }

        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setItems(items)

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    fun showItemClick(position:Int){
        val item = adaptador.getItem(position)
        val texto = inputEdit.text.toString()
        items.set(position, texto)
        adaptador.setItems(items)

        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

    fun deleteItemClickHold(): Boolean {
        val texto = inputEdit.text.toString()
        items.remove(texto)
        adaptador.setItems(items)
        return true
    }

    fun addItem() {
        val texto = inputEdit.text.toString()
        items.add(texto)
        adaptador.setItems(items)
    }
}
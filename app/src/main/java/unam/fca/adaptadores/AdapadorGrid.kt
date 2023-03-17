package unam.fca.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo

class AdapadorGrid(private val context: Context,
                   private val autos: MutableList<Automovil>):BaseAdapter() {
    override fun getCount(): Int {
        return autos.size
    }

    override fun getItem(position: Int): Any {
     return autos[position]
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var view= convertView
        val holder: ItemHolder
        if (view== null){
            view = LayoutInflater.from(context).inflate(R.layout.automovil, null)
            holder = ItemHolder(view)
            view.tag = holder

        }else
        {
            holder =view.tag as ItemHolder


        }
        val auto: Automovil = autos[position]
        holder.imagen.setImageResource(auto.imagen)
        holder.marca.text = auto.marca
        holder.modelo.text = auto.modelo
        holder.precio.text =  auto.precio
        return view as View
    }
    internal class ItemHolder (view: View){
        var imagen : ImageView= view.findViewById(R.id.imagen)
        var marca :TextView = view.findViewById(R.id.marca)
        var modelo :TextView = view.findViewById(R.id.modelo)
        var precio :TextView = view.findViewById(R.id.precio)
    }

}
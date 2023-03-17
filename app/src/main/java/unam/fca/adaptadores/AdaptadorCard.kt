package unam.fca.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCard (private val context: Context,
                        private val autos: MutableList<Automovil>):
                        RecyclerView.Adapter<AdaptadorCard.ViewHolder>(){
                            class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
                                var ivImagen :ImageView = itemView .findViewById(R.id.imagen)
                                var ivMarca :TextView = itemView .findViewById(R.id.marca)
                                var ivModelo :TextView = itemView .findViewById(R.id.modelo)
                                var ivPrecio :TextView = itemView .findViewById(R.id.precio)
                                fun  bind (auto: Automovil){
                                    itemView.setOnClickListener {
                                        Toast.makeText(itemView.context,"Elegiste: ${auto.marca},"+ "${auto.modelo}, $ ${auto.precio}", Toast.LENGTH_LONG).show()
                                    }
                                }
                            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val auto: Automovil  = autos[position]
        holder.ivImagen.setImageResource(auto.imagen)
        holder.ivMarca.text =auto.marca
        holder.ivMarca.text =auto.marca
        holder.ivModelo.text =auto.modelo
        holder.ivPrecio.text =auto.precio
        holder.bind(auto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.automovil_card, parent, false)
        return ViewHolder (view)
    }

    override fun getItemCount(): Int {
        return autos.size
    }
}
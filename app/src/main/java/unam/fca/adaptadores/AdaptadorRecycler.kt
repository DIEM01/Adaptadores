package unam.fca.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdaptadorRecycler(private val context: Context,
                        private val autos: MutableList<Automovil>) :
                        RecyclerView.Adapter<AdaptadorRecycler.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImagen: ImageView= itemView.findViewById(R.id.imagen)
        var tvMarca: TextView= itemView.findViewById(R.id.marca)
        var tvModelo: TextView= itemView.findViewById(R.id.modelo)
        var tvPrecio: TextView= itemView.findViewById(R.id.precio)
        fun bind(auto:Automovil){


            itemView.setOnClickListener { Toast.makeText(itemView.context, "Elegiste:"+auto.marca+ " ,"+
                    auto.modelo+ " ,$"+auto.precio,Toast.LENGTH_LONG).show() }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater :LayoutInflater= LayoutInflater.from(context)
        val view= layoutInflater.inflate(R.layout.automovil,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return autos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val auto:Automovil=autos[position]
        holder.ivImagen.setImageResource(auto.imagen)
        holder.tvMarca.text= auto.marca
        holder.tvModelo.text=auto.modelo
        holder.tvPrecio.text=auto.precio
        holder.bind(auto)
    }
}
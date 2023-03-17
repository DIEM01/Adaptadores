package unam.fca.adaptadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var lista: ListView
    private lateinit var grid: GridView
    private lateinit var recycler: RecyclerView
    private lateinit var gridPers: GridView
    private lateinit var card: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinVista)
        lista = findViewById(R.id.lista)
        grid = findViewById(R.id.grid)
        recycler= findViewById(R.id.recycler)
        gridPers=findViewById(R.id.gridPers)
        card=findViewById(R.id.card)
        iniciarSpinner()
        iniciarLista()
        iniciarGrid()
        iniciarRecycler()
        iniciarGridPers()
        iniciarCard()

    }

    private fun iniciarSpinner() {
        spinner.adapter = ArrayAdapter(
            this,
            androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.vistas)
        )
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> {
                            lista.visibility = View.VISIBLE
                            grid.visibility = View.INVISIBLE
                            recycler.visibility= View.INVISIBLE
                            gridPers.visibility=View.INVISIBLE
                            card.visibility= View.INVISIBLE

                        }
                        1 -> {
                            lista.visibility = View.INVISIBLE
                            grid.visibility = View.VISIBLE
                            recycler.visibility= View.INVISIBLE
                            gridPers.visibility=View.INVISIBLE
                            card.visibility= View.INVISIBLE
                        }
                        2-> {
                            lista.visibility = View.INVISIBLE
                            grid.visibility = View.INVISIBLE
                            recycler.visibility= View.VISIBLE
                            gridPers.visibility=View.INVISIBLE
                            card.visibility= View.INVISIBLE
                        }
                        3-> {
                            lista.visibility = View.INVISIBLE
                            grid.visibility = View.INVISIBLE
                            recycler.visibility= View.VISIBLE
                            gridPers.visibility=View.VISIBLE
                            card.visibility= View.INVISIBLE
                        }
                        4-> {
                            lista.visibility = View.INVISIBLE
                            grid.visibility = View.INVISIBLE
                            recycler.visibility= View.INVISIBLE
                            gridPers.visibility=View.INVISIBLE
                            card.visibility= View.VISIBLE
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }

    private fun iniciarLista() {
        lista.setOnItemClickListener { parent, view, position, id ->
            val auto = parent.getItemIdAtPosition(position)
            Toast.makeText(
                this, "Elegiste el auto: $auto",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun iniciarGrid() {
        grid.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_gallery_item,
            resources.getStringArray(R.array.autos)
        )
        grid.setOnItemClickListener { parent, view, position, id ->
            val auto = parent.getItemAtPosition(position)
            //val auto = parent.getItemIdAtPosition(position)
            Toast.makeText(
                this, "Elegiste el auto: $auto",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun getAutomoviles(): MutableList<Automovil> {
        val autos: MutableList<Automovil> = mutableListOf()
        autos.add(Automovil(R.mipmap.audi, "Audi", "R8", "1908000"))
        autos.add(Automovil(R.mipmap.bmw, "BMW", "R8", "2299000"))
        autos.add(Automovil(R.mipmap.chrysler, "Chrysler", "200","299300"))
        autos.add(Automovil(R.mipmap.ferrari, "Ferrari", "458", "5250000"))
        autos.add(Automovil(R.mipmap.ford, "Ford", "Shelby GT500", "839000"))
        autos.add(Automovil(R.mipmap.gmc, "GMC", "Sierra", "819000"))
        autos.add(Automovil(R.mipmap.honda, "Honda", "Accord Sport", "3449900"))
        autos.add(Automovil(R.mipmap.lamborghini, "Lamborghini", "Aventador LP 700", "5250000"))
        autos.add(Automovil(R.mipmap.lotus, "Lotus", "Evora 400", "5000000"))
        autos.add(Automovil(R.mipmap.mazda, "Mazda", "MX 5", "395500"))
        autos.add(Automovil(R.mipmap.mercedesbenz, "Mercedez Benz", "SLR", "1390000"))
        autos.add(Automovil(R.mipmap.nissan, "Nissan", "370Z", "549900"))
        autos.add(Automovil(R.mipmap.peugeot, "Pegeout", "RCZ", "589900"))
        autos.add(Automovil(R.mipmap.porsche, "Porche", "Cayman", "1296000"))
        autos.add(Automovil(R.mipmap.renault, "Renault", "Fluence", "240000"))
        autos.add(Automovil(R.mipmap.suzuki, "Susuki", "Ciaz", "239900"))
        autos.add(Automovil(R.mipmap.toyota, "Toyota", "Camry", "326600"))
        autos.add(Automovil(R.mipmap.volkswagen, "Volkswagen", "Passat CC", "660900"))
        return autos
    }
    private fun iniciarRecycler (){
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter=AdaptadorRecycler(this, getAutomoviles())

    }
    private fun iniciarGridPers(){
        gridPers.adapter= AdapadorGrid(this, getAutomoviles())
        gridPers.setOnItemClickListener{parent, view,position, id ->
            val auto = parent.getItemAtPosition(position) as Automovil
            Toast.makeText(this,"Elegiste el ${auto.marca}, "+
            "${auto.modelo},$ ${auto.precio}", Toast.LENGTH_LONG).show()
        }

    }

    private fun iniciarCard(){
        card.layoutManager= LinearLayoutManager(this)
        card.setHasFixedSize(true)
        card.adapter = AdaptadorCard (this,getAutomoviles())


    }


}
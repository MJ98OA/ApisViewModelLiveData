package com.example.apis

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.databinding.ModeloplanetaBinding


class PlanetasAdapter(var listaPlanetas: MutableList<Planet>):RecyclerView.Adapter<PlanetasAdapter.PlanetasViewHolder>(){

    lateinit var context:Context


    class PlanetasViewHolder (var itemBinding: ModeloplanetaBinding):RecyclerView.ViewHolder(itemBinding.root)


    override fun getItemCount(): Int {
        return listaPlanetas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetasViewHolder {
        val binding=ModeloplanetaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context=parent.context
        return PlanetasViewHolder(binding)


    }



    override fun onBindViewHolder(holder: PlanetasViewHolder, position: Int) {

        holder.itemBinding.textoPlaneta.text=listaPlanetas.get(position).name

        holder.itemBinding.textoPlaneta.setOnClickListener{
            var a=holder.itemBinding.root.context
            DatosEspecificos.launch(
                holder.itemBinding.layoutPlanetas.context,
                listaPlanetas.get(position).toString()
            )
        }
    }




}
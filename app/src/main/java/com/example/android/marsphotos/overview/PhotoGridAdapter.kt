package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter :
    ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotosViewHolder>(DiffCallback)
{

    class MarsPhotosViewHolder(
        // Creamos la variable GridViewItemBinding para vincular Marsphoto con el diseño
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        //Creamos el metodo bind() que recibe un objeto
        fun bind(marsPhoto: MarsPhoto) {
            binding.photo = marsPhoto
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>(){

        //DiffCallback utiliza el metodo para saber si dos objetos representan
        //el mismo elemento
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }
        //Verificamos si dos elementos tienen los mismos datos
        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

    }

    //Este metodo retorna un MarsPhotosViewHolder aunmentando
    // las vistas en GridViewItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarsPhotosViewHolder{
        return MarsPhotosViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    //Este metodo seteas la lista segun la posicion
    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}



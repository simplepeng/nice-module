package me.simple.nm.multitype

import android.view.LayoutInflater
import android.view.ViewGroup
import com.drakeet.multitype.ItemViewBinder
import me.simple.ktx.singleClick

abstract class NiceItemBinder<T>(
    private val onItemClick: ((position: Int, item: T) -> Unit)? = null
) :ItemViewBinder<T, ItemViewHolder>() {

    abstract fun setLayoutRes(): Int
    abstract fun onBind(holder: ItemViewHolder, item: T)

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemViewHolder {
        val itemView = inflater.inflate(setLayoutRes(), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        item: T
    ) {
        onBind(holder, item)
        holder.itemView.singleClick {
            onItemClick?.invoke(holder.adapterPosition, item)
        }
    }
}
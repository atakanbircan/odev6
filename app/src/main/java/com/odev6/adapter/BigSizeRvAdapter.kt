package com.odev6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odev6.R
import com.odev6.databinding.BigSizeRvCardBinding
import com.odev6.model.ChildItem
import com.odev6.model.ContentToBigSize

class BigSizeRvAdapter(var mContext: Context, var contentList: List<ChildItem>)
    : RecyclerView.Adapter<BigSizeRvAdapter.BigSizeRvCardTutucu>(){
    inner class BigSizeRvCardTutucu(var gDesign: BigSizeRvCardBinding) : RecyclerView.ViewHolder(gDesign.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigSizeRvCardTutucu{
        val binding = BigSizeRvCardBinding.inflate(LayoutInflater.from(mContext),parent,false)


        return BigSizeRvCardTutucu(binding)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: BigSizeRvCardTutucu, position: Int) {
        val content = contentList.get(position)
        val t = holder.gDesign

        t.imageviewBigRv.setImageResource(
            mContext.resources.getIdentifier(content.img,"drawable",mContext.packageName)) //img için ilgili datada string drwadaki ismin koymalıyım!

    }
}
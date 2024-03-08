package com.odev6.adapter

import android.content.Context
import android.graphics.Outline
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.RecyclerView
import com.odev6.databinding.HiglightsRvCardBinding
import com.odev6.model.ChildItem

class OneCikanRvAdapter(var mContext: Context, var imgList: List<ChildItem>)
    : RecyclerView.Adapter<OneCikanRvAdapter.OneCikanRvCardTutucu>() {


    inner class OneCikanRvCardTutucu(var design : HiglightsRvCardBinding) : RecyclerView.ViewHolder(design.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneCikanRvCardTutucu {
        val binding = HiglightsRvCardBinding.inflate(LayoutInflater.from(mContext),parent, false)
        return OneCikanRvCardTutucu(binding)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: OneCikanRvCardTutucu, position: Int) {
        val img = imgList.get(position)
        val i = holder.design

        i.imageView.outlineProvider = object : ViewOutlineProvider(){
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, view.height, 50f)
            }
        }
        i.imageView.clipToOutline = true

        i.imageView.setImageResource(
            mContext.resources.getIdentifier(img.img,"drawable",mContext.packageName)
        )
    }
}
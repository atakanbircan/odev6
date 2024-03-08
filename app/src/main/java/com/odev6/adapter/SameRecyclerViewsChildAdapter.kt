package com.odev6.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.odev6.databinding.SameRecyclerviewChildCardBinding
import com.odev6.model.ChildItem

class SameRecyclerViewsChildAdapter(var mContext: Context, var childSameContentList: List<ChildItem>)
    : RecyclerView.Adapter<SameRecyclerViewsChildAdapter.SameRecyclerViewChildCardTutucu>(){

    inner class SameRecyclerViewChildCardTutucu(var design : SameRecyclerviewChildCardBinding)
        : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SameRecyclerViewChildCardTutucu {
        val binding = SameRecyclerviewChildCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SameRecyclerViewChildCardTutucu(binding)
    }

    override fun getItemCount(): Int {
        return childSameContentList.size
    }

    override fun onBindViewHolder(holder: SameRecyclerViewChildCardTutucu, position: Int) {
        val itemOfCard = childSameContentList.get(position)
        //Log.e("Torunda olması gereken",itemOfCard.grandParentList[position].tittle)
        val i = holder.design

        //i.txtTurTitle.text= itemOfCard.tittle
        //val grandChildRvAdapter = GrandChildRvAdapter(mContext,itemOfCard.mList)

        //i.langRecyclerView.adapter = grandChildRvAdapter

        //i.langRecyclerView.setHasFixedSize(true)
        //i.langRecyclerView.layoutManager = SlowLinearLayoutManager(mContext,LinearLayout.HORIZONTAL,false)

        i.langImageView.setImageResource(
            mContext.resources.getIdentifier(itemOfCard.img,"drawable",mContext.packageName)
        )

    }


}
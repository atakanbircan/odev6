package com.odev6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.odev6.SlowLinearLayoutManager
import com.odev6.databinding.MainPageAdapterCardBinding
import com.odev6.model.GrandParentItem

class MainRvAdapter(var mcontext: Context, val parentList: List<GrandParentItem>)
    :RecyclerView.Adapter<MainRvAdapter.MainViewHolder>(){



    inner class MainViewHolder(var design : MainPageAdapterCardBinding) : RecyclerView.ViewHolder(design.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = MainPageAdapterCardBinding.inflate(LayoutInflater.from(mcontext),parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {


        holder.design.horizontalScrollViewBtn.visibility = View.GONE


        val currentItem = parentList[position]



        if (currentItem.tittle == "Big SizeRv") {
            holder.design.horizontalScrollViewBtn.visibility = View.VISIBLE
            val bigSizeRvAdapter = BigSizeRvAdapter(mcontext, currentItem.mList)
            holder.design.recyclerViewToBigSize.adapter = bigSizeRvAdapter
            holder.design.recyclerViewToBigSize.setHasFixedSize(true)
            holder.design.recyclerViewToBigSize.layoutManager = SlowLinearLayoutManager(
                mcontext, LinearLayoutManager.HORIZONTAL, false
            )
            val snapHelper = LinearSnapHelper()
            val snapOnePageHelper = PagerSnapHelper()
            snapOnePageHelper.attachToRecyclerView(holder.design.recyclerViewToBigSize)


            holder.design.recyclerViewToBigSize.onFlingListener = object : RecyclerView.OnFlingListener(){
                override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                    holder.design.recyclerViewToBigSize.smoothScrollBy(velocityX / 4 , velocityY / 4)
                    return true
                }
            }

        } else if (currentItem.tittle == "Öne Çıkanlar") {
            holder.design.txtHighlights.visibility = View.VISIBLE
            holder.design.txtHighlights.text = currentItem.tittle
            val highlightsRvAdapter = OneCikanRvAdapter(mcontext, currentItem.mList)
            holder.design.recyclerViewToHiglights.adapter = highlightsRvAdapter
            holder.design.recyclerViewToHiglights.setHasFixedSize(true)
            holder.design.recyclerViewToHiglights.layoutManager = SlowLinearLayoutManager(
                mcontext, LinearLayoutManager.HORIZONTAL, false
            )
        }else if (currentItem.tittle == "Yeni Eklenenler") {
            holder.design.txtNews.visibility = View.VISIBLE
            holder.design.txtNews.text = currentItem.tittle
            val sameRecyclerViewsChildAdapter = SameRecyclerViewsChildAdapter(mcontext,currentItem.mList)
            holder.design.recyclerViewOfSameContents.adapter = sameRecyclerViewsChildAdapter
            holder.design.recyclerViewOfSameContents.setHasFixedSize(true)
            holder.design.recyclerViewOfSameContents.layoutManager = SlowLinearLayoutManager(
                mcontext,LinearLayoutManager.HORIZONTAL,false
            )

        }

        else {
            holder.design.txtHighlights.visibility = View.INVISIBLE

        }









    }
}
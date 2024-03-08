package com.odev6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.odev6.adapter.MainRvAdapter
import com.odev6.databinding.FragmentMainBinding
import com.odev6.model.ChildItem
import com.odev6.model.GrandParentItem
import com.odev6.model.MainPageItem

class MainFragment : Fragment() {
    //private val mainPageItemList = ArrayList<MainPageItem>()
    private val grandParentItemList = ArrayList<GrandParentItem>()
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDataTodoList()
        val rvMainAdapter = MainRvAdapter(requireContext(),grandParentItemList)
        binding.mainFragmentPageMainRv.adapter = rvMainAdapter
        binding.mainFragmentPageMainRv.setHasFixedSize(true)
        binding.mainFragmentPageMainRv.layoutManager = SlowLinearLayoutManager(
            requireContext(),LinearLayoutManager.VERTICAL,false)


    }

    private fun addDataTodoList() {

        val childItemBigSize = ArrayList<ChildItem>()
        childItemBigSize.add(ChildItem("playboy"))
        childItemBigSize.add(ChildItem("sanditon"))
        childItemBigSize.add(ChildItem("gorbeni"))
        childItemBigSize.add(ChildItem("acikmikrofon"))
        val parentItem =ArrayList<GrandParentItem>()

        //mainPageItemList.add(MainPageItem("Big SizeRv",childItemBigSize))
        grandParentItemList.add(GrandParentItem("Big SizeRv",childItemBigSize,parentItem))


        val childItemHighlights = ArrayList<ChildItem>()
        childItemHighlights.add(ChildItem("onecikan1"))
        childItemHighlights.add(ChildItem("onecikan2"))
        childItemHighlights.add(ChildItem("onecikan3"))
        childItemHighlights.add(ChildItem("onecikan4"))

        //mainPageItemList.add(MainPageItem("Öne Çıkanlar",childItemHighlights))
        grandParentItemList.add(GrandParentItem("Öne Çıkanlar",childItemHighlights,parentItem))



        val childItem1 = ArrayList<ChildItem>()
        childItem1.add(ChildItem("yakinda1"))
        childItem1.add(ChildItem("yakinda2"))
        childItem1.add(ChildItem("yakinda3"))
        childItem1.add(ChildItem("yakinda4"))
        //mainPageItemList.add(MainPageItem("Yeni Eklenenler", childItem1))
        grandParentItemList.add(GrandParentItem("Yeni Eklenenler",childItem1,parentItem))

        val childItem2 = ArrayList<ChildItem>()
        childItem2.add(ChildItem("yakinda1"))
        childItem2.add(ChildItem("yakinda2"))
        childItem2.add(ChildItem("yakinda3"))
        childItem2.add(ChildItem("yakinda4"))

        //mainPageItemList.add(MainPageItem("Yakında  GAİN'de!", childItem2))
        grandParentItemList.add(GrandParentItem("Yakında  GAİN'de!",childItem2,parentItem))

        val childItem3 = ArrayList<ChildItem>()
        childItem3.add(ChildItem("onecikan1"))
        childItem3.add(ChildItem("onecikan2"))
        childItem3.add(ChildItem("onecikan3"))
        childItem3.add(ChildItem("onecikan4"))

        //mainPageItemList.add(MainPageItem("GAİN Orjinal Komediler", childItem3))
        grandParentItemList.add(GrandParentItem("GAİN Orjinal Komediler!",childItem3,parentItem))


/*
        val c1 = ContentToBigSize(1,"The Playboy Murders","Genel İzleyici",2,"playboy")
        val c2 = ContentToBigSize(2,"Sanditon","Genel İzleyici",2,"sanditon")
        val c3 = ContentToBigSize(3,"Gör Beni","Genel İzleyici",3,"gorbeni")
        val c4 = ContentToBigSize(4,"Açık Mikrofon","Genel İzleyici",1,"acikmikrofon")



 */

    }

}
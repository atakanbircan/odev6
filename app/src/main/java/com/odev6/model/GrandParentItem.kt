package com.odev6.model

data class GrandParentItem(
    val tittle: String,
    val mList:List<ChildItem>,
    val grandParentList: ArrayList<GrandParentItem>
)

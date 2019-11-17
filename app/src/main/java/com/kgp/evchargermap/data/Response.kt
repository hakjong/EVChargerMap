package com.kgp.evchargermap.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="item")
class Item{
    @field:Element(name="addr")
    var addr:String = ""

    @field:Element(name="chargeTp")
    var chargeTp:String = ""

    @field:Element(name="cpId")
    var cpId:String = ""

    @field:Element(name="cpNm")
    var cpNm:String = ""

    @field:Element(name="cpStat")
    var cpStat:String = ""

    @field:Element(name="cpTp")
    var cpTp:String = ""

    @field:Element(name="csId")
    var csId:String = ""

    @field:Element(name="csNm")
    var csNm:String = ""

    @field:Element(name="lat")
    var lat:String = ""

    @field:Element(name="longi")
    var longi:String = ""

    @field:Element(name="statUpdateDatetime")
    var statUpdateDatetime:String = ""
}

@Root(name="items")
class Items {
    @field:ElementList(inline=true, required= false)
    lateinit var itemList :List<Item>
}

@Root(name="body")
class Body {
    @field:Element(name="items")
    var items:Items? = null

    @field:Element(name="numOfRows")
    var numOfRows:Int = -1

    @field:Element(name="pageNo")
    var pageNo:Int = -1

    @field:Element(name="totalCount")
    var totalCount:Int = -1
}

@Root(name="header")
class Header{
    @field:Element(name="resultCode")
    var resultCode:String = ""

    @field:Element(name="resultMsg")
    var resultMsg:String = ""

}

@Root(name="response")
class Response {
    @field:Element(name="header")
    var header:Header? = null

    @field:Element(name="body")
    var body : Body? = null

}
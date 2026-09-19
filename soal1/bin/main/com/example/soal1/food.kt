package com.example.soal1

class food(var inputname:String, var inputprice: Int, var inputdesc: String) {
    private var name= inputname
    fun getnama(): String{
        return name
    }
    fun setnama(inputnama:String){
        name=inputnama
    }

    private var desc= inputdesc
    fun getdesc(): String{
        return desc
    }
    fun setdesc(inputdesc:String){
        desc=inputdesc
    }
    private var price=inputprice
    fun getprice(): Int{
        return price
    }
    fun setprice(inputprice:Int){
        price=inputprice
    }

    private var jumlahPesan=0
    fun getJumlahPesan(): Int{
        return jumlahPesan
    }

    fun hapusPesan(){
        jumlahPesan=0
    }

    fun tambahPesan(inputJumlahPesan: Int){
        jumlahPesan = jumlahPesan+inputJumlahPesan
    }
}
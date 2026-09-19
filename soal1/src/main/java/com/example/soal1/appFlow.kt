package com.example.soal1

class appFlow {
    var input: String = ""
    var listMenu = ArrayList<food>()
    var listOrder = ArrayList<food>()

    fun run(){
        var menu1= food("Nasi Goreng",150, "nasi dan isian daging yang digoreng dengan cita rasa yang lezat")
        listMenu.add(menu1)
        menu1= food("Mie Goreng",145, "mie kuning dengan saos kecap")
        listMenu.add(menu1)
        menu1= food("Nasi Kuning Jumbo",152,"Nasi dengan perasan kunyit")
        listMenu.add(menu1)

        while(true){
            input = sendList()
            println("\n\n\n")
            when (input){
                "1" -> makeOrder()
                "2" -> viewOrder()
                "3" -> viewMenu()
                "4" -> addMenu()
                "5" -> break
                "6" -> break
                "7" -> return
            }
        }
    }

    fun sendList(): String{
        println("ORDER SYSTEM\n" +
                "1. Make order\n" +
                "2. View Orders\n" +
                "3. View Menu\n" +
                "4. Add Menu\n" +
                "5. Edit Menu\n" +
                "6. Delete Menu\n" +
                "7. Exit\nInput: ")
        input = readln()
        return input
    }

    fun viewMenu() {
        println("MENU RESTO")
        for ((index, m) in listMenu.withIndex()) {
            val nomor = index + 1
            println("$nomor. ${m.getnama()}         $${m.getprice()}")
            println("${m.getdesc()}")
        }
        print("\n\n")
    }

    fun viewOrder() {
        var total=0
        println("——— <Customer>’s ORDER ——-")
        for ((index, m) in listMenu.withIndex()) {
            if(m.getJumlahPesan()!=0) {
                val nomor = index + 1
                println("$nomor. ${m.getnama()} x${m.getJumlahPesan()}        $${(m.getprice() * m.getJumlahPesan())}")
                total = total + (m.getprice() * m.getJumlahPesan())
            }
        }
        println("TOTAL          $$total")
        print("\n\n")
    }



    fun makeOrder(){
        viewMenu()
        var input : String=""
        print("Pick Menu? ")
        input=readln()
        var foodd: food=listMenu.get(input.toInt()-1)
        print("How Many? ")
        input=readln()
//        foodd.tambahPesan(input.toInt())
//        listOrder.add(foodd)
        var ada=0
        for ((index, m) in listOrder.withIndex()) {
            val nomor = index + 1

            if (m==foodd){
                ++ada
            } else{

            }
        }
        if (ada>0){
            foodd.tambahPesan(input.toInt())
            //print("p udh ada")
        } else{
            foodd.tambahPesan(input.toInt())
            listOrder.add(foodd)
            //print("p baru")
        }


    }

    fun delMenu(){
        println("DELETE MENU")
        viewMenu()
        print("Pilih menu yang ingin dihapus")
    }

    fun addMenu(){
        println("ADD MENU")
        print("Input nama menu baru: ")
        val inputNama=readln()
        print("Input harga menu baru: ")
        val inputHarga=readln()
        print("Input deskripsi singkat mengenai menu baru: ")
        val inputDesc=readln()
        val menu1= food(inputNama.toString(),inputHarga.toInt(),inputDesc)
        listMenu.add(menu1)
        println("Menu $inputNama berhasil terbuat.\n\n\n")
    }
}
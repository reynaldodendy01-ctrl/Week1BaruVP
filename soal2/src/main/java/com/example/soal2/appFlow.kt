package com.example.soal2

import kotlin.random.Random

class appFlow {
    var user: User = User("", 50, 30, 0, 5, 5, false, 10, 0, 50, 30)
    fun run(){
        print("Masukan nama: ")
        val name = readLine()
        user.setUsername(name)
        println("Good luck, $name ! You’re gonna need it!\n\n\n")
        mainMenu()
    }
    fun mainMenu(){
        println("What you're going to do?")
        println("1. View Stats")
        println("2. Enter \n")
        println("Choose:")
        val choose = (readlnOrNull()?.toIntOrNull() ?: 0)
        if (choose == 1){
            viewStats()
        }else if(choose == 2){
            enterBattle()
        }else{
            println("Please choose the following menu!\n\n\n")
            mainMenu()
        }
        mainMenu()
    }
    fun drinkHealth(){
        if (user.getHealthPotion()>0){
            if (user.getHp().plus(25) >= user.getMaxHp()){
                user.setHp(user.getMaxHp())
                user.setHealthPotion(user.getHealthPotion()-1)
            }else{
                user.setHp(user.getHp()+25)
                user.setHealthPotion(user.getHealthPotion()-1)
            }
        }else{
            println("Health potion tidak cukup\n\n")
        }
    }

    fun drinkMana(){
        if (user.getManaPotion()>0){
            if (user.getMana().plus(15) >= user.getMaxMana()){
                user.setMana(user.getMaxMana())
                user.setManaPotion(user.getManaPotion()-1)
            }else{
                user.setMana(user.getMana()+15)
                user.setManaPotion(user.getManaPotion()-1)
            }
        }else{
            println("Mana potion tidak cukup\n\n")
        }
    }

    fun rename(){
        println("Masukan nama:")
        val name: String = readLine()!!
        user.setUsername(name)
        println("Rename berhasil!\n\n")
    }
    fun lifestealSuperPower(){
        if(user.getIsSuper()==true){
            if (user.getHp().plus(user.getKill()) >= user.getMaxHp()){
                user.setHp(user.getMaxHp())

                print("You got ${user.getKill()} health lifesteal!")
            }else{
                user.setHp(user.getHp()+user.getKill())

                print("You got ${user.getKill()} health lifesteel!")
            }
        }
    }

    fun viewStats(){
        while (true){
            println("-------${user.getUsername()}'s Stats--------")
            println("HP = ${user.getHp()}/${user.getMaxHp()}")
            println("Mana = ${user.getMana()}/${user.getMaxMana()}")
            println("Kill needed to evolve = ${user.getKill()}/5")
            println("Health Potions held = ${user.getHealthPotion()}")
            println("Mana Potions held = ${user.getManaPotion()}")
            println("---------------------------------------------")
            println("1. Drink Mana Potion")
            println("2. Drink Health Potion")
            println("3. Rename Self")
            println("4. Back")
            println("Default (Back)")
            println("Choose:")
            val inputs = (readlnOrNull()?.toIntOrNull() ?: 4)
            if (inputs == 1){
                drinkMana()
            }else if(inputs == 2){
                drinkHealth()
            }else if (inputs == 3){
                rename()
            }else if (inputs == 4){
                break
            }

        }

    }
    fun enterBattle(){
        if (user.getHp() > 0){
            val a = Random.nextInt(1,4)
            val hp = Random.nextInt(30, 51)
            val enemy: Enemy
            var turn: Int = 0
            if (a == 1){
                enemy = Enemy("Grass-mon", hp, "Grass")
            }else if (a == 2){
                enemy = Enemy("Fire-mon", hp, "Fire")
            }else{
                enemy = Enemy("Water-mon", hp, "Water")
            }
            while (true) {
                if (turn % 2 == 0) {
                    println("---------Battle---------")
                    println(user.getUsername())
                    println("HP: ${user.getHp()}/50")
                    println("Mana: ${user.getMana()}/30")
                    println("Health Potions: ${user.getHealthPotion()}")
                    println("Mana Potions: ${user.getManaPotion()}")
                    println("----------------------------")
                    println(enemy.getName())
                    println("HP: ${enemy.getHp()}")
                    println("Type: ${enemy.getType()}")
                    println("----------")
                    println("1. Water Attack")
                    println("2. Grass Attack")
                    println("3. Fire Attack")
                    println("4. Drink Potion")
                    println("5. Run")
                    println("Choose:")
                    val choose = (readlnOrNull()?.toIntOrNull() ?: 5)
                    if (choose == 1 && user.getMana() > 0) {
                        if (enemy.getType() == "Fire") {
                            enemy.setHp(enemy.getHp() - 2 * user.getAtk())

                        } else {
                            enemy.setHp(enemy.getHp() - user.getAtk())
                        }
                        lifestealSuperPower()
                        user.setMana(user.getMana()-10)
                    } else if (choose == 2&& user.getMana() > 0) {
                        if (enemy.getType() == "Water") {
                            enemy.setHp(enemy.getHp() - 2 * user.getAtk())
                        } else {
                            enemy.setHp(enemy.getHp() - user.getAtk())
                        }
                        lifestealSuperPower()
                        user.setMana(user.getMana()-10)
                    } else if (choose == 3&& user.getMana() > 0) {
                        if (enemy.getType() == "Grass") {
                            enemy.setHp(enemy.getHp() - 2 * user.getAtk())
                        } else {
                            enemy.setHp(enemy.getHp() - user.getAtk())
                        }
                        lifestealSuperPower()
                        user.setMana(user.getMana()-10)
                    } else if (choose == 4) {
                        println("Choose Potion")
                        println("1. Health Potion")
                        println("2. Mana Potion")
                        println("3. Do nothing")
                        println("Choose:")
                        val choose = (readlnOrNull()?.toIntOrNull() ?: 3)
                        if (choose == 1) {
                            drinkHealth()
                        } else if (choose == 2) {
                            drinkMana()
                        }
                    } else if (choose == 5) {
                        println("You run away..\n\n")
                        break
                    }
                    turn++
                } else {
                    println("Enemy attack you!")
                    user.setHp(user.getHp() - 10)
                    turn++
                }
                if (user .getHp()<=0){
                    println("You lose")
                    user.setHp(0)
                    break
                }
                if (enemy.getHp() <= 0) {
                    println("You win")
                    user.setKill(user.getKill() + 1)
                    user.checkSuper()
                    break
                }
            }
        }else{
            println("HP is 0, you  can't join the battle again\n\n")
        }
}
    }
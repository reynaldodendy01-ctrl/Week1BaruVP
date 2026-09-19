package com.example.soal2

class User (
    private var username: String,
    private var hp: Int,
    private var mana: Int,
    private var kill: Int,
    private var manaPotion: Int,
    private var healthPotion: Int,
    private var isSuper: Boolean,
    private var atk: Int,
    private var count: Int,
    private var maxHp: Int,
    private var maxMana: Int
){
    fun getUsername(): String {
        return username
    }
    fun setUsername(value: String?) {
        if (value != null) {
            username = value
        }
    }
    fun getHp(): Int {
        return hp
    }
    fun setHp(value: Int) {
        hp = value
    }
    fun getHealthPotion(): Int {
        return healthPotion
    }
    fun setHealthPotion(value: Int) {
        healthPotion = value
    }
    fun getIsSuper(): Boolean {
        return isSuper
    }
    fun setKill(value: Boolean) {
        isSuper = value
    }
    fun getMana(): Int {
        return mana
    }
    fun setMana(value: Int) {
        mana = value
    }
    fun getKill(): Int {
        return kill
    }
    fun setKill(value: Int) {
        kill = value
    }
    fun getManaPotion(): Int {
        return manaPotion
    }
    fun setManaPotion(value: Int) {
        manaPotion = value
    }

    fun getMaxMana(): Int {
        return maxMana
    }
    fun getAtk(): Int {
        return atk
    }
    fun setAtk(value: Int){
        atk = value
    }
    fun getMaxHp(): Int {
        return maxHp
    }
    fun setMaxHp(value: Int) {
        maxHp = value
    }
    fun setMaxMana(input: Int) {
        maxMana = input
    }
    fun checkSuper(){
        if (kill >=5){
            if(count == 0){
                isSuper = true
                atk = 3*atk/2
                maxHp=maxHp*3/2
                maxMana=maxMana*3/2
                count++
            }
        }
    }
}
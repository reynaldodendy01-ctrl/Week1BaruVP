package com.example.soal2

class Enemy(
    private var name: String,
    private var HP: Int,
    private var type: String
)
{
    fun setHp(value: Int) {
        HP = value
    }
    fun getType(): String {
        return type
    }
    fun setType(value: String) {
        type = value
    }
    fun getName(): String {
        return name
    }
    fun setName(value: String) {
        name = value
    }
    fun getHp(): Int {
        return HP
    }
}
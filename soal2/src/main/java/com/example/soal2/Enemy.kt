package com.example.soal2

class Enemy(
    private var name: String,
    private var HP: Int,
    private var type: String
)
{
    fun setHp(value: Int) { HP = value }
    fun getType(): String = type
    fun setType(value: String) { type = value }
    fun getName(): String = name
    fun setName(value: String) { name = value }
    fun getHp(): Int = HP
}
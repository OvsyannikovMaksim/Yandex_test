package com.example.myapplication

interface Mapper <Src, Dst> {
    fun map(data: Src):Dst
}
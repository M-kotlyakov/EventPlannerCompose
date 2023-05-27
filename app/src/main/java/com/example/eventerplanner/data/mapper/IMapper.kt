package com.example.eventerplanner.data.mapper

interface IMapper<I, O> {

    fun map(input: I): O
}
package com.example.rxjavasample.chapter04

import io.reactivex.rxjava3.core.Flowable

fun main() {
    val flowable = Flowable.just(1, 3, 5, 7,)

    flowable.subscribe { data -> println("구독자1 : ${data}") }
    flowable.subscribe { data -> println("구독자2 : ${data}") }
}
package com.example.rxjavasample.chapter02

import io.reactivex.rxjava3.core.Observable

fun main() {
    val observable: Observable<Int> = Observable.just(1, 25, 9, 15, 7, 30)

    observable.subscribe { num -> println(num) }
}
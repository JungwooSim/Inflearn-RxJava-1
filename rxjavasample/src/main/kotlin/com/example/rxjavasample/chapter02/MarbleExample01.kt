package com.example.rxjavasample.chapter02

import io.reactivex.rxjava3.core.Observable

class MarbleExample01 {
}

fun main() {
    Observable.just(1, 25, 9, 15, 7, 30)
        .filter { x -> x > 10 }
        .subscribe { x ->  println(x) }
}
package com.example.rxjavasample.chapter04

import io.reactivex.rxjava3.processors.PublishProcessor

fun main() {
    val processor = PublishProcessor.create<Int>()

    processor.subscribe { data -> println("구독자1 : ${data}") }
    processor.onNext(1)
    processor.onNext(3)

    processor.subscribe { data -> println("구독자2 : ${data}") }
    processor.onNext(5)
    processor.onNext(7)

    processor.onComplete()
}
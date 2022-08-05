package com.example.rxjavasample.chapter01

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class ToDoSample {


}

fun main() {
    Observable.just(100, 200, 300, 400, 500)
        .doOnNext { data -> println(getThreadName() + " : " + "#doOnNext() : " + data) }
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())
        .filter { number -> number > 300 }
        .subscribe { num -> println(getThreadName() + " : result : " + num) }

    Thread.sleep(500)
}

fun getThreadName(): String {
    return Thread.currentThread().name
}
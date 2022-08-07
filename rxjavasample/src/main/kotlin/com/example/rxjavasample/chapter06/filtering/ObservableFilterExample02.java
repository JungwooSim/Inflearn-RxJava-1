package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.common.CarMaker;
import com.example.rxjavasample.common.SampleData;
import io.reactivex.rxjava3.core.Observable;

public class ObservableFilterExample02 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
            .filter(car -> car.getCarMaker() == CarMaker.CHEVROLET)
            .filter(car -> car.getCarPrice() > 30_000_000)
            .subscribe(
                car -> System.out.println(car.getCarName())
            );
    }

}

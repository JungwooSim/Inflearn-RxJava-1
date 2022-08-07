package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.common.CarMaker;
import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableFilterExample01 {

    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
            .filter(car -> car.getCarMaker() == CarMaker.CHEVROLET)
            .subscribe(
                car -> Logger.log(LogType.ON_NEXT, car.getCarMaker() + " : " + car.getCarName()));
    }
}

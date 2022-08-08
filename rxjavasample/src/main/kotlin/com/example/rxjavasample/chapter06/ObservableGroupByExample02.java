package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.common.Car;
import com.example.rxjavasample.common.CarMaker;
import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;

public class ObservableGroupByExample02 {

    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable = Observable.fromIterable(
            SampleData.carList).groupBy(car -> car.getCarMaker());

        observable.subscribe(
            groupedObservable -> groupedObservable
                .filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
                .subscribe(
                    car -> Logger.log(
                        LogType.ON_NEXT, "Group : " + groupedObservable.getKey() + "\t Car name : " + car.getCarName())
            )
        );
    }

}

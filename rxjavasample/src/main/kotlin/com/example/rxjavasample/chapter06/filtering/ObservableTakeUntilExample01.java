package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.common.Car;
import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

public class ObservableTakeUntilExample01 {

    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
            .takeUntil((Car car) -> car.getCarName().equals("트랙스"))
            .subscribe(car -> System.out.println(car.getCarName()));

        TimeUtil.sleep(300L);
    }

}

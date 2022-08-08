package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableToListExample02 {

    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
            .toList()
            .subscribe(carList -> Logger.log(LogType.ON_NEXT, carList));
    }

}

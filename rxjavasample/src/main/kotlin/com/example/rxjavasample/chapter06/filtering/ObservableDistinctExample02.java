package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.common.CarMaker;
import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableDistinctExample02 {

    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
            .distinct()
            .filter(carMaker -> carMaker == CarMaker.SSANGYOUNG)
            .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
    }

}

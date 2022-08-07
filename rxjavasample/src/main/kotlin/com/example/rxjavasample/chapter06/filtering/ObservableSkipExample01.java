package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableSkipExample01 {

    public static void main(String[] args) {
        Observable.range(1, 15)
            .skip(3)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}

package com.example.rxjavasample.chapter06.utility;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

public class ObservableDelayExample02 {

    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7)
            .delay(item -> {
                TimeUtil.sleep(1000L);
                return Observable.just(item);
            }).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}

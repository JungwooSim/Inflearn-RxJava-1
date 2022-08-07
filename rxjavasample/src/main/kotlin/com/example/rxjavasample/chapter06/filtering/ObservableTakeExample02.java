package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableTakeExample02 {

    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
            .take(3500L, TimeUnit.MILLISECONDS)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3500L);
    }

}

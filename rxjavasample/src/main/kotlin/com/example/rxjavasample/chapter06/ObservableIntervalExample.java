package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {

    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
            .map(num -> num + " count")
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(10000);
    }

}

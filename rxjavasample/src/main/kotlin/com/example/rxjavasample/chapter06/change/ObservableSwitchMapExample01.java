package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample01 {

    public static void main(String[] args) {
        TimeUtil.start();

        // 2, 3 이 돌지만 3만 출력됨
        Observable.interval(100L, TimeUnit.MILLISECONDS)
            .take(4)
            .skip(2)
            .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
            .switchMap(
                num -> Observable.interval(300L, TimeUnit.MILLISECONDS)
                    .take(10)
                    .skip(1)
                    .map(row -> num + " * " + row + " = " + num * row)
            )
            .subscribe(
                data -> Logger.log(LogType.ON_NEXT, data)
            );

        TimeUtil.sleep(5000);
    }

}

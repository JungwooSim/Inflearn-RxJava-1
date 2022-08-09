package com.example.rxjavasample.chapter06.utility;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.NumberUtil;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

public class ObservableTimeIntervalExample {

    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7)
            .delay(item -> {
                TimeUtil.sleep(NumberUtil.randomRange(100, 1000));
                return Observable.just(item);
            })
            .timeInterval()
            .subscribe(
                timed -> Logger.log(LogType.ON_NEXT, "# 통지하는데 걸린 시간 : " + timed.time() + "\t 통지된 데이터 : " + timed.value())
            );
    }

}

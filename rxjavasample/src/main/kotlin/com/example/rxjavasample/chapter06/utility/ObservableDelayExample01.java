package com.example.rxjavasample.chapter06.utility;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableDelayExample01 {

    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# 실행 시작 시간 : " + TimeUtil.getCurrentTimeFormatted());

        Observable.just(1, 3, 4, 6)
            .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
            .delay(2000L, TimeUnit.MILLISECONDS)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2500L);
    }

}

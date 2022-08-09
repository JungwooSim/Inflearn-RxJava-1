package com.example.rxjavasample.chapter06.error;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class GeneralOnErrorResumeNextExample {

    public static void main(String[] args) {
        Observable.just(5L)
            .flatMap(num -> Observable.interval(200L, TimeUnit.MICROSECONDS)
                .take(5)
                .map(i -> num / i)
                .onErrorResumeNext(throwable -> {
                    Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송 : " + throwable.getMessage());
                    return Observable.interval(200L, TimeUnit.MICROSECONDS)
                        .take(5)
                        .skip(1)
                        .map(i -> num / i);
                })
            ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }

}

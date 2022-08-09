package com.example.rxjavasample.chapter06.error;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class GeneralOnErrorHandleExample {

    public static void main(String[] args) {
        Observable.just(5)
            .flatMap(num -> Observable.interval(200L, TimeUnit.MICROSECONDS)
                .take(5)
                .map(i -> num / i)
                .onErrorReturn(exception -> {
                    if (exception instanceof ArithmeticException) {
                        Logger.log(LogType.PRINT, "계산 처리 에러 발생 : " + exception.getMessage());
                    }

                    return -1L;
                })
            ).subscribe(
                data -> {
                    if (data < 0) {
                        Logger.log(LogType.PRINT, "# 예외를 알리는 데이터: " + data);
                    } else {
                        Logger.log(LogType.ON_NEXT, data);
                    }
                },
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );

        TimeUtil.sleep(1000L);
    }

}

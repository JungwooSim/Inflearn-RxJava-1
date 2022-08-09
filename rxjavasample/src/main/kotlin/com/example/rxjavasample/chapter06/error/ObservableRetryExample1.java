package com.example.rxjavasample.chapter06.error;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableRetryExample1 {

    public static void main(String[] args) {
        Observable.just(5)
            .flatMap(
                num -> Observable.interval(200L, TimeUnit.MICROSECONDS)
                    .map(i -> {
                        long result;
                        try {
                            result = num / i;
                        } catch (ArithmeticException exception) {
                            Logger.log(LogType.PRINT, "error : " + exception.getMessage());
                            throw exception;
                        }

                        return result;
                    })
                    .retry(5)
                    .onErrorReturn(throwable -> -1L)
            ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );

        TimeUtil.sleep(5000L);
    }

}

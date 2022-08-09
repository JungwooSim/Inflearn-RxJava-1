package com.example.rxjavasample.chapter06.error;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableRetryExample2 {

    private final static int RETRY_MAX = 5;

    public static void main(String[] args) {
        Observable.just(5)
            .flatMap(
                num -> Observable.interval(200L, TimeUnit.MICROSECONDS)
                    .map(i -> {
                        long result;
                        try {
                            result = num / i;
                        } catch (ArithmeticException ex) {
                            Logger.log(LogType.PRINT, "error : " + ex.getMessage());
                            throw ex;
                        }

                        return result;
                    })
                    .retry((retryCount, ex) -> {
                        Logger.log(LogType.PRINT, "# 재시도 횟수 : " + retryCount);
                        TimeUtil.sleep(1000L);
                        return retryCount < RETRY_MAX ? true : false;
                    })
                    .onErrorReturn(throwable -> -1L)
            ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );

        TimeUtil.sleep(6000L);
    }
}

package com.example.rxjavasample.chapter06.error;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

public class ObservableRetryExample3 {

    public static void main(String[] args) {
        Observable.just(10, 12, 15, 16)
            .zipWith(Observable.just(1, 2, 0, 4), (a, b) -> {
                int result;

                try {
                    result = a / b;
                } catch (ArithmeticException exception) {
                    Logger.log(LogType.PRINT, "error : " + exception.getMessage());
                    throw exception;
                }

                return result;
            })
            .retry(3)
            .onErrorReturn(throwable -> -1)
            .subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );


        TimeUtil.sleep(6000L);
    }
}

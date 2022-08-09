package com.example.rxjavasample.chapter06.utility;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableMaterialExample01 {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
            .materialize()
            .subscribe(
                notification -> {
                    String notificationType = notification.isOnNext() ? "onNext()" : (notification.isOnError()) ? "onError()" : "onComplete";
                    Logger.log(LogType.PRINT, "notification 타입 : " + notificationType);
                    Logger.log(LogType.ON_NEXT, notification.getValue());
                }
            );
    }

}

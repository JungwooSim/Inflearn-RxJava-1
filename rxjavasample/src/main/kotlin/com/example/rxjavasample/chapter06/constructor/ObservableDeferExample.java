package com.example.rxjavasample.chapter06.constructor;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import java.time.LocalTime;

public class ObservableDeferExample {

    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observable = Observable.defer(() -> {
            LocalTime currentTime = LocalTime.now();
            return Observable.just(currentTime);
        });

        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독1의 구독 시간 : " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독1의 구독 시간 : " + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독2의 구독 시간 : " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독2의 구독 시간 : " + time));
    }
}

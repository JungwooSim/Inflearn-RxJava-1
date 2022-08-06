package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {

    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# Start!");

        Observable<String> observable = Observable.timer(2000, TimeUnit.MILLISECONDS)
            .map(count -> "Do work!");

        observable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);

    }

}

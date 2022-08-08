package com.example.rxjavasample.chapter06.merge;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample01 {

    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MICROSECONDS)
//            .doOnNext(data -> Logger.log("# observable 1 : " + data))
            .take(4);

        Observable<Long> observable2 = Observable.interval(700L, TimeUnit.MICROSECONDS)
//            .doOnNext(data -> Logger.log("# observable 2 : " + data))
            .take(4);

//        TimeUtil.sleep(4000L);

        Observable.combineLatest(
                observable1,
                observable2,
                (data1, data2) -> "data1:" + data1 + "\t data2:" + data2)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000L);
    }

}

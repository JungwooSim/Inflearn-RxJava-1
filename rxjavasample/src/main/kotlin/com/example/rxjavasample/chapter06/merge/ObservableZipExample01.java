package com.example.rxjavasample.chapter06.merge;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableZipExample01 {

    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MICROSECONDS)
            .take(4);

        Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MICROSECONDS)
            .take(6);

        Observable.zip(observable1, observable2, (data1, data2) -> data1 + data2)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000L);
    }

}

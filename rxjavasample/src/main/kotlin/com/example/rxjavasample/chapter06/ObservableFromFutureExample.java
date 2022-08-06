package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ObservableFromFutureExample {

    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# start time");

        //긴 처리 시간이 걸리는 작업
        Future<Double> future = longTimeWork();

        //짧은 처리 시간이 걸리는 작업
        shortTimeWork();

        Observable.fromFuture(future)
            .subscribe(data -> Logger.log(LogType.PRINT, "# 긴 처리 시간 작업 결과 : " + data));

        Logger.log(LogType.PRINT, "# end time");
    }

    private static CompletableFuture<Double> longTimeWork() {
        return CompletableFuture.supplyAsync(() -> calculate());
    }

    private static Double calculate() {
        Logger.log(LogType.PRINT, "# 긴 처리 시간이 걸리는 작업 중...");
        TimeUtil.sleep(6000L);
        return 10000000.0;
    }

    private static void shortTimeWork() {
        TimeUtil.sleep(3000L);
        Logger.log(LogType.PRINT, "# 짧은 처리 시간 작업 완료!");
    }
}

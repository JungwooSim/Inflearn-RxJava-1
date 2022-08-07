package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.common.Searcher;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample02 {

    public static void main(String[] args) {
        TimeUtil.start();

        Searcher searcher = new Searcher();

        // 사용자가 입력하는 검색어라고 가정한다.
        final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
            .take(4)
            .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
            .switchMap(data -> {
                String keyword = keywords.get(data.intValue()); // 데이터베이스에서 조회한다고 가정한다.

                return Observable.just(searcher.search(keyword))
                    .doOnNext(notUse -> System.out.println("================================================================="))
                    .delay(1000L, TimeUnit.MILLISECONDS);
            })
            .flatMap(resultList -> Observable.fromIterable(resultList))
            .subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> {},
                () -> {
                    TimeUtil.end();
                    TimeUtil.takeTime();
                }
            );


        TimeUtil.sleep(6000L);
    }

}

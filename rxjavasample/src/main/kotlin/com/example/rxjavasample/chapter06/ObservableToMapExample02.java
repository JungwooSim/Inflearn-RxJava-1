package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;

public class ObservableToMapExample02 {

    public static void main(String[] args) {
        Single<Map<String, String>> single = Observable.just("a-Alpha", "b-Bravo",
                "c-Charlie", "e-Echo")
            .toMap(
                data -> data.split("-")[0], // key
                data -> data.split("-")[1] // value
            );

        single.subscribe(map -> Logger.log(LogType.ON_NEXT, map));
    }
}

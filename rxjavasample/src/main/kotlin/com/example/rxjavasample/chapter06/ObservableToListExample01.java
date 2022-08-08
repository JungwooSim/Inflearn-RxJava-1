package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

public class ObservableToListExample01 {

    public static void main(String[] args) {
        Single<List<Integer>> single = Observable.just(1, 3, 5, 7, 9).toList();

        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}

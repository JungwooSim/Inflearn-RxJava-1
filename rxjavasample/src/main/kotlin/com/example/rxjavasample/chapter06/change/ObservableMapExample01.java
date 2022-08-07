package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class ObservableMapExample01 {

    public static void main(String[] args) {
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7);
        Observable.fromIterable(oddList)
            .map(num -> "1을 더한 결과 : " + (num + 1))
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}

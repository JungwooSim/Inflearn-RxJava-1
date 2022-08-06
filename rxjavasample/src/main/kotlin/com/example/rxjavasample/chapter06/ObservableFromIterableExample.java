package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Korea", "Canada", "USA", "Italy");

        Observable.fromIterable(countries)
            .subscribe(country -> Logger.log(LogType.ON_NEXT, country));
    }

}

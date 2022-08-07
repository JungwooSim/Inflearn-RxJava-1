package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableMapExample02 {

    public static void main(String[] args) {
        Observable.just("korea", "america", "canada", "paris", "japan", "china")
            .filter(country -> country.length() == 5)
            .map(country -> country.toUpperCase().charAt(0) + country.substring(1))
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}

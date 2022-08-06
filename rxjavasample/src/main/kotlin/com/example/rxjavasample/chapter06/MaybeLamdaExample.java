package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.DateUtil;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Maybe;

public class MaybeLamdaExample {

    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(emitter -> {
//            emitter.onSuccess(DateUtil.getNowDate());
            emitter.onComplete();
        });

        maybe.subscribe(
            data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시간 : " + data),
            error -> Logger.log(LogType.ON_ERROR, error),
            () -> Logger.log(LogType.ON_COMPLETE)
        );
    }
}

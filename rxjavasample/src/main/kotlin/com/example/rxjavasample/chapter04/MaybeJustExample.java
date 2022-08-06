package com.example.rxjavasample.chapter04;

import com.example.rxjavasample.utlis.DateUtil;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Maybe;

public class MaybeJustExample {

    public static void main(String[] args) {
        Maybe.just(DateUtil.getNowDate())
            .subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시간 : " + data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );

        Maybe.empty()
            .subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시간 : " + data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
            );
    }

}

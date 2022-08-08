package com.example.rxjavasample.chapter06.merge;

import com.example.rxjavasample.common.SampleData;
import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class ObservableConcatExample02 {

    public static void main(String[] args) {
        List<Observable<String>> speedPerSectionList = Arrays.asList(
            SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA),
            SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB),
            SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC)
        );

        Observable.concat(speedPerSectionList)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }

}

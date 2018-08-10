package web;

import java.util.List;

public class MeasurementWithData extends Measure {

    private List<Data> dataList;

    public MeasurementWithData(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}

package com.example.lg.congestion;

/**
 * Created by LG on 2017-06-17.
 */

public class Co2 {
    private String timeStamp;
    private int co2Value;
    private int metroNum;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCo2Value() {
        return co2Value;
    }

    public void setCo2Value(int co2Value) {
        this.co2Value = co2Value;
    }

    public int getMetroNum() {
        return metroNum;
    }

    public void setMetroNum(int metroNum) {
        this.metroNum = metroNum;
    }

    public String toString() {
        return "Co2 [timeStamp=" + timeStamp + ", co2Value=" + co2Value + ", metroNum=" + metroNum + "]";
    }


}

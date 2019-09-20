/**
 * Created by rikmen00@gmail.com on 21.03.2019.
 */
package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PointNear {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("near_point")
    @Expose
    private List<Point> nearPoint = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Point> getNearPoint() {
        return nearPoint;
    }

    public void setNearPoint(List<Point> nearPoint) {
        this.nearPoint = nearPoint;
    }

}
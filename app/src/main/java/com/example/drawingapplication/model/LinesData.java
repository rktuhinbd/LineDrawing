package com.example.drawingapplication.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinesData {

    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("is_eraser")
    @Expose
    private Boolean isEraser;
    @SerializedName("plots")
    @Expose
    private List<Plot> plots = null;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("slide_order_idx")
    @Expose
    private Integer slideOrderIdx;
    @SerializedName("slide_id")
    @Expose
    private Integer slideId;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getIsEraser() {
        return isEraser;
    }

    public void setIsEraser(Boolean isEraser) {
        this.isEraser = isEraser;
    }

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSlideOrderIdx() {
        return slideOrderIdx;
    }

    public void setSlideOrderIdx(Integer slideOrderIdx) {
        this.slideOrderIdx = slideOrderIdx;
    }

    public Integer getSlideId() {
        return slideId;
    }

    public void setSlideId(Integer slideId) {
        this.slideId = slideId;
    }

}

package com.allerates.appforyou.request;

/**
 * Created by rikmen00@gmail.com on 19.02.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ListComment {

    @SerializedName("all_point_comment")
    @Expose
    private List<AllPointComment> allPointComment = null;
    @SerializedName("autor_point_comment")
    @Expose
    private String autorPointComment;
    @SerializedName("count_comment")
    @Expose
    private Integer countComment;

    public List<AllPointComment> getAllPointComment() {
        return allPointComment;
    }

    public void setAllPointComment(List<AllPointComment> allPointComment) {
        this.allPointComment = allPointComment;
    }

    public String getAutorPointComment() {
        return autorPointComment;
    }

    public void setAutorPointComment(String autorPointComment) {
        this.autorPointComment = autorPointComment;
    }

    public Integer getCountComment() {
        return countComment;
    }

    public void setCountComment(Integer countComment) {
        this.countComment = countComment;
    }

}
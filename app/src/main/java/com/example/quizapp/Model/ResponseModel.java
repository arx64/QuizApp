package com.example.quizapp.Model;

import java.util.List;

public class ResponseModel {
    private int success;
    private List<DataModel> data;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }
}

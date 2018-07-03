package com.example.mypc.firstskool;

public class My_Plan_Item {

    private String type;
    private String fees;
    private String title;
    private String overview;
    private int status;

    public My_Plan_Item(String type, String fees, String title, String overview, int status) {
        this.type = type;
        this.fees = fees;
        this.title = title;
        this.overview = overview;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

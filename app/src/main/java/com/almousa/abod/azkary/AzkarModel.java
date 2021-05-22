package com.almousa.abod.azkary;

public class AzkarModel {

    private int id;
    private String category;
    private String text;
    private String desc;
    private int limit;

    public AzkarModel() {
    }

    public AzkarModel(int id, String category, String text, String desc, int limit) {
        this.id = id;
        this.category = category;
        this.text = text;
        this.desc = desc;
        this.limit = limit;
    }

    public AzkarModel(String category, String text, String desc, int limit) {
        this.category = category;
        this.text = text;
        this.desc = desc;
        this.limit = limit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

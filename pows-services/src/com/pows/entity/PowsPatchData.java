package com.pows.entity;


public class PowsPatchData {
    private String task;
    private String path;
    private Object value;

    public PowsPatchData(String task, String path, Object value) {
        this.task = task;
        this.path = path;
        this.value = value;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

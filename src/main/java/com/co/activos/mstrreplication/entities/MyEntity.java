package com.co.activos.mstrreplication.entities;



public class MyEntity {

    private String id;
    private String level;
    private Integer value;

    public MyEntity() {
    }
    public MyEntity(String id, String level, Integer value) {
        this.id = id;
        this.level = level;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

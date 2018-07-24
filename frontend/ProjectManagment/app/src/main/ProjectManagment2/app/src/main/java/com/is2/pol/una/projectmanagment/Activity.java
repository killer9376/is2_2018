package com.is2.pol.una.projectmanagment;

public class Activity {
    public Integer id;
    public String name;
    public Integer id_proyect;
    public String order;
    public String status;

    public Activity() {
    }

    public Activity(Integer id, String name, Integer id_proyect, String order, String status) {
        this.id = id;
        this.name = name;
        this.id_proyect = id_proyect;
        this.order = order;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_proyect() {
        return id_proyect;
    }

    public void setId_proyect(Integer id_proyect) {
        this.id_proyect = id_proyect;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

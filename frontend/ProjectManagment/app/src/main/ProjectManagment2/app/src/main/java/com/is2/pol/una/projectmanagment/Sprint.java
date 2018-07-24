package com.is2.pol.una.projectmanagment;

public class Sprint {
    public Integer id;
    public Integer id_activity;
    public String name;
    public String description;
    public String duration;
    public String date_start;
    public String date_finish;

    public Sprint() {
    }

    public Sprint(Integer id, Integer id_activity, String name, String description, String duration, String date_start, String date_finish) {
        this.id = id;
        this.id_activity = id_activity;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.date_start = date_start;
        this.date_finish = date_finish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_activity() {
        return id_activity;
    }

    public void setId_activity(Integer id_activity) {
        this.id_activity = id_activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(String date_finish) {
        this.date_finish = date_finish;
    }
}
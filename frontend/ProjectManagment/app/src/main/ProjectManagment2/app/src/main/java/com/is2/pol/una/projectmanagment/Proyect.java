package com.is2.pol.una.projectmanagment;

public class Proyect {
    public Integer proyect_id;
    public String proyect_name;
    public String proyect_year;
    public String proyect_date_start;
    public String proyect_date_finish;
    public Integer proyect_leader;
    public String proyect_status;

    public Proyect() {
    }

    public Proyect(Integer proyect_id, String proyect_name, String proyect_year, String proyect_date_start, String proyect_date_finish, Integer proyect_leader, String proyect_status) {
        this.proyect_id = proyect_id;
        this.proyect_name = proyect_name;
        this.proyect_year = proyect_year;
        this.proyect_date_start = proyect_date_start;
        this.proyect_date_finish = proyect_date_finish;
        this.proyect_leader = proyect_leader;
        this.proyect_status = proyect_status;
    }

    public Integer getProyect_id() {
        return proyect_id;
    }

    public void setProyect_id(Integer proyect_id) {
        this.proyect_id = proyect_id;
    }

    public String getProyect_name() {
        return proyect_name;
    }

    public void setProyect_name(String proyect_name) {
        this.proyect_name = proyect_name;
    }

    public String getProyect_year() {
        return proyect_year;
    }

    public void setProyect_year(String proyect_year) {
        this.proyect_year = proyect_year;
    }

    public String getProyect_date_start() {
        return proyect_date_start;
    }

    public void setProyect_date_start(String proyect_date_start) {
        this.proyect_date_start = proyect_date_start;
    }

    public String getProyect_date_finish() {
        return proyect_date_finish;
    }

    public void setProyect_date_finish(String proyect_date_finish) {
        this.proyect_date_finish = proyect_date_finish;
    }

    public Integer getProyect_leader() {
        return proyect_leader;
    }

    public void setProyect_leader(Integer proyect_leader) {
        this.proyect_leader = proyect_leader;
    }

    public String getProyect_status() {
        return proyect_status;
    }

    public void setProyect_status(String proyect_status) {
        this.proyect_status = proyect_status;
    }
}

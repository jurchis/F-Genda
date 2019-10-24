package com.milnesium.domain;

public class GendaElement {
    private long id;
    private String first_name;
    private String last_name;
    private String phone_no;
    private String comment;
    private boolean work_no;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isWork_no() {
        return work_no;
    }

    public void setWork_no(boolean work_no) {
        this.work_no = work_no;
    }

    @Override
    public String toString() {
        return "GendaElement{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + last_name + '\'' +
                ", comment='" + comment + '\'' +
                ", work_no=" + work_no +
                '}';
    }
}

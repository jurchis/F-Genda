package com.milnesium.transfer;

public class CreateGendaElementRequest {
    private String first_name;
    private String second_name;
    private String phone_no;
    private String comment;
    private boolean work;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
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

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "CreateGendaElementRequest{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

package com.milnesium.transfer;

public class CreateGendaElementRequest {
    private String firstName;
    private String secondName;
    private String phoneNo;
    private String comment;
    private boolean workNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isWorkNo() {
        return workNo;
    }

    public void setWorkNo(boolean workNo) {
        this.workNo = workNo;
    }

    @Override
    public String toString() {
        return "CreateGendaElementRequest{" +
                "first_name='" + firstName + '\'' +
                ", second_name='" + secondName + '\'' +
                ", phone_no='" + phoneNo + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

package com.milnesium.domain;

public class GendaElement {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String comment;
    private boolean workNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "GendaElement{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", second_name='" + lastName + '\'' +
                ", comment='" + comment + '\'' +
                ", work_no=" + workNo +
                '}';
    }
}

package com.milnesium.transfer;

public class GetGendaElementRequest {
    private boolean workNo;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String comment;
    private Long id;

    public boolean isWorkNo() {
        return workNo;
    }

    public void setWorkNo(boolean workNo) {
        this.workNo = workNo;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetGendaElementRequest{" +
                "workNo=" + workNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }
}

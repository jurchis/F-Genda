package com.milnesium.transfer;

public class UpdateGendaElementRequest {
    private boolean work;

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "UpdateGendaElementRequest{" +
                "work=" + work +
                '}';
    }
}

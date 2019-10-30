package com.milnesium.transfer;

public class UpdateGendaElementRequest {
    private boolean workNo;

    public boolean isWorkNo() {
        return workNo;
    }

    public void setWorkNo(boolean workNo) {
        this.workNo = workNo;
    }

    @Override
    public String toString() {
        return "UpdateGendaElementRequest{" +
                "work=" + workNo +
                '}';
    }
}

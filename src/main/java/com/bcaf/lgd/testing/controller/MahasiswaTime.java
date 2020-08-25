package com.bcaf.lgd.testing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MahasiswaTime extends Mahasiswa{
private String createdDateTime;
private String updatedDateTime;

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY, HH:mm");
        this.createdDateTime = dateFormat.format(createdDateTime);
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY, HH:mm");
        if (updatedDateTime!=null){
            this.updatedDateTime = dateFormat.format(createdDateTime);
        }
        else
        this.updatedDateTime = "";
    }
}

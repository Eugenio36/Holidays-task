package com.holidays.holidaystask.response;

import java.time.LocalDate;

public class HolidayResponse {

    private String name;

    public HolidayResponse(String name) {
        this.name = name;
    }

    public HolidayResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


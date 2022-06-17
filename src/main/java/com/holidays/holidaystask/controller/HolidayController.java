package com.holidays.holidaystask.controller;


import com.holidays.holidaystask.response.HolidayResponse;
import com.holidays.holidaystask.service.HolidayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/myperfectapp/{countryCode}/{year}")
    public List<HolidayResponse> getData(@PathVariable int year, @PathVariable String countryCode) {
        return holidayService.getData(year, countryCode);
    }

    @GetMapping("/myperfectapp/{countryCode1}/{countryCode2}/{year}")
    public List<HolidayResponse> getCommonHolidays(
            @PathVariable int year,
            @PathVariable String countryCode1,
            @PathVariable String countryCode2) {
        return holidayService.getCommonHolidays(year, countryCode1, countryCode2);
    }

}

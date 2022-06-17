package com.holidays.holidaystask.service;

import com.holidays.holidaystask.response.HolidayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class HolidayService {
    Logger logger = LoggerFactory.getLogger(HolidayService.class);
    private final HolidayRestService holidayRestService;

    public HolidayService(HolidayRestService holidayRestService) {
        this.holidayRestService = holidayRestService;
    }

    public List<HolidayResponse> getData(int year, String countryCode) {
        return holidayRestService.getData(year, countryCode);
    }

    public List<HolidayResponse> getCommonHolidays(int year, String countryCode1, String countryCode2) {
        validateRequest(String.valueOf(year), countryCode1, countryCode2);
        return holidayRestService.getCommonHolidays(year, countryCode1, countryCode2);
    }

    private void validateRequest(String year, String countryCode1, String countryCode2) {
        if (!year.matches("\\d{4}")) {
            logger.error("Wrong year format was received: " + year);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong year format!");
        }

        if (!countryCode1.matches("[a-zA-Z]{2}")) {
            logger.error("Wrong countryCode format was received: " + countryCode1);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong countryCode format!");
        }

        if (!countryCode2.matches("[a-zA-Z]{2}")) {
            logger.error("Wrong countryCode format was received: " + countryCode2);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong countryCode format!");
        }
    }
}

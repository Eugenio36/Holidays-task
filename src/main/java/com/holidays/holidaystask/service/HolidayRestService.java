package com.holidays.holidaystask.service;

import com.holidays.holidaystask.response.HolidayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class HolidayRestService {

    private final RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(HolidayRestService.class);

    public HolidayRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<HolidayResponse> getData(int year, String countryCode) {
        String url = "https://date.nager.at/api/v3/PublicHolidays/" + year + "/" + countryCode;
        HolidayResponse[] holidays = new HolidayResponse[0];
        try {
            ResponseEntity<HolidayResponse[]> response = restTemplate.getForEntity(url, HolidayResponse[].class);
            if (response.getBody() != null) {
                holidays = response.getBody();
            }
        } catch (Exception e) {
            logger.error("Could not retrieve countries", e);
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return Arrays.asList(holidays);
    }

    public List<HolidayResponse> getCommonHolidays(int year, String countryCode1, String countryCode2) {

        List<HolidayResponse> list1 = getData(year, countryCode1);
        List<HolidayResponse> list2 = getData(year, countryCode2);

        List<String> list2Names = new ArrayList<>();
        for (HolidayResponse response : list2) {
            list2Names.add(response.getName());
        }

        List<HolidayResponse> result = new ArrayList<>();
        for (HolidayResponse response : list1) {
            if (list2Names.contains(response.getName())) {
                result.add(response);
            }
        }
        return result;
    }
}

//        for (int i = 0; i < list2.size(); i++) {
//            list2Names.add(list2.get(i).getName());
//        }

//        for (int i = 0; i < list1.size(); i++) {
//            if (list2Names.contains(list1.get(i).getName())) {
//                result.add(list1.get(i));
//            }
//        }
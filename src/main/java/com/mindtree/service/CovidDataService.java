package com.mindtree.service;

import com.mindtree.utility.InterfaceDto;

import java.util.List;
import java.util.Set;

public interface CovidDataService {

    Set<String> getAllStateCode();
    Set<String> getAllDistrictOfState(String state);
    List<InterfaceDto> getDataOfStateInDateRange(String startDate, String endDate);
    List<InterfaceDto> getDataParticularStateInDateRange(String state, String startDate, String endDate);
}

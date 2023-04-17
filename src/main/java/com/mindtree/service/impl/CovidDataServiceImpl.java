package com.mindtree.service.impl;

import com.mindtree.entity.Player;
import com.mindtree.exception.InValidDateRangeException;
import com.mindtree.exception.InvalidDateException;
import com.mindtree.exception.InvalidStateCodeException;
import com.mindtree.exception.NoDataFoundException;
import com.mindtree.repository.CovidDataRepository;
import com.mindtree.service.CovidDataService;
import com.mindtree.utility.InterfaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    @Autowired
    private CovidDataRepository covidRepository;

    @Override
    public Set<String> getAllStateCode() {

        List<Player> playerList = this.covidRepository.findAll(Sort.by("state").ascending());

        Map<String, Long> stateMapList =  playerList.stream().collect(Collectors.groupingBy(Player::getState, Collectors.counting()));

        return stateMapList.keySet();
    }

    @Override
    public Set<String> getAllDistrictOfState(String state) {



        List<Player>   playerList =  this.covidRepository.findByState(state, Sort.by("district"));

        if (playerList.isEmpty()) {
            throw new InvalidStateCodeException("Invalid State Code, Plese Check Your Input");
        }

        Map<String, Long> districtMapList =  playerList.stream().collect(Collectors.groupingBy(Player::getDistrict, Collectors.counting()));

        return districtMapList.keySet();
    }

    @Override
    public List<InterfaceDto> getDataOfStateInDateRange(String startDate, String endDate) {

        LocalDate startDateLocal = null;
        LocalDate endDateLocal = null;

        try {
             startDateLocal = LocalDate.parse(startDate);
        }
        catch ( Exception  ex) {
            throw new InvalidDateException("Invalid Start Date Please Check Your Input");
        }

        try {
             endDateLocal = LocalDate.parse(endDate);
        }
        catch (Exception ex) {
            throw new InvalidDateException("Invalid End Date Please Check Your Input");
        }

        if (startDateLocal.isAfter(endDateLocal)) {
            throw new InValidDateRangeException("Invalid Date Range Please Check Your Input");
        }

        List<InterfaceDto> interfaceDtoList = this.covidRepository.findDataOfStateInDateRange(startDateLocal, endDateLocal);

        if (interfaceDtoList.isEmpty()) {
            throw new NoDataFoundException("No Data Present");
        }

        return interfaceDtoList;
    }

    @Override
    public List<InterfaceDto> getDataParticularStateInDateRange(String state, String startDate, String endDate) {

        LocalDate startDateLocal = null;
        LocalDate endDateLocal = null;

        try {
            startDateLocal = LocalDate.parse(startDate);
        }
        catch ( Exception  ex) {
            throw new InvalidDateException("Invalid Start Date Please Check Your Input");
        }

        try {
            endDateLocal = LocalDate.parse(endDate);
        }
        catch (Exception ex) {
            throw new InvalidDateException("Invalid End Date Please Check Your Input");
        }

        if (startDateLocal.isAfter(endDateLocal)) {
            throw new InValidDateRangeException("Invalid Date Range Please Check Your Input");
        }

        List<InterfaceDto> interfaceDtoList = this.covidRepository.findDataOfParticularStateInDateRange(state, startDateLocal, endDateLocal);

        if (interfaceDtoList.isEmpty()) {
            throw new NoDataFoundException("No Data Present");
        }

        return interfaceDtoList;
    }
}

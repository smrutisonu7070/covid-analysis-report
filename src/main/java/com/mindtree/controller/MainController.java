package com.mindtree.controller;



import com.mindtree.service.CovidDataService;
import com.mindtree.utility.InterfaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class MainController {

   private Scanner sc = new Scanner(System.in);

   @Autowired
   private CovidDataService covidDataService;

    public void Introduction() {

        System.out.println("****************************************************");

        while (true) {
            System.out.println("1. Get States Names");
            System.out.println("2. Get District Name For Given State");
            System.out.println("3. Display Data By State With in Date Range");
            System.out.println("4. Display Confirmed Case By Displaying Two States For a Given Date Range");
            System.out.println("5. Exit");

            System.out.println("Please Select Any One Option: ");
            int option = sc.nextInt();

            if(option == 1) {
                System.out.println("All States Names Are: ");

                Set<String> allStateSet = this.covidDataService.getAllStateCode();

                allStateSet.stream().forEach(stateCode -> {
                    System.out.println(stateCode);
                });
            }
            else if (option == 2) {
                System.out.println("Please Give Any State Code: ");
                String stateCode = sc.next();

                System.out.println("All Districts Of Given State Are: ");

                Set<String> allDistrictSet = this.covidDataService.getAllDistrictOfState(stateCode);

                allDistrictSet.stream().forEach(district ->{
                    System.out.println(district);
                });
            }
            else if (option == 3) {

                System.out.println("Please Enter Start Date(YYYY-MM-DD): ");
                String startDate = sc.next();
                System.out.println("Please Enter End Date(YYYY-MM-DD): ");
                String endDate = sc.next();

                List<InterfaceDto> interfaceDtoList = this.covidDataService.getDataOfStateInDateRange(startDate, endDate);

                System.out.println("Date | State | Total_Tested | Total_Confirmed | Total_Recovered");

                interfaceDtoList.stream().forEach(interfaceDto -> {
                    System.out.println(interfaceDto.getDate() + " | " + interfaceDto.getState() + " | " +
                            interfaceDto.getTestedTotal() + " | " + interfaceDto.getConfirmedTotal() + " | "
                            + interfaceDto.getRecoveredTotal());
                });
            }
            else if (option == 4) {

                System.out.println("Please Enter Start Date(YYYY-MM-DD): ");
                String startDate = sc.next();
                System.out.println("Please Enter End Date(YYYY-MM-DD): ");
                String endDate = sc.next();
                System.out.println("Please Enter First State: ");
                String state1 = sc.next();
                System.out.println("Please Enter Second State: ");
                String state2 = sc.next();

                List<InterfaceDto> interfaceDtoListForState1 = this.covidDataService.getDataParticularStateInDateRange(state1, startDate, endDate);
                List<InterfaceDto> interfaceDtoListForState2 = this.covidDataService.getDataParticularStateInDateRange(state1, startDate, endDate);

                System.out.println("Date | State | Total_Confirmed");

                interfaceDtoListForState1.stream().forEach(interfaceDto -> {
                    System.out.println(interfaceDto.getDate() + " | " + state1 + " | " + interfaceDto.getConfirmedTotal());
                });

                interfaceDtoListForState2.stream().forEach(interfaceDto -> {
                    System.out.println(interfaceDto.getDate() + " | " + state2 + " | " + interfaceDto.getConfirmedTotal());
                });

            }
            else if (option == 5) {
              break;
            }
            else {
                System.out.println("Please give Valid Option: ");
            }
        }

    }

}

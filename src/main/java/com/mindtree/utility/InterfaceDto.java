package com.mindtree.utility;

import java.time.LocalDate;

public interface InterfaceDto {

    LocalDate getDate();
    String getState();

    Integer getTestedTotal();

    Integer getConfirmedTotal();
    Integer getRecoveredTotal();
}

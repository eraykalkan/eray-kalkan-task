package com.protel.eraykalkantask.service;

import com.protel.eraykalkantask.dto.BerlinClockDTO;
import org.springframework.stereotype.Service;

@Service
public interface BerlinClockService {
    BerlinClockDTO convertToBerlinClock(String time);
}

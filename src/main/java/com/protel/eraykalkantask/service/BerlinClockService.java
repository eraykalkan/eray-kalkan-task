package com.protel.eraykalkantask.service;

import com.protel.eraykalkantask.dto.BerlinClockDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BerlinClockService {
    BerlinClockDTO convertToBerlinClock(Optional<String> time);
}

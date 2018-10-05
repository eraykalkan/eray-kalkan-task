package com.protel.eraykalkantask.controller;

import com.protel.eraykalkantask.dto.BerlinClockDTO;
import com.protel.eraykalkantask.service.BerlinClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BerlinClockController {

    private final BerlinClockService berlinClockService;

    @Autowired
    public BerlinClockController(BerlinClockService berlinClockService) {
        this.berlinClockService=berlinClockService;
    }

    @RequestMapping(path="/berlinClock" , method = RequestMethod.GET)
    public ResponseEntity<BerlinClockDTO> getBerlinClock(@RequestParam("time") String time) {
        return new ResponseEntity<>(berlinClockService.convertToBerlinClock(time),HttpStatus.OK);
    }

}

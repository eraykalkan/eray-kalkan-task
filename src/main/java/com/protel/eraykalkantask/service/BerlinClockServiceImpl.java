package com.protel.eraykalkantask.service;

import com.protel.eraykalkantask.core.Hours;
import com.protel.eraykalkantask.core.Minutes;
import com.protel.eraykalkantask.core.Seconds;
import com.protel.eraykalkantask.core.Time;
import com.protel.eraykalkantask.dto.BerlinClockDTO;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BerlinClockServiceImpl implements BerlinClockService {

    private static List<Time> timeList=new ArrayList<>();

    public BerlinClockServiceImpl() {
        timeList.add(new Seconds());
        timeList.add(new Minutes());
        timeList.add(new Hours());
    }

    @Override
    public BerlinClockDTO convertToBerlinClock(Optional<String> standartTime) {
        String timeToConvert="";
        if(standartTime.isPresent()) {
            timeToConvert = standartTime.get();
        }else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.now();
            String f = formatter.format(time);
            timeToConvert = f;
        }

            StringBuilder timeS = new StringBuilder();

            String[] splitTime = timeToConvert.split(":");

            int i = 0;
            int j = 2;

            for (Time time : timeList) {
                for (String timeElemnt : splitTime) {
                     timeS.append(timeList.get(i).getLight(Integer.parseInt(splitTime[j])));
                    i++;
                    j--;
                    break;
                }
            }
            BerlinClockDTO berlinClockDTO=new BerlinClockDTO();
            berlinClockDTO.setClock(timeS.toString());
            return berlinClockDTO;
    }
}

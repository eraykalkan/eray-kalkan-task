package com.protel.eraykalkantask.core;

import com.protel.eraykalkantask.constants.Color;

public class Seconds implements Time {
    @Override
    public String getLight(int i) {
        if(i%2==0)
            return Color.YELLOW.code;
        else
            return Color.OFF.code;
    }
}

package com.protel.eraykalkantask.core;

import com.protel.eraykalkantask.constants.Color;

public class Hours implements Time {

    private static final int MULTIPLE_OF_FIVE = 5;
    public String getLampForHoursMultipleOfFive(int h) {
        StringBuffer lights = new StringBuffer(Color.ALL_OFF.code);
        for (int i = 0; i < (h / MULTIPLE_OF_FIVE); i++) {
            lights.replace(i, i + 1, Color.RED.code);
        }
        return lights.toString();
    }

    public String getLampForSingleHours(int h) {
        StringBuffer light = new StringBuffer(Color.ALL_OFF.code);
        for (int i = 0; i < (h % MULTIPLE_OF_FIVE); i++) {
            light.replace(i, i + 1, Color.RED.code);
        }
        return light.toString();
    }

    @Override
    public String getLight(int h) {

        return getLampForHoursMultipleOfFive(h) + getLampForSingleHours(h);
    }
}

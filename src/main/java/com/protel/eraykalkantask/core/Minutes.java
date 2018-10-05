package com.protel.eraykalkantask.core;

import com.protel.eraykalkantask.constants.Color;

public class Minutes implements Time {

    @Override
    public String getLight(int m) {
        int minuteDivided = m / 5;
        int minuteModule = m % 5;
        return getLampsForMinuteFive(minuteDivided) + getLampsForMinuteSingle(minuteModule);
    }

    private String getLampsForMinuteFive(int m) {
        StringBuffer light = new StringBuffer(Color.ALL_ELEVEN_OFF.code);
        for (int i = 0; i < m; i++) {
            if ((i + 1) % 3 == 0) {
                light.replace(i, i + 1, Color.RED.code);
            } else {
                light.replace(i, i + 1, Color.YELLOW.code);
            }
        }
        return light.toString();
    }

    private String getLampsForMinuteSingle(int m) {
        StringBuffer light = new StringBuffer(Color.ALL_FOUR_OFF.code);
        for (int i = 0; i < m; i++) {
            light.replace(i, i + 1, Color.YELLOW.code);
        }
        return light.toString();
    }
}

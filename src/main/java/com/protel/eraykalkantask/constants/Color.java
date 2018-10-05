package com.protel.eraykalkantask.constants;

public enum Color {
    RED("R"), YELLOW("Y"),OFF("O"),ALL_FOUR_OFF("0000"),ALL_ELEVEN_OFF("00000000000"),ALL_OFF("0000");

    public final String code;

    Color(String code) {
        this.code = code;
    }
}

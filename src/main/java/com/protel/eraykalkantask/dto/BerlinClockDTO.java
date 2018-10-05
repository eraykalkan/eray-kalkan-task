package com.protel.eraykalkantask.dto;

import java.util.Objects;

public class BerlinClockDTO {

    private String clock;

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerlinClockDTO that = (BerlinClockDTO) o;
        return Objects.equals(clock, that.clock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clock);
    }

    @Override
    public String toString() {
        return "BerlinClockDTO{" +
                "clock='" + clock + '\'' +
                '}';
    }
}

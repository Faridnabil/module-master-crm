package com.icon.pln.master.modules.MasterNoKwh.entity;

import java.io.Serializable;

public class RefMerekMeterId implements Serializable {
    private String merekMeter;
    private String flag;

    // Default constructor
    public RefMerekMeterId() {
    }

    // Constructor
    public RefMerekMeterId(String merekMeter, String flag) {
        this.merekMeter = merekMeter;
        this.flag = flag;
    }

    // Getters and Setters
    public String getMerekMeter() {
        return merekMeter;
    }

    public void setMerekMeter(String merekMeter) {
        this.merekMeter = merekMeter;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RefMerekMeterId that = (RefMerekMeterId) o;

        if (!merekMeter.equals(that.merekMeter))
            return false;
        return flag.equals(that.flag);
    }

    @Override
    public int hashCode() {
        int result = merekMeter.hashCode();
        result = 31 * result + flag.hashCode();
        return result;
    }
}
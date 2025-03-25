package com.icon.pln.master.modules.MasterNoKwh.entity;

import java.io.Serializable;
import java.util.Date;

public class MasterKwhPrepaidLogId implements Serializable {
    private String noKwh;
    private Date tglLog;

    // Default constructor
    public MasterKwhPrepaidLogId() {
    }

    // Constructor
    public MasterKwhPrepaidLogId(String noKwh, Date tglLog) {
        this.noKwh = noKwh;
        this.tglLog = tglLog;
    }

    // Getters and Setters
    public String getNoKwh() {
        return noKwh;
    }

    public void setNoKwh(String noKwh) {
        this.noKwh = noKwh;
    }

    public Date getTglLog() {
        return tglLog;
    }

    public void setTglLog(Date tglLog) {
        this.tglLog = tglLog;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MasterKwhPrepaidLogId that = (MasterKwhPrepaidLogId) o;

        if (!noKwh.equals(that.noKwh))
            return false;
        return tglLog.equals(that.tglLog);
    }

    @Override
    public int hashCode() {
        int result = noKwh.hashCode();
        result = 31 * result + tglLog.hashCode();
        return result;
    }
}
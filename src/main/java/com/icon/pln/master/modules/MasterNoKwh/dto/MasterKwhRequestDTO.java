package com.icon.pln.master.modules.MasterNoKwh.dto;

import lombok.Data;

@Data
public class MasterKwhRequestDTO {
    private String noKwh;
    private String noPabrik;
    private String merekMeter;
    private String typeMeter;
    private String unitup;
    private String user;
}
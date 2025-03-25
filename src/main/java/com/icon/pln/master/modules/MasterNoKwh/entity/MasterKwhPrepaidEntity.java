package com.icon.pln.master.modules.MasterNoKwh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "master_kwh_prepaid")
@Data
public class MasterKwhPrepaidEntity {

    @Id
    @Column(name = "no_kwh", length = 11, nullable = false)
    private String noKwh; // Sesuai PK di Oracle

    @Column(length = 12)
    private String idpel;

    @Column(name = "no_pabrik", length = 2, nullable = false) // Di Oracle NOT NULL
    private String noPabrik;

    @Column(name = "merek_meter", length = 12, nullable = false) // Di Oracle NOT NULL
    private String merekMeter;

    @Column(name = "type_meter", length = 20, nullable = false) // Di Oracle NOT NULL
    private String typeMeter;

    @Column(length = 25)
    private String userEntry;

    @Column(length = 5, nullable = false)
    private String unitup;
}
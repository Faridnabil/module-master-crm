package com.icon.pln.master.modules.MasterNoKwh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ref_merek_meter")
@IdClass(RefMerekMeterId.class)
public class RefMerekMeterEntity {

    @Id
    @Column(name = "merek_meter", length = 15, nullable = false)
    private String merekMeter;

    @Id
    @Column(length = 1, nullable = false)
    private String flag;

    @Column(length = 50)
    private String keterangan;

    @Column(name = "type_meter", length = 20)
    private String typeMeter;

    @Column(name = "no_pabrik", length = 2)
    private String noPabrik;
}
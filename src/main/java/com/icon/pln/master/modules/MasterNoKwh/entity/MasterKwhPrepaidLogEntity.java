package com.icon.pln.master.modules.MasterNoKwh.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "master_kwh_prepaid_log")
@IdClass(MasterKwhPrepaidLogId.class)
public class MasterKwhPrepaidLogEntity {

    @Id
    @Column(name = "no_kwh", length = 11, nullable = false)
    private String noKwh;

    @Id
    @Column(name = "tgl_log", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglLog;

    @Column(length = 12)
    private String idpel;

    @Column(name = "no_pabrik", length = 2, nullable = false)
    private String noPabrik;

    @Column(name = "merek_meter", length = 12, nullable = false)
    private String merekMeter;

    @Column(name = "type_meter", length = 20, nullable = false)
    private String typeMeter;

    @Column(length = 50)
    private String userEdit;

    @Column(length = 5, nullable = false)
    private String unitup;

    @ManyToOne
    @JoinColumn(name = "no_kwh", referencedColumnName = "no_kwh", insertable = false, updatable = false)
    private MasterKwhPrepaidEntity masterKwh;
}
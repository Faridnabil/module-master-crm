package com.icon.pln.master.modules.MasterNoKwh.repository;

import java.util.List;

import com.icon.pln.master.modules.MasterNoKwh.entity.MasterKwhPrepaidEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MasterKwhPrepaidRepository implements PanacheRepository<MasterKwhPrepaidEntity> {
    public List<MasterKwhPrepaidEntity> findByUnitup(String unitup) {
        return list("unitup", unitup);
    }
    
    public Long countByNoKwhAndIdpelNotNull(String noKwh) {
        return count("noKwh = ?1 and idpel is not null", noKwh);
    }
}

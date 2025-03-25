package com.icon.pln.master.modules.MasterNoKwh.repository;

import java.util.List;

import com.icon.pln.master.modules.MasterNoKwh.entity.RefMerekMeterEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RefMerekMeterRepository implements PanacheRepository<RefMerekMeterEntity> {
    public List<RefMerekMeterEntity> findByNoPabrikPrefix(String prefix) {
        return list("noPabrik = ?1 and flag = 'T'", prefix);
    }
}

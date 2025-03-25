package com.icon.pln.master.modules.MasterNoKwh.repository;

import com.icon.pln.master.modules.MasterNoKwh.entity.MasterKwhPrepaidLogEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MasterKwhPrepaidLogRepository implements PanacheRepository<MasterKwhPrepaidLogEntity> {
}

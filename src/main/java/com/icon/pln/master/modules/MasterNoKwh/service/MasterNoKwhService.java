package com.icon.pln.master.modules.MasterNoKwh.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.icon.pln.master.common.ApiResponse;
import com.icon.pln.master.modules.MasterNoKwh.dto.DeleteRequestDTO;
import com.icon.pln.master.modules.MasterNoKwh.dto.MasterKwhRequestDTO;
import com.icon.pln.master.modules.MasterNoKwh.entity.MasterKwhPrepaidEntity;
import com.icon.pln.master.modules.MasterNoKwh.entity.MasterKwhPrepaidLogEntity;
import com.icon.pln.master.modules.MasterNoKwh.entity.RefMerekMeterEntity;
import com.icon.pln.master.modules.MasterNoKwh.repository.MasterKwhPrepaidLogRepository;
import com.icon.pln.master.modules.MasterNoKwh.repository.MasterKwhPrepaidRepository;
import com.icon.pln.master.modules.MasterNoKwh.repository.RefMerekMeterRepository;

@RequiredArgsConstructor
@ApplicationScoped
public class MasterNoKwhService {

    private final MasterKwhPrepaidRepository masterRepo;

    private final MasterKwhPrepaidLogRepository logRepo;

    private final RefMerekMeterRepository refMerekRepo;

    public ApiResponse<List<MasterKwhPrepaidEntity>> getMasterNomorKWH(String unitup) {
        List<MasterKwhPrepaidEntity> data = masterRepo.findByUnitup(unitup);
        return ApiResponse.ok(data);
    }

    public ApiResponse<List<RefMerekMeterEntity>> getCariDataMeter(String noKwh) {
        String prefix = noKwh != null && noKwh.length() >= 2 ? noKwh.trim().substring(0, 2) : "";
        List<RefMerekMeterEntity> data = refMerekRepo.findByNoPabrikPrefix(prefix);
        return ApiResponse.ok(data);
    }

    @Transactional
    public ApiResponse<String> setMasterNomorKWH(MasterKwhRequestDTO request) {
        try {
            Long count = masterRepo.countByNoKwhAndIdpelNotNull(request.getNoKwh());
            if (count > 0) {
                return ApiResponse.badRequest("Gagal, Nomor KWH Sudah Dipakai Pelanggan Lain");
            }

            Optional<MasterKwhPrepaidEntity> existing = masterRepo.find("noKwh", request.getNoKwh())
                    .firstResultOptional();

            if (existing.isPresent()) {
                // Insert log
                MasterKwhPrepaidEntity oldData = existing.get();
                MasterKwhPrepaidLogEntity log = new MasterKwhPrepaidLogEntity();
                log.setNoKwh(oldData.getNoKwh());
                log.setTglLog(new Date());
                log.setIdpel(oldData.getIdpel());
                log.setNoPabrik(oldData.getNoPabrik());
                log.setMerekMeter(oldData.getMerekMeter());
                log.setTypeMeter(oldData.getTypeMeter());
                log.setUserEdit(oldData.getUserEntry());
                log.setUnitup(oldData.getUnitup());
                logRepo.persist(log);

                // Update existing
                oldData.setNoPabrik(request.getNoPabrik());
                oldData.setMerekMeter(request.getMerekMeter());
                oldData.setTypeMeter(request.getTypeMeter());
                oldData.setUserEntry(request.getUser());
                oldData.setUnitup(request.getUnitup());
                masterRepo.persist(oldData);

                return ApiResponse.ok("Succes, Nomor KWH berhasil diUPDATE.");
            } else {
                // Insert new
                MasterKwhPrepaidEntity newData = new MasterKwhPrepaidEntity();
                newData.setNoKwh(request.getNoKwh());
                newData.setNoPabrik(request.getNoPabrik());
                newData.setMerekMeter(request.getMerekMeter());
                newData.setTypeMeter(request.getTypeMeter());
                newData.setUserEntry(request.getUser());
                newData.setUnitup(request.getUnitup());
                masterRepo.persist(newData);

                return ApiResponse.ok("Succes, Nomor KWH berhasil disimpan.");
            }
        } catch (Exception e) {
            return ApiResponse.error("Gagal, Nomor KWH gagal disimpan. Error: " + e.getMessage());
        }
    }

    @Transactional
    public ApiResponse<String> delMasterNomorKWH(DeleteRequestDTO request) {
        try {
            Long count = masterRepo.count("noKwh = ?1 and idpel is not null", request.getNoKwh());
            if (count > 0) {
                return ApiResponse.badRequest("Gagal, Nomor KWH SEDANG DIPAKAI PELANGGAN");
            }

            Long logCount = logRepo.count("noKwh = ?1 and idpel is not null", request.getNoKwh());
            if (logCount > 0) {
                logRepo.delete("noKwh", request.getNoKwh());
            }
            masterRepo.delete("noKwh", request.getNoKwh());

            return ApiResponse.ok("Succes, hapus data Nomor KWH berhasil.");
        } catch (Exception e) {
            return ApiResponse.error("Gagal: " + e.getMessage());
        }
    }
}
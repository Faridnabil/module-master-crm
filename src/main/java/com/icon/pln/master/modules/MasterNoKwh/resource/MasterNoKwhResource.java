package com.icon.pln.master.modules.MasterNoKwh.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.icon.pln.master.common.ApiResponse;
import com.icon.pln.master.modules.MasterNoKwh.dto.DeleteRequestDTO;
import com.icon.pln.master.modules.MasterNoKwh.dto.MasterKwhRequestDTO;
import com.icon.pln.master.modules.MasterNoKwh.entity.MasterKwhPrepaidEntity;
import com.icon.pln.master.modules.MasterNoKwh.entity.RefMerekMeterEntity;
import com.icon.pln.master.modules.MasterNoKwh.service.MasterNoKwhService;

@Path("master-nomor-kwh")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class MasterNoKwhResource {

    private final MasterNoKwhService service;

    @GET
    @Path("/{unitup}")
    public ApiResponse<List<MasterKwhPrepaidEntity>> getByUnitup(@PathParam("unitup") String unitup) {
        return service.getMasterNomorKWH(unitup);
    }

    @GET
    @Path("/cari-meter/{noKwh}")
    public ApiResponse<List<RefMerekMeterEntity>> cariDataMeter(@PathParam("noKwh") String noKwh) {
        return service.getCariDataMeter(noKwh);
    }

    @POST
    public ApiResponse<String> saveMaster(@Valid MasterKwhRequestDTO request) {
        return service.setMasterNomorKWH(request);
    }

    @DELETE
    public ApiResponse<String> deleteMaster(@Valid DeleteRequestDTO request) {
        return service.delMasterNomorKWH(request);
    }
}
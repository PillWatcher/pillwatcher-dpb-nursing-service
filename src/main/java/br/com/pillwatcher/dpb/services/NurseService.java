package br.com.pillwatcher.dpb.services;

import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import io.swagger.model.NurseDTOForUpdate;
import io.swagger.model.WrapperListResponse;

public interface NurseService {

    NurseDTOForResponse create(NurseDTOForCreate nurseDTOForCreate);

    NurseDTOForResponse get(String cpf);

    NurseDTOForResponse update(NurseDTOForUpdate nurseDTOForUpdate, String cpf);

    void delete(String cpf);

    WrapperListResponse getAllNurses();

}

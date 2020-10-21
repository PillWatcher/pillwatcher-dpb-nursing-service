package br.com.pillwatcher.dpb.services;

import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;

public interface NurseService {

    NurseDTOForResponse create(final NurseDTOForCreate nurseDTOForCreate);

    NurseDTOForResponse get(final String cpf);

//    NurseDTOForResponse update(final String cpf);


}

package br.com.pillwatcher.dpb.services;

import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;

public interface NurseService {

    public NurseDTOForResponse create(final NurseDTOForCreate nurseDTOForCreate);

}

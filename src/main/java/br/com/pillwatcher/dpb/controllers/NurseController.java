package br.com.pillwatcher.dpb.controllers;

import br.com.pillwatcher.dpb.services.impl.NurseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.api.NursesApi;
import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static br.com.pillwatcher.dpb.constants.UrlConstants.BASE_PATH;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Api(tags = "Nurse")
public class NurseController implements NursesApi {

    private final NurseServiceImpl nurseService;

    @Override
    public ResponseEntity<NurseDTOForResponse> createNurse(@Valid @RequestBody final NurseDTOForCreate body) {

        log.debug("NurseController.createNurse - : {}", body);

        NurseDTOForResponse nurseDTOForResponse = nurseService.create(body);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nurseDTOForResponse);
    }

    @Override
    public ResponseEntity<NurseDTOForResponse> getNurse(@PathVariable("cpf") final String cpf) {

        log.debug("NurseController.getNurse - : {}", cpf);

        return ResponseEntity.status(HttpStatus.OK)
                .body(nurseService.get(cpf));
    }
}

package br.com.pillwatcher.dpb.controllers;

import br.com.pillwatcher.dpb.services.impl.NurseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.api.NursesApi;
import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import io.swagger.model.NurseDTOForUpdate;
import io.swagger.model.WrapperListResponse;

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

        log.info("NurseController.createNurse - Input: {}", body);
        log.debug("NurseController.createNurse - Input: {}", body);

        NurseDTOForResponse nurseDTOForResponse = nurseService.create(body);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nurseDTOForResponse);
    }

    @Override
    public ResponseEntity<NurseDTOForResponse> getNurse(@PathVariable("cpf") final String cpf) {

        log.info("NurseController.getNurse - Input: {}", cpf);
        log.debug("NurseController.getNurse - Input: {}", cpf);

        NurseDTOForResponse nurse = nurseService.get(cpf);

        ResponseEntity<NurseDTOForResponse> response = ResponseEntity
                .status(HttpStatus.OK)
                .body(nurse);

        log.debug("NurseController.deleteNurse - Input: {} - Output: {}", cpf, response);

        return response;
    }

    @Override
    public ResponseEntity<Void> deleteNurse(@PathVariable("cpf") final String cpf) {

        log.info("NurseController.deleteNurse - Input: {}", cpf);
        log.debug("NurseController.deleteNurse - Input: {}", cpf);

        nurseService.delete(cpf);

        ResponseEntity<Void> response = ResponseEntity
                .ok()
                .build();

        log.debug("NurseController.deleteNurse - Input: {} - Output: {}", cpf, response);

        return response;
    }

    @Override
    public ResponseEntity<WrapperListResponse> getAllNurse() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(nurseService.getAllNurses());
    }

    @Override
    public ResponseEntity<NurseDTOForResponse> updateNurse(@RequestBody @Valid final NurseDTOForUpdate body,
                                                           @PathVariable("cpf") final String cpf) {

        log.info("NurseController.updateNurse - Start - Input - Order: {} - {}", body, cpf);
        log.debug("NurseController.updateNurse - Start - Input - Order: {} - {}", body, cpf);

        final NurseDTOForResponse nurse = nurseService.update(body, cpf);
        
        ResponseEntity<NurseDTOForResponse> response = ResponseEntity
                .status(HttpStatus.OK)
                .body(nurse);

        log.debug("NurseController.updateNurse - End - Input: {} - Output: {} {}", body, nurse, response);

        return response;
    }
}

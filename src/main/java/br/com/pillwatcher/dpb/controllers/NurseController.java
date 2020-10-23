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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.pillwatcher.dpb.constants.UrlConstants.URI_NURSES;
import static br.com.pillwatcher.dpb.constants.UrlConstants.URI_NURSES_CPF;


@Slf4j
@RequiredArgsConstructor
@RestController
@Api(tags = "Nurse")
public class NurseController implements NursesApi {

    private final NurseServiceImpl nurseService;

    @Override
    @PostMapping(value = URI_NURSES)
    public ResponseEntity<NurseDTOForResponse> createNurse(@Valid @RequestBody final NurseDTOForCreate body) {

        log.info("NurseController.createNurse - Input - Order: {}", body);
        log.debug("NurseController.createNurse - Input - Order: {}", body);

        NurseDTOForResponse nurseDTOForResponse = nurseService.create(body);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nurseDTOForResponse);
    }

    @Override
    @GetMapping(value = URI_NURSES_CPF)
    public ResponseEntity<NurseDTOForResponse> getNurse(@PathVariable("cpf") final String cpf) {

        log.info("NurseController.getNurse - Input - Order: {}", cpf);
        log.debug("NurseController.getNurse - Input - Order: {}", cpf);

        NurseDTOForResponse nurse = nurseService.get(cpf);

        ResponseEntity<NurseDTOForResponse> response = ResponseEntity
                .status(HttpStatus.OK)
                .body(nurse);

        log.debug("NurseController.deleteNurse - Input: {} - Output: {}", cpf, response);

        return response;
    }

    @Override
    @PutMapping(value = URI_NURSES_CPF)
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

    @Override
    @DeleteMapping(value = URI_NURSES_CPF)
    public ResponseEntity<Void> deleteNurse(@PathVariable("cpf") final String cpf) {

        log.info("NurseController.deleteNurse - Input - Order: {}", cpf);
        log.debug("NurseController.deleteNurse - Input - Order: {}", cpf);

        nurseService.delete(cpf);

        ResponseEntity<Void> response = ResponseEntity
                .ok()
                .build();

        log.debug("NurseController.deleteNurse - Input: {} - Output: {}", cpf, response);

        return response;
    }

    @Override
    @GetMapping(value = URI_NURSES)
    public ResponseEntity<WrapperListResponse> getAllNurse() {

        log.info("NurseController.findAll - Input - Order: {}", "");
        log.debug("NurseController.findAll - Input - Order: {}", "");

        WrapperListResponse nurses = nurseService.getAllNurses();

        ResponseEntity<WrapperListResponse> response = ResponseEntity
                .status(HttpStatus.OK)
                .body(nurses);

        log.debug("NurseController.findAll - Input: {} - Output: {}",
                null, response);

        return response;
    }

}

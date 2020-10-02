package br.com.pillwatcher.dpb.controllers;

import br.com.pillwatcher.dpb.services.impl.NurseServiceImpl;
import io.swagger.api.NursesApi;
import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static br.com.pillwatcher.dpb.constants.UrlConstants.BASE_PATH;
import static br.com.pillwatcher.dpb.constants.UrlConstants.NURSE_PATH;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
public class NurseController implements NursesApi {

    private final NurseServiceImpl nurseService;

    @Override
    @PostMapping(value = NURSE_PATH)
    public ResponseEntity<NurseDTOForResponse> createNurse(@Valid @RequestBody final NurseDTOForCreate body) {

        log.debug("NurseController.createNurse - Start - Input - Order: {}", body);

        NurseDTOForResponse nurseDTOForResponse = nurseService.create(body);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nurseDTOForResponse);
    }
}

package br.com.pillwatcher.dpb.services.impl;

import br.com.pillwatcher.dpb.constants.ErrorMessages;
import br.com.pillwatcher.dpb.constants.ValidationConstraints;
import br.com.pillwatcher.dpb.entities.Nurse;
import br.com.pillwatcher.dpb.exceptions.NurseException;
import br.com.pillwatcher.dpb.mappers.NurseMapper;
import br.com.pillwatcher.dpb.repositories.NurseRepository;
import br.com.pillwatcher.dpb.services.NurseService;
import io.swagger.model.ErrorCodeEnum;
import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;
    private final NurseMapper nurseMapper;

    @Override
    public NurseDTOForResponse create(final NurseDTOForCreate nurseDTOForCreate) {

        log.info("NurseServiceImpl.create - Start - Input {}", nurseDTOForCreate);

        Optional<Nurse> byEmail = nurseRepository.findByEmail(nurseDTOForCreate.getEmail());

        if (byEmail.isPresent()) {
            log.warn(ValidationConstraints.NURSE_ALREADY_EXISTS, nurseDTOForCreate.getEmail());
            throw new NurseException(ErrorCodeEnum.NURSE_ALREADY_EXISTS, ErrorMessages.CONFLICT,
                    StringUtils.replace(ValidationConstraints.NURSE_ALREADY_EXISTS, "{}", nurseDTOForCreate.getEmail()));
        }

        Nurse nurse = nurseMapper.dtoToEntity(nurseDTOForCreate);
        return nurseMapper.entityToDto(nurseRepository.save(nurse));
    }

}

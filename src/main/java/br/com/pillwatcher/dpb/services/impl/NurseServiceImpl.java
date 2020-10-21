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
        Optional<Nurse> byUserDocument = nurseRepository.findByUserDocument(nurseDTOForCreate.getDocument());

        if (byEmail.isPresent()) {
            log.warn(ValidationConstraints.NURSE_WITH_EMAIL_ALREADY_EXISTS, nurseDTOForCreate.getEmail());
            throw new NurseException(ErrorCodeEnum.NURSE_ALREADY_EXISTS, ErrorMessages.CONFLICT,
                    StringUtils.replace(ValidationConstraints.NURSE_WITH_EMAIL_ALREADY_EXISTS, "{}", nurseDTOForCreate.getEmail()));
        }

        if (byUserDocument.isPresent()) {
            log.warn(ValidationConstraints.NURSE_WITH_DOCUMENT_ALREADY_EXISTS, nurseDTOForCreate.getEmail());
            throw new NurseException(ErrorCodeEnum.NURSE_ALREADY_EXISTS, ErrorMessages.CONFLICT,
                    StringUtils.replace(ValidationConstraints.NURSE_WITH_DOCUMENT_ALREADY_EXISTS, "{}", nurseDTOForCreate.getDocument()));
        }

        Nurse nurse = nurseMapper.dtoToEntity(nurseDTOForCreate);
        return nurseMapper.entityToDto(nurseRepository.save(nurse));
    }

    @Override
    public NurseDTOForResponse get(final String cpf) {

        log.info("NurseServiceImpl.get - Start - Input {}", cpf);

        Optional<Nurse> byUserDocument = nurseRepository.findByUserDocument(cpf);

        if (!byUserDocument.isPresent()) {
            log.warn(ValidationConstraints.NURSE_NOT_FOUND, cpf);
            throw new NurseException(ErrorCodeEnum.NOT_FOUND, ErrorMessages.NOT_FOUND,
                    StringUtils.replace(ValidationConstraints.NURSE_NOT_FOUND, "{}", cpf));
        }
        return nurseMapper.entityToDto(byUserDocument.get());
    }

}

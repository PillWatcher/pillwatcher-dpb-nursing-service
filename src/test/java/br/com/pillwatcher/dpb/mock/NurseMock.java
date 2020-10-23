package br.com.pillwatcher.dpb.mock;

import io.swagger.model.NurseDTOForCreate;

public class NurseMock {

    public static NurseDTOForCreate getNurseDTOForCreateMock() {
        NurseDTOForCreate nurse = new NurseDTOForCreate();

        nurse.setCoren("123456");
        nurse.setDocument("83635431010");
        nurse.setEmail("enfermeiro@gmail.com");
        nurse.setFederativeUnit("DF");
        nurse.setImageUrl("http://amazon.s3.com/uuid");
        nurse.setName("Enfermeiro teste");
        nurse.setPhone("995421012");
        return nurse;

    }
}

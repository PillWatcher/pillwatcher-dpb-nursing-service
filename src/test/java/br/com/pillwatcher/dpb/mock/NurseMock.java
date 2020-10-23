package br.com.pillwatcher.dpb.mock;

import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForUpdate;

public class NurseMock {

    public static final String CPF_FAKE = "83635431010";

    public static NurseDTOForCreate getNurseDTOForCreateMock() {
        NurseDTOForCreate nurse = new NurseDTOForCreate();

        nurse.setCoren("123456");
        nurse.setDocument(CPF_FAKE);
        nurse.setEmail("enfermeiro@gmail.com");
        nurse.setFederativeUnit("DF");
        nurse.setImageUrl("http://amazon.s3.com/uuid");
        nurse.setName("Enfermeiro teste");
        nurse.setPhone("995421012");
        return nurse;

    }

    public static NurseDTOForCreate getNurseDTOForCreateAlreadyEmailMock() {
        NurseDTOForCreate nurse = new NurseDTOForCreate();

        nurse.setCoren("123000");
        nurse.setDocument(CPF_FAKE);
        nurse.setEmail("fernanda@gmail.com");
        nurse.setFederativeUnit("DF");
        nurse.setImageUrl("http://amazon.s3.com/uuid");
        nurse.setName("Enfermeiro teste");
        nurse.setPhone("42592101063");
        return nurse;

    }

    public static NurseDTOForCreate getNurseDTOForCreateAlreadyDocumentMock() {
        NurseDTOForCreate nurse = new NurseDTOForCreate();

        nurse.setCoren("454545");
        nurse.setDocument("85703682088");
        nurse.setEmail("maira@gmail.com");
        nurse.setFederativeUnit("DF");
        nurse.setImageUrl("http://amazon.s3.com/uuid");
        nurse.setName("Enfermeiro teste");
        nurse.setPhone("42592101063");
        return nurse;

    }

    public static NurseDTOForUpdate getNurseDTOForUpdate() {
        NurseDTOForUpdate nurse = new NurseDTOForUpdate();

        nurse.setEmail("enfermeiroupdated@gmail.com");
        nurse.setName("Enfermeiro teste Update");
        nurse.setPhone("995421013");
        return nurse;

    }
}

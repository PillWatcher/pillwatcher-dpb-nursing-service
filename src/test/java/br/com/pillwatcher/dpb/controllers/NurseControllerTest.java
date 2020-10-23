package br.com.pillwatcher.dpb.controllers;

import br.com.pillwatcher.dpb.constants.UrlConstants;
import br.com.pillwatcher.dpb.mock.NurseMock;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    public void createNurse() {

        this.mockMvc.perform(post(UrlConstants.URI_NURSES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForCreateMock())))
                .andExpect(status().isOk());
    }
}

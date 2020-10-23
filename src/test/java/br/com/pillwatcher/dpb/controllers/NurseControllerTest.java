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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static br.com.pillwatcher.dpb.mock.NurseMock.CPF_FAKE;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("classpath:load.sql")
@SpringBootTest
@AutoConfigureMockMvc
public class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createNurse() throws Exception {

        this.mockMvc.perform(post(UrlConstants.URI_NURSES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForCreateMock())))
                .andExpect(status().isCreated());
    }

    @Test
    public void getNurse() throws Exception {

        this.mockMvc.perform(get(UrlConstants.URI_NURSES_CPF, "85703682088")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNurse() throws Exception {

        this.mockMvc.perform(delete(UrlConstants.URI_NURSES_CPF, "92517931070")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllNurses() throws Exception {

        this.mockMvc.perform(get(UrlConstants.URI_NURSES)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNurse() throws Exception {

        this.mockMvc.perform(put(UrlConstants.URI_NURSES_CPF, "92517931070")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForUpdate())))
                .andExpect(status().isOk());
    }

}

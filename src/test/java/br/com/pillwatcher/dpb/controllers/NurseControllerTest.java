package br.com.pillwatcher.dpb.controllers;

import br.com.pillwatcher.dpb.constants.UrlConstants;
import br.com.pillwatcher.dpb.mock.NurseMock;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("classpath:load.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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
    public void createNurseAlreadyEmailExists() throws Exception {

        this.mockMvc.perform(post(UrlConstants.URI_NURSES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForCreateAlreadyEmailMock())))
                .andExpect(status().isConflict());
    }

    @Test
    public void createNurseAlreadyDocumentExists() throws Exception {

        this.mockMvc.perform(post(UrlConstants.URI_NURSES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForCreateAlreadyDocumentMock())))
                .andExpect(status().isConflict());
    }

    @Test
    public void getNurse() throws Exception {

        this.mockMvc.perform(get(UrlConstants.URI_NURSES_CPF, "85703682088")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getNurseNotFound() throws Exception {

        this.mockMvc.perform(get(UrlConstants.URI_NURSES_CPF, "11111111111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteNurse() throws Exception {

        this.mockMvc.perform(delete(UrlConstants.URI_NURSES_CPF, "92517931070")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNurseNotFound() throws Exception {

        this.mockMvc.perform(delete(UrlConstants.URI_NURSES_CPF, "11111111111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
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

    @Test
    public void updateNurseNotFound() throws Exception {

        this.mockMvc.perform(put(UrlConstants.URI_NURSES_CPF, "11111111111")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(NurseMock.getNurseDTOForUpdate())))
                .andExpect(status().isNotFound());
    }

}

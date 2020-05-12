package com.keeper.app.KeeperApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keeper.app.KeeperApp.entity.Note;
import com.keeper.app.KeeperApp.api.request.NoteRequest;
import com.keeper.app.KeeperApp.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        noteRepository.deleteAll();
    }

    @Test
    void get_all_notes() throws Exception {
        List<NoteRequest> notes = Arrays.asList(new NoteRequest("love", "never fall for it"),
                                                new NoteRequest("code",
                                                                "always leave it better than you " +

                                                                        "found"));

        noteRepository.saveAll(
                notes.stream().map(NoteRequest::toNote).collect(Collectors.toList()));
        this.mockMvc.perform(get("/notes/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void add_a_note() throws Exception {
        NoteRequest noteRequest = new NoteRequest("optum", "never work here");
        String json = objectMapper.writeValueAsString(noteRequest);
        this.mockMvc.perform(
                post("/notes/add")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("optum"));
    }

    @Test
    void delete_a_note() throws Exception {
        NoteRequest noteRequest = new NoteRequest("zakir", "never disappointed");
        Note note = noteRepository.save(noteRequest.toNote());
        this.mockMvc.perform(delete("/notes/delete/{id}", note.getId())).andDo(print())
                .andExpect(status().isNoContent());
        assertEquals(noteRepository.count(), 0);
    }
}
package br.com.carlos.terminalregister.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TerminalControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200AndGetAllTerminals() throws Exception {
        URI uri = new URI("/001/terminal");
        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        ).andExpect(MockMvcResultMatchers
                .jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldReturn200AndGeTerminalByLogic() throws Exception {
        String logic = "88449944";
        String stringUri = "/001/terminal/"+logic;
        URI uri = new URI(stringUri);
        String result = "{\"logic\":88449944,\"serial\":\"321\",\"model\":\"MTOON\",\"sam\":0,\"ptid\":\"J07F3R5096H\",\"plat\":6,\"version\":\"9.00b4\",\"mxr\":0,\"mxf\":25848424,\"verfm\":\"MTOON\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        ).andExpect(MockMvcResultMatchers.content().string(result));
    }

    @Test
    public void shouldCreateNewTerminalAndReturn201andCreatedTerminal() throws Exception {
        URI uri = new URI("/001/terminal");
        String input = "99887744;456;GGRUN;0;F04A2E4088B;4;8.00b3;0;99887744;GGRUN";
        String result = "{\"logic\":99887744,\"serial\":\"456\",\"model\":\"GGRUN\",\"sam\":0,\"ptid\":\"F04A2E4088B\",\"plat\":4,\"version\":\"8.00b3\",\"mxr\":0,\"mxf\":99887744,\"verfm\":\"GGRUN\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(input)
                .contentType(MediaType.TEXT_PLAIN)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(201)
        ).andExpect(MockMvcResultMatchers.content().string(result));
    }

    @Test
    public void shouldUpdateTerminalAndReturn201andUpdatedTerminal() throws Exception {
        String logic = "88449944";
        String stringUri = "/001/terminal/"+logic;
        URI uri = new URI(stringUri);
        String input = "{\"logic\":88449944,\"serial\":\"852\",\"model\":\"AAAAA\",\"sam\":9,\"ptid\":\"LALALALALA\",\"plat\":8,\"version\":\"5t5t5\",\"mxr\":9,\"mxf\":88449944,\"verfm\":\"AAAAA\"}";
        String result = "{\"logic\":88449944,\"serial\":\"852\",\"model\":\"AAAAA\",\"sam\":9,\"ptid\":\"LALALALALA\",\"plat\":8,\"version\":\"5t5t5\",\"mxr\":9,\"mxf\":88449944,\"verfm\":\"AAAAA\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .put(uri)
                .content(input)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        ).andExpect(MockMvcResultMatchers.content().string(result));
    }



}

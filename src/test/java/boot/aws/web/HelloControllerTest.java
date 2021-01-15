package boot.aws.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
     String hello = "hello";
        mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }
    @DisplayName("Return HelloDto")
    @Test
    void HelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get("/hello/dto")
                .param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));


    }

}

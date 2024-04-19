package ch.amsler.simon.kundenverwaltung.kunden;
import ch.amsler.simon.kundenverwaltung.security.Keycloak;
import org.junit.jupiter.api.*;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KundenControllerTest {
    @Autowired
    private MockMvc api;
    @Autowired
    private KundenRepository kundenRepository;
    private static String accessToken;


    private static final String keycloakUrl = "http://localhost:8080/realms/M295";

    public static String getAccessToken() {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "client_id=kundenverwaltung&" +
                "grant_type=password&" +
                "scope=openid profile roles offline_access&" +
                "username=adminkv&" +
                "password=Ri4sch20!&";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> resp = rest.postForEntity(keycloakUrl + "/protocol/openid-connect/token", entity, String.class);

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resp.getBody()).get("access_token").toString();
    }

    @BeforeAll
    void setup() {
        accessToken = getAccessToken();
        kundenRepository.deleteAll();
        kundenRepository.save(new KundenData(1L,"Simon", "Amsler"));
        kundenRepository.save(new KundenData(2L, "Josh","Kunz"));
        kundenRepository.save(new KundenData(3L, "Seth","Schmutz"));
    }

    @Test
    @Order(1)
    public void testGetAll() throws Exception {
        api.perform(get("/api/kunden").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Simon")))
                .andExpect(content().string(containsString("Josh")))
                .andExpect(content().string(containsString("Seth")));
    }

    @Test
    @Order(4)
    public void testCreate() throws Exception {
        api.perform(post("/api/kunden").header("Authorization", "Bearer " + accessToken).with(csrf())
                        .contentType("application/json")
                        .content("{\"vorname\":\"Cem\",\"name\":\"Akkaya\",\"kundennummer\":4}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Cem")));

        api.perform(get("/api/kunden").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cem")));

        Assertions.assertEquals(4, kundenRepository.count());
    }


    @Test
    @Order(5)
    public void testUpdate() throws Exception {
        if (kundenRepository.count() != 4) {
            kundenRepository.save(new KundenData(4L, "Cem", "Akkaya"));
        }

        api.perform(put("/api/kunden/4").header("Authorization", "Bearer " + accessToken).with(csrf())
                        .contentType("application/json")
                        .content("{\"id\":4,\"vorname\":\"Cemmm\",\"name\":\"Akaia\",\"kundennummer\":4}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cemm")));
        api.perform(get("/api/kunden").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cemmm")));

        Assertions.assertEquals(4, kundenRepository.count());
    }

    @Test
    @Order(6)
    public void testDelete() throws Exception {
        api.perform(delete("/api/kunden/4").header("Authorization", "Bearer " + accessToken).with(csrf()))
                .andDo(print())
                .andExpect(status().isNoContent());

        api.perform(get("/api/kunden").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Simon")))
                .andExpect(content().string(containsString("Josh")))
                .andExpect(content().string(containsString("Seth")))
                .andExpect(content().string(not(containsString("Cemm"))));

        Assertions.assertEquals(3, kundenRepository.count());
        Assertions.assertTrue(kundenRepository.findById(4L).isEmpty());

    }

    @AfterAll
    void cleanup() {
        kundenRepository.deleteAll();
    }
}

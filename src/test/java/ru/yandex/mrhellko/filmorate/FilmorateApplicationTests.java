package ru.yandex.mrhellko.filmorate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

class FilmorateApplicationTests {

    private final RestClient restClient = new RestClient();
    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void init() {
        context = SpringApplication.run(FilmorateApplication.class);
    }

    @Test
    void filmsTest() {
        Response response;
        Executable executable;
        //pass
        response = restClient.post("/films", """
                {
                "name": "name",
                "description": "Description",
                "releaseDate": "1900-01-01",
                "duration": 1000
                }
                """);
        assertEquals(200, response.status());
        //Ошибка валидации
        executable = () -> restClient.post("/films", """
                {
                "name": "name",
                "description": "Description",
                "releaseDate": "1900-01-01",
                "duration": -1000
                }
                """);
        assertThrows(HttpClientErrorException.class, executable);
    }

    @AfterAll
    public static void destroy() {
        context.close();
    }

}

package ru.nskul.cadms.financialflowcontrolservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public class BaseIntegrationTest {

    @Container
    @SuppressWarnings({"AutoClosable", "resource"})
    static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(
        "postgres:15-alpine"
    )
        .withDatabaseName("test-db")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void configurePostgresContainer(DynamicPropertyRegistry registry) {
        postgresContainer.start();
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @Test
    void test() {
        assertThat(postgresContainer.isRunning()).isTrue();
    }
}

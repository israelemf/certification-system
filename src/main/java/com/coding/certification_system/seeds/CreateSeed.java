package com.coding.certification_system.seeds;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSourceManager = new DriverManagerDataSource();
        dataSourceManager.setDriverClassName("org.postgresql.Driver");
        dataSourceManager.setUrl("jdbc:postgresql://localhost:5432/db_certification");
        dataSourceManager.setUsername("admin");
        dataSourceManager.setPassword("admin");

        CreateSeed createSeed = new CreateSeed(dataSourceManager);
        createSeed.run(args);
    }

    public void run(String... args) {
        String deleteSql = "src/main/resources/scripts_sql/delete.sql";
        String questionsSeed = "src/main/resources/scripts_sql/questions.sql";

        executeSqlFile(Arrays.asList(deleteSql, questionsSeed));
    }

    private void executeSqlFile(List<String> filePaths) {
        filePaths.forEach(file -> {
            try {
                jdbcTemplate.execute(new String(Files.readAllBytes(Paths.get(file))));
            } catch (IOException e) {
                System.err.println("Erro ao executar arquivo " + e.getMessage());
            }
        });

        System.out.println("Seed realizado com sucesso!");
    }
}

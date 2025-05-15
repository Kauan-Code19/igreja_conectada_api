package com.kprojetos.IgrejaConectada.infraestrutura.configuracao;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.sql.DataSource;

@Configuration
public class FlywayConfiguracao {
    private final DataSource dataSource;
    private final String migrationLocation;


    public FlywayConfiguracao(
            DataSource dataSource,
            @Value("${flyway.locations}") String migrationLocation
    ) {
        this.dataSource = dataSource;
        this.migrationLocation = migrationLocation;
    }


    @Bean
    @Profile("development")
    @ConditionalOnProperty(name = "spring.flyway.enabled", havingValue = "true", matchIfMissing = true)
    public Flyway flywayDevelopment() {
        return configurarFlyway(migrationLocation + "/development");
    }


    @Bean
    @Profile("production")
    public Flyway flywayProduction() {
        return configurarFlyway(migrationLocation + "/production");
    }


    private Flyway configurarFlyway(String location) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .locations(location)
                .load();

        flyway.migrate();

        return flyway;
    }
}

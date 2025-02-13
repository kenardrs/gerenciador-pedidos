package br.com.alura.spring.desafio.gerenciador_pedidos.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSouceConfig {

    @Autowired
    private Dotenv dotenv;

    @Bean
    public DataSource dataSouce() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dotenv.get("DATASOURCE_URL"));
        dataSource.setUsername(dotenv.get("DATASOURCE_USER"));
        dataSource.setPassword(dotenv.get("DATASOURCE_PASSWORD"));

        return dataSource;
    }
}

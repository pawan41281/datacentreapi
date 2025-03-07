package colt.net.datacentreapi.logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DataSourceLogger {

    private final DataSource dataSource;
    private final Environment environment;

    public DataSourceLogger(DataSource dataSource, Environment environment) {
        this.dataSource = dataSource;
        this.environment = environment;
    }

    @Bean
    public CommandLineRunner printDataSourceDetails() {
        return args -> {
            System.out.println("====== DataSource Configuration ======");
            System.out.println("JDBC URL: " + environment.getProperty("spring.datasource.url"));
            System.out.println("Username: " + environment.getProperty("spring.datasource.username"));
            System.out.println("Driver Class: " + environment.getProperty("spring.datasource.driver-class-name"));

            try (Connection connection = dataSource.getConnection()) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Connected to: " + metaData.getURL());
                System.out.println("Database Product: " + metaData.getDatabaseProductName());
                System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
            } catch (SQLException e) {
                System.err.println("Failed to retrieve database metadata: " + e.getMessage());
            }
        };
    }
}

package colt.net.datacentreapi.logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DataSourceLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceLogger.class);

    private final DataSource dataSource;
    private final Environment environment;

    public DataSourceLogger(DataSource dataSource, Environment environment) {
        this.dataSource = dataSource;
        this.environment = environment;
    }

    @Bean
    public CommandLineRunner printDataSourceDetails() {
        return args -> {
        	logger.info("====== DataSource Configuration ======");
            logger.info("JDBC URL: " + environment.getProperty("spring.datasource.url"));
            logger.info("Username: " + environment.getProperty("spring.datasource.username"));
            logger.info("Driver Class: " + environment.getProperty("spring.datasource.driver-class-name"));

            try (Connection connection = dataSource.getConnection()) {
                DatabaseMetaData metaData = connection.getMetaData();
                logger.info("Connected to: " + metaData.getURL());
                logger.info("Database Product: " + metaData.getDatabaseProductName());
                logger.info("Database Version: " + metaData.getDatabaseProductVersion());
            } catch (SQLException e) {
                logger.error("Failed to retrieve database metadata: " + e.getMessage());
            }
        };
    }
}

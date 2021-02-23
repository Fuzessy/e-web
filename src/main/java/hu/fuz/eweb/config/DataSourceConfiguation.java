package hu.fuz.eweb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguation {

    @Bean("coreDb")
    @ConfigurationProperties(prefix = "datasource.coredb")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

}

import actor.mum.domain.Actor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import series.mum.domain.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Grimg on 12/11/2017.
 */
@SpringBootApplication(scanBasePackages ={ "series.mum.*"})
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource getDataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){

        Map<String,String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","create");

        return builder.dataSource(getDataSource())
                .properties(properties)
                .packages(Series.class,Actor.class).persistenceUnit("series").build();

    }



}

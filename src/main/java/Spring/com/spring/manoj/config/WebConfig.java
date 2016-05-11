package Spring.com.spring.manoj.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import Spring.com.spring.manoj.repository.SpittlesRepository;

@Configuration
@EnableWebMvc
@ComponentScan(value ="Spring.com.spring.manoj")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		datasource.setUsername("sample");
		datasource.setPassword("sample");
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public SpittlesRepository spittlesRepository(){
		return new SpittlesRepository(jdbcTemplate());
	}
}

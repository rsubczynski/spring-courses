package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lu2code.springdemo.coach.Coach;
import com.lu2code.springdemo.coach.SwimCoach;
import com.lu2code.springdemo.services.FortuneServices;
import com.lu2code.springdemo.services.SadFortuneService;

@Configuration
//@ComponentScan("com.lu2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneServices sadFortuneServices() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneServices());
	}
}

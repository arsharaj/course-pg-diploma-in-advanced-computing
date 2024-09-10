package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // mandatory cls level anno to tell SC following can contain spring bean
				// configurations : auto enables anno support
@ComponentScan(basePackages = {"dependent","dependency"})
//equivalent to <context:component-scan.../>
public class MyConfiguration {
}

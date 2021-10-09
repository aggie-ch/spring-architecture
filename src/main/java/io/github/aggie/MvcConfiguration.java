package io.github.aggie;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan(basePackages = "io.github.aggie")
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
}

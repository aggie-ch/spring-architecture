package io.github.aggie.common;

import io.github.aggie.common.profiler.Profiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

    @Bean
    public Profiler profiler() {
        return new Profiler();
    }
}

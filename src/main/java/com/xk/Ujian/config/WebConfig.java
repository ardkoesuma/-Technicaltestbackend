package com.xk.Ujian.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@Configuration
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // React app URL
                .allowedMethods("GET", "POST", "DELETE")
                .allowedHeaders("*");
    }
}
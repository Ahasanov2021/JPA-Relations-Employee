package az.ingress.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("student")
@Getter
@Setter
public class Config {

    private List<String> list;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

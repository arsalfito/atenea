package co.org.atenea.activos.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Setter
@Getter
public class YAMLConfig {

	private String name;

	private String environment;

	private boolean enabled;

	private Server server;

	private Spring spring;

}
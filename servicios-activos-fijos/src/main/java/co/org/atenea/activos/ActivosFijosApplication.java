package co.org.atenea.activos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.org.atenea.activos.configuration.YAMLConfig;


@EnableAutoConfiguration
@SpringBootApplication
public class ActivosFijosApplication implements CommandLineRunner{
	
	@Autowired
	private YAMLConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(ActivosFijosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Using environment: " + myConfig.getEnvironment());
		System.out.println("Name: " + myConfig.getName());
		System.out.println("Enabled:" + myConfig.isEnabled());
		System.out.println("Port:" + myConfig.getServer().getPort());
		System.out.println("Url:" + myConfig.getSpring().getDatasource().getUrl());
		System.out.println("Username:" + myConfig.getSpring().getDatasource().getUsername());
		System.out.println("Password:" + myConfig.getSpring().getDatasource().getPassword());
	}
	
}

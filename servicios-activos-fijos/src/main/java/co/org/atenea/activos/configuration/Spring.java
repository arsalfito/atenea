package co.org.atenea.activos.configuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spring {

	private String profiles;

	private Datasource datasource;

}
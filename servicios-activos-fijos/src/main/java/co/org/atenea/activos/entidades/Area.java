/**
 * 
 */
package co.org.atenea.activos.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Getter
@Setter
public class Area extends Responsable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CIUDAD_FK")
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
	private Ciudad ciudad;

}

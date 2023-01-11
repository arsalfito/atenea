/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Table(name = "CIUDADES")
@Getter
@Setter
public class Ciudad implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CIUDADES")
	@SequenceGenerator(name = "SEQ_CIUDADES", sequenceName = "SEQ_CIUDADES", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_CIUDAD_PK", nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE_CIUDAD")
	private String nombreCiudad;

}

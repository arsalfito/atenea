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
@Table(name = "ESTADOS_ACTIVOS")
@Getter
@Setter
public class EstadoActivo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADOS_ACTIVOS")
	@SequenceGenerator(name = "SEQ_ESTADOS_ACTIVOS", sequenceName = "SEQ_ESTADOS_ACTIVOS", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_ESTADO_ACTIVO_PK", nullable = false)
	private Integer id;
	
	
	@Column(name = "ESTADO_ACTIVO", nullable = false)
	private String estadoActivo;

}

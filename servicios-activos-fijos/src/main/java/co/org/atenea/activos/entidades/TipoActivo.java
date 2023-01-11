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
@Table(name = "TIPOS_ACTIVOS")
@Getter
@Setter
public class TipoActivo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_ACTIVOS")
	@SequenceGenerator(name = "SEQ_TIPO_ACTIVOS", sequenceName = "SEQ_TIPO_ACTIVOS", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_TIPO_ACTIVO_PK", nullable = false)
	private Integer id;
	
	
	@Column(name = "TIPO_ACTIVO", nullable = false)
	private String tipoActivo;

}

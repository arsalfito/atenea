/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_RESPONSABLE", discriminatorType = DiscriminatorType.STRING )
@Table(name="RESPONSABLES")
@Getter
@Setter
public class Responsable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESPONSABLES")
	@SequenceGenerator(name = "SEQ_RESPONSABLES", sequenceName = "SEQ_RESPONSABLES", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_RESPONSABLE_PK", nullable = false)
	private	Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private	String nombre;
	
	@Column(name = "TIPO_RESPONSABLE", insertable = false, updatable = false)
	private String TIPO_RESPONSABLE;


}

/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Table(name = "CATACTERISTICAS_ACTIVOS")
@Getter
@Setter
public class CaracteristicaActivo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATACTERISTICAS_ACTIVOS")
	@SequenceGenerator(name = "SEQ_CATACTERISTICAS_ACTIVOS", sequenceName = "SEQ_CATACTERISTICAS_ACTIVOS", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_CARACTERISTICA_ACTIVO_PK", nullable = false)
	private Long id;
	
	@Column(name = "PESO")
	private Float peso;
	
	@Column(name = "ALTO")
	private Float alto;
	
	@Column(name = "ANCHO")
	private Float ancho;
	
	@Column(name = "LARGO")
	private Float largo;
	
	@Column(name = "COLOR")
	private String color;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_ACTIVO_FIJO_FK", nullable = true)
	private ActivoFijo activoFijo;
}


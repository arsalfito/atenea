/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Table(name = "ACTIVOS_FIJOS")
@Getter
@Setter
public class ActivoFijo implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVOS_FIJOS")
	@SequenceGenerator(name = "SEQ_ACTIVOS_FIJOS", sequenceName = "SEQ_ACTIVOS_FIJOS", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_ACTIVO_FIJO_PK", nullable = false)
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "SERIAL", nullable = false, unique = true)
	private String serial;
	
	@Column(name = "NUMERO_INTERNO_INVENTARIO", nullable = false)
	private String numeroInternoInventario;
	
	@Column(name = "VALOR_COMPRA", nullable = false)
	private Double valorCompra;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_COMPRA", nullable = false)	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "COT")
	private Date fechaCompra;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_BAJA", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "COT")
	private Date fechaBaja;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_ACTIVO_FK", nullable = false)
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
	private TipoActivo tipoActivo;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "activoFijo")
	@JsonIgnoreProperties(value = {"activoFijo"}, allowSetters=true)
	private CaracteristicaActivo caracteristicaActivo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_ACTIVO_FK", nullable = false)
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
	private EstadoActivo estadoActual;
	
}

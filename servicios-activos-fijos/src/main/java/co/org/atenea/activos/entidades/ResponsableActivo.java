/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Table( name = "RESPONSABLES_ACTIVOS" )
@AssociationOverrides( value = { 
	@AssociationOverride( name = "pk.responsable", joinColumns = @JoinColumn( name = "ID_RESPONSABLE_PK" ) ),
	@AssociationOverride( name = "pk.activoFijo", joinColumns = @JoinColumn( name = "ID_ACTIVO_FIJO_PK" ) )
})
@Getter
@Setter
public class ResponsableActivo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ResponsableActivoPK pk = new ResponsableActivoPK();
	
	@Column(name = "FECHA_ASIGNACION", nullable = false)
	private Date fechaAsignacion;
	
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;

}

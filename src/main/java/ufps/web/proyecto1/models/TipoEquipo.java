package ufps.web.proyecto1.models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipo_equipo database table.
 * 
 */
@Entity
@Table(name="tipo_equipo")
@NamedQuery(name="TipoEquipo.findAll", query="SELECT t FROM TipoEquipo t")
public class TipoEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private int idTipo;

	private String descripcions;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="tipoEquipo")
	private List<Equipo> equipos;

	public TipoEquipo() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcions() {
		return this.descripcions;
	}

	public void setDescripcions(String descripcions) {
		this.descripcions = descripcions;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setTipoEquipo(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setTipoEquipo(null);

		return equipo;
	}

}
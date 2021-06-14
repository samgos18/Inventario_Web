package ufps.web.proyecto1.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import java.util.Date;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "El seria no debe estar vacio y debe ser unico")
	private String serial;

	@NotBlank(message = "Digite un color")
	private String color;

	private byte donado;

	private boolean disponible;
	
	private String foto;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@NotBlank(message = "La marca no puede ser vacia")
	private String marca;

	@NotBlank(message = "EL nombre no debe ser vacio")
	private String nombre;

	@Min(value = 0)
	private int precio;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TipoEquipo
	@ManyToOne
	@JoinColumn(name="id_tipo_equipo")
	private TipoEquipo tipoEquipo;

	public Equipo() {
	}

	
	
	public boolean isDisponible() {
		return disponible;
	}



	public String getFoto() {
		return foto;
	}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}



	public void setFoto(String foto) {
		this.foto= foto;
	}



	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public byte getDonado() {
		return this.donado;
	}

	public void setDonado(byte donado) {
		this.donado = donado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoEquipo getTipoEquipo() {
		return this.tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

}
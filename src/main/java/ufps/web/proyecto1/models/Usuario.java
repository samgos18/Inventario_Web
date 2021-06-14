package ufps.web.proyecto1.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "la cedula no debe ser vacia")
	private String cedula;

	@NotBlank(message = "el apelldio no debe ser vacia")
	private String apellido;

	@NotBlank(message = "la direccion no debe ser vacia")
	private String direccion;

	@NotBlank(message = "el email nombe ser vacio")
	@Email(message = "Debe ser de tipo email")
	private String email;

	@NotBlank(message = "el nombre no puede ser vacio")
	private String nombre;

	@NotBlank(message = "el password no debe ser vacio")
	@Size(min = 5,message = "La antidad minima de caracteres debe ser de 5")
	private String password;

	private String rol;

	@NotBlank(message = "el telefono no debe ser vacio")
	private String telefono;

	private String token;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="usuario")
	private List<Equipo> equipos;

	public Usuario() {
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setUsuario(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setUsuario(null);

		return equipo;
	}

}
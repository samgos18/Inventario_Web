package ufps.web.proyecto1.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the baja database table.
 * 
 */
@Entity
@NamedQuery(name="Baja.findAll", query="SELECT b FROM Baja b")
public class Baja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_baja")
	private int idBaja;

	private byte aprobada;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Baja() {
	}

	public int getIdBaja() {
		return this.idBaja;
	}

	public void setIdBaja(int idBaja) {
		this.idBaja = idBaja;
	}

	public byte getAprobada() {
		return this.aprobada;
	}

	public void setAprobada(byte aprobada) {
		this.aprobada = aprobada;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
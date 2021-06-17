package ufps.web.proyecto1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ufps.web.proyecto1.models.Equipo;

public interface IEquipoDao extends CrudRepository<Equipo, String> {

	@Query("select e from Equipo e join fetch e.usuario u where u.cedula=?1 and e.bajaAceptada=?2")
	public List<Equipo> listarByResponsableAndBaja(String cedula, boolean baja);

	@Query("select e from Equipo e join fetch e.usuario u where u.cedula=?1 and e.serial=?2")
	public Equipo listarByResponsableAndBajaAndId(String cedula, String serial);

	@Query("select e from Equipo e where e.bajaSolicitada=?1 and bajaAceptada=false")
	public List<Equipo> EquipoByBajaSolicitada(boolean baja);

	@Query("select e from Equipo e where bajaAceptada=false")
	public List<Equipo> EquipoEliminables();
}

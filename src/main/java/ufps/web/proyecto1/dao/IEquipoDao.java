package ufps.web.proyecto1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ufps.web.proyecto1.models.Equipo;



public interface IEquipoDao extends CrudRepository<Equipo, String>{

	@Query("select e from Equipo e join fetch e.usuario u where u.cedula=?1")
	public List<Equipo> listarByResponsable(String cedula);
}

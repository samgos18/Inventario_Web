package ufps.web.proyecto1.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ufps.web.proyecto1.models.Marca;

public interface IMarcaDao extends CrudRepository<Marca, Integer> {

	@Query("select m from Marca m where m.nombre=?1")
	public Marca findByNombre(String nombre);

}
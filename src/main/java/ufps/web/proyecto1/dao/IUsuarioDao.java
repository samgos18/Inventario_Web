package ufps.web.proyecto1.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ufps.web.proyecto1.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, String> {

	@Query("select u from Usuario u where u.email=?1")
	public Usuario findByEmail(String email);
}

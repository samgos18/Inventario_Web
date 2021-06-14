package ufps.web.proyecto1.dao;

import org.springframework.data.repository.CrudRepository;

import ufps.web.proyecto1.models.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario, String>{

}

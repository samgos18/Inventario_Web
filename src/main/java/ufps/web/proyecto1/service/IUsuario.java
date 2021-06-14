package ufps.web.proyecto1.service;


import java.util.List;

import ufps.web.proyecto1.models.Equipo;
import ufps.web.proyecto1.models.Marca;
import ufps.web.proyecto1.models.TipoEquipo;
import ufps.web.proyecto1.models.Usuario;

public interface IUsuario {

	public Usuario findById(String id);
	public Usuario save(Usuario user);
	public boolean delete(String id);
	public List<Usuario> findAll();
	public List<Marca> findAllMarcas();
	public List<TipoEquipo> findAllTipoEquipo();
	public Marca findByNombre(String nombre);
	public TipoEquipo findTipoEquipoById(int id);
	
	public List<Equipo>findAllEquipo();
	public Equipo findEquipoById(String id);
	public Equipo saveEquipo(Equipo equipo);
	public List<Equipo>findAllEquipoByResponsable(String cedula);
}

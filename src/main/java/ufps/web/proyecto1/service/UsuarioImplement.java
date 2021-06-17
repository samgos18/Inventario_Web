package ufps.web.proyecto1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufps.web.proyecto1.dao.IEquipoDao;
import ufps.web.proyecto1.dao.IMarcaDao;
import ufps.web.proyecto1.dao.ITipoEquipoDao;
import ufps.web.proyecto1.dao.IUsuarioDao;
import ufps.web.proyecto1.models.Equipo;
import ufps.web.proyecto1.models.Marca;
import ufps.web.proyecto1.models.TipoEquipo;
import ufps.web.proyecto1.models.Usuario;

@Service
public class UsuarioImplement implements IUsuario {

	@Autowired
	IUsuarioDao user;

	@Autowired
	IMarcaDao marca;

	@Autowired
	ITipoEquipoDao tipo;

	@Autowired
	IEquipoDao equipo;

	@Override
	public Usuario findById(String id) {

		return user.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario user) {

		return this.user.save(user);
	}

	@Override
	public boolean delete(String id) {
		try {
			this.user.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) user.findAll();
	}

	@Override
	public List<Marca> findAllMarcas() {
		return (List<Marca>) this.marca.findAll();
	}

	@Override
	public List<TipoEquipo> findAllTipoEquipo() {
		// TODO Auto-generated method stub
		return (List<TipoEquipo>) this.tipo.findAll();
	}

	@Override
	public Marca findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.marca.findByNombre(nombre);
	}

	@Override
	public TipoEquipo findTipoEquipoById(int id) {
		return tipo.findById(id).orElse(null);
	}

	@Override
	public Equipo findEquipoById(String id) {
		// TODO Auto-generated method stub
		return equipo.findById(id).orElse(null);
	}

	@Override
	public Equipo saveEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return this.equipo.save(equipo);
	}

	@Override
	public List<Equipo> findAllEquipo() {
		// TODO Auto-generated method stub
		return (List<Equipo>) this.equipo.findAll();
	}

	@Override
	public List<Equipo> findAllEquipoByResponsable(String cedula, boolean baja) {
		// TODO Auto-generated method stub
		return this.equipo.listarByResponsableAndBaja(cedula, baja);
	}

}

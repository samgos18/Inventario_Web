package ufps.web.proyecto1.controllers;

import java.io.IOException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufps.web.proyecto1.models.Equipo;
import ufps.web.proyecto1.models.Marca;
import ufps.web.proyecto1.models.TipoEquipo;
import ufps.web.proyecto1.models.Usuario;
import ufps.web.proyecto1.service.IUploadService;
import ufps.web.proyecto1.service.IUsuario;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdministradorController {

	@Autowired
	IUsuario service;
	
	@Autowired
	IUploadService upload;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping({"","/"})
	public String index(Authentication auth,Model model) {
		
		Usuario user=this.service.findById(auth.getName());
		model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
		return "admin/administrador";
	}
	
	@GetMapping("/register-responsable")
	public String registerResponsable(Authentication auth,Model model) {
		Usuario user=this.service.findById(auth.getName());
		model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
		
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		return "admin/Registro_Responsable";
	}
	
	@PostMapping("/registrar-usuario")
	public String save(Model model,@Valid Usuario usuario,BindingResult result,Authentication auth,RedirectAttributes flash,SessionStatus status) {
		 if(result.hasErrors()) {
			 
			Usuario user=this.service.findById(auth.getName());
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			 return "admin/Registro_Responsable";
		 }
		 
		 usuario.setPassword(encoder.encode(usuario.getPassword()));
		this.service.save(usuario);
		System.out.println("usuario guardado");
		status.setComplete();
		flash.addFlashAttribute("mensaje", "Usuario creado exitosamente");
		
		return "redirect:/admin";
	}
	
	@GetMapping("/registrar-equipo")
	public String showForEquipo(Model model,Authentication auth) {
		Usuario user=this.service.findById(auth.getName());
		Equipo equipo =new Equipo();
		model.addAttribute("equipo", equipo);
		model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
		model.addAttribute("usuarios",this.service.findAll());
		model.addAttribute("marcas", this.service.findAllMarcas());
		model.addAttribute("tipos", this.service.findAllTipoEquipo());
		return "admin/registrar-equipo";
		
	}
	
	@PostMapping("/save-equipo")
	public String guardarEquipo(@Valid Equipo equipo,BindingResult result,Authentication auth,Model model,
			@RequestParam int tipoEquipo,@RequestParam int donado,
			@RequestParam String responsables,@RequestParam MultipartFile archivo,SessionStatus status,RedirectAttributes flash) {
		Usuario user=this.service.findById(auth.getName());
		
		if(result.hasErrors()) {
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			
			return "admin/registrar-equipo";
		}
		Equipo equ=this.service.findEquipoById(equipo.getSerial());
		
		if(equ!=null) {
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			model.addAttribute("existe", "ya existe un equipo con ese seria");
		}
		
		Marca marca=this.service.findByNombre(equipo.getMarca());
		if(marca==null) {
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			model.addAttribute("mar", "la marca digitada no coincidide con ninguna en la bd");
			
			return "admin/registrar-equipo";
		}
		
		TipoEquipo tipo=this.service.findTipoEquipoById(tipoEquipo);
		
		if(tipo==null) {
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			model.addAttribute("tip", "El tipo de equipo no se encuentra en la bd");
			
			return "admin/registrar-equipo";
		}
		
		if(donado==1) {
			equipo.setDonado((byte) 1);
			equipo.setPrecio(0);
		}else {
			
			if(equipo.getPrecio()<=0) {
				
				model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
				model.addAttribute("usuarios",this.service.findAll());
				model.addAttribute("marcas", this.service.findAllMarcas());
				model.addAttribute("tipos", this.service.findAllTipoEquipo());
				model.addAttribute("price", "si el equipo no es donado debe dar un precio");
				
				return "admin/registrar-equipo";
			}
			
			
		}
		
		Usuario responsable=this.service.findById(responsables);
		
		if(responsable==null || responsable.getRol().equals("ROLE_ADMIN")) {
			
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			model.addAttribute("user", "el responsable no existe o es un administrador");
			
			return "admin/registrar-equipo";
		}
		
		if(archivo.isEmpty()) {
			
			model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
			model.addAttribute("usuarios",this.service.findAll());
			model.addAttribute("marcas", this.service.findAllMarcas());
			model.addAttribute("tipos", this.service.findAllTipoEquipo());
			model.addAttribute("arch", " seleccione un imagen para el equipo");
			
			return "admin/registrar-equipo";
			
		}
		
		try {
			
			equipo.setFecha(new Date());
			equipo.setDisponible(true);
			equipo.setTipoEquipo(tipo);
			equipo.setUsuario(responsable);
			equipo.setFoto(this.upload.copy(archivo));
			
			this.service.saveEquipo(equipo);
			status.setComplete();
		} catch (IOException e) {
		
			flash.addFlashAttribute("error", "no se pudo crear el equipo");
			e.printStackTrace();
			return "redirect:/admin/";
		}
		
		flash.addFlashAttribute("mensaje", "equipo agregado correctamente");
		return "redirect:/admin";
	}
	
	@GetMapping("/listar")
	public String listarEquipos(Model model,Authentication auth) {
		Usuario user=this.service.findById(auth.getName());
		model.addAttribute("nombre", (user.getNombre()+" "+user.getApellido()).toUpperCase());
		model.addAttribute("equipos", this.service.findAllEquipo());
		return "admin/consultar";
	}
}

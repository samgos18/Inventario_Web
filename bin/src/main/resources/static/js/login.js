document.querySelector('#btningresar').addEventListener('click', iniciarSesion);

function iniciarSesion() {
	var usuario = '';
	var contraseña = '';
	var bAcceso = false;

	usuario = document.querySelector('#usuario').value;
	contraseña = document.querySelector('#contraseña').value;

	bAcceso = validarCredenciales(usuario, contraseña);

	if (bAcceso == true) {

		ingresar();
	}
}

function ingresar() {

	var rol = sessionStorage.getItem('rolActivo');

	switch (rol) {

		case '1':
			window.location.href = "html/administrador.html";
			break;
			/*default:
			window.location.href ="index.html";
			break;*/
	}
}
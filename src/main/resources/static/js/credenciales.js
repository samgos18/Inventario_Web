/*
 Roles:
 1=Admin
 2=Usuario
*/
function obtenerUsuario() {
	var listaUsuarios = JSON.parse(localStorage.getItem('listaUsuarios'));

	if (listaUsuarios == null) {
		listaUsuarios =

			[
				['1', 'jose', 'moncada', 'jose@gmail.com', 'jose123', '1'],
			]
	}
	return listaUsuarios;
}

function validarCredenciales(pcorreo, pcontraseña) {
	var listaUsuarios = obtenerUsuario();
	var bAcceso = false;

	for (var i = 0; i < listaUsuarios.length; i++) {
		if (pcorreo == listaUsuarios[i][3] && pcontraseña == listaUsuarios[i][4]) {
			bAcceso = true;
			sessionStorage.setItem('usuarioActivo', listaUsuarios[i][1] + ' ' + listaUsuarios[i][2]);
			sessionStorage.setItem('rolActivo', listaUsuarios[i][5]);
		}
	}
	return bAcceso;
}
/**
Funciones de CRUD - Eliminar y Modificar 
**/
function eliminar(p_id){
	window.location.href="/appwebcrud/ServletEliminar?id="+p_id;
}

function editar(p_id){
	window.location.href="/appwebcrud/ServletActualizar?id="+p_id;
}
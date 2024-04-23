package examen.vista;

import java.util.List;

import examen.controladores.ControladorContrato;
import examen.controladores.ControladorTipoContrato;
import examen.controladores.ControladorUsuario;
import examen.entidades.Contrato;
import examen.entidades.TipoContrato;
import examen.entidades.Usuario;

public class DatosDeTabla {

	/**
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] { "Id", "Descripción", "Saldo", "Límite", "Fecha Firma", "IdTipoContrato", "IdUsuario" };
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todos los contratos.
		List<Contrato> contratos = (List<Contrato>) ControladorContrato.getInstance().findAll();

		// Obtengo todos los usuarios.
		List<Usuario> usuarios = (List<Usuario>) ControladorUsuario.getInstance().findAll();

		// Obtengo todos los usuarios.
		List<TipoContrato> tiposContrato = (List<TipoContrato>) ControladorTipoContrato.getInstance().findAll();

		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][7];
		// Cargo los datos de la lista de estudiantes en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Contrato cont = contratos.get(i);
			datos[i][0] = cont.getId();
			datos[i][1] = cont.getDescripcion();
			datos[i][2] = cont.getSaldo();
			datos[i][3] = cont.getLimite();
			datos[i][4] = cont.getFechaFirma();

			// Si coinciden los id, guardo el nombre Usuario.
			for (Usuario o : usuarios) {
				if (o.getId() == cont.getIdUsuario()) {
					datos[i][5] = o.getNombreUsuario();
				}
			}

			// Igual tipo de contrato
			for (TipoContrato t : tiposContrato) {
				if (t.getId() == cont.getIdTipoContrato()) {
					datos[i][6] = t.getDescripcion();
				}
			}

		}

		return datos;
	}

}

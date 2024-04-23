package examen.controladores;

import javax.persistence.EntityManager;

import examen.entidades.TipoContrato;
import examen.entidades.Usuario;

public class ControladorUsuario extends SuperControladorJPA {

	private static ControladorUsuario instance = null;
	
	/**
	 * 
	 */
	public ControladorUsuario() {
		super("usuario", Usuario.class);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public void updateUsuario (Usuario p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	
	
}

package examen.controladores;

import javax.persistence.EntityManager;

import examen.entidades.Contrato;
import examen.entidades.TipoContrato;

public class ControladorTipoContrato extends SuperControladorJPA{

	private static ControladorTipoContrato instance = null;
	
	public ControladorTipoContrato() {
		super("tipocontrato", TipoContrato.class);
	}
	
	
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipoContrato getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public void updateTipoContrato (TipoContrato p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	
}

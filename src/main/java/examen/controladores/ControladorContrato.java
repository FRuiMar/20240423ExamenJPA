package examen.controladores;

import javax.persistence.EntityManager;

import examen.entidades.Contrato;

public class ControladorContrato extends SuperControladorJPA {

	private static ControladorContrato instance = null;
	
	
	public ControladorContrato() {
		super("contrato", Contrato.class);
	}
	
	
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public void updateContrato (Contrato p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
}

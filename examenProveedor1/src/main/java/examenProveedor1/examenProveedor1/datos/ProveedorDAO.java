package examenProveedor1.examenProveedor1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import examenProveedor1.examenProveedor1.modelo.Producto;
import examenProveedor1.examenProveedor1.modelo.Proveedor;

@Stateless
public class ProveedorDAO {
	@Inject
	private EntityManager em;
	
	public ProveedorDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertarProveedor(Proveedor p) {
		em.persist(p);
		return true;
	}
	public List<Proveedor> obtenerProveedor(){
		String jpql = "Select c from Proveedor c";
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();

	}
}

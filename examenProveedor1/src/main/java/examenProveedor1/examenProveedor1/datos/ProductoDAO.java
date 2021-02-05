package examenProveedor1.examenProveedor1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import examenProveedor1.examenProveedor1.modelo.Producto;

@Stateless
public class ProductoDAO {
	@Inject
	private EntityManager em;

	public ProductoDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insertarProducto(Producto producto) {
		em.persist(producto);
		return true;
	}

	public List<Producto> obtenerProductos() {
		String jpql = "Select c from Producto c";
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();

	}

	public String actualizarStock(int stock, int nombre) {
		Query query = em.createQuery("UPDATE producto   SET stock=:valor WHERE nombre=:codigo");
		query.setParameter("valor", stock);
		query.setParameter("codigo", nombre);
		System.out.println("query" + query); // int result =
		query.executeUpdate();
		return null;

	}
	public List<Producto> listadoProductoCodigo(int codigo){
		@SuppressWarnings("unchecked")
		List<Producto> resultadoCuentas = em.createNativeQuery(
				"select producto.codigo, producto.nombre, producto.stock, provedor.nombre from producto join provedor on producto.proveedor_fk =:proveedor",
				Producto.class).setParameter("proveedor", codigo).getResultList();
		System.out.println("RESULTADO DEL QUERY "+ resultadoCuentas);
		return resultadoCuentas;
		
	}
}

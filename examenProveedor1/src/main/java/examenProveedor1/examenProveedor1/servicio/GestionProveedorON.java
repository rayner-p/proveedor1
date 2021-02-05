package examenProveedor1.examenProveedor1.servicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import examenProveedor1.examenProveedor1.datos.ProductoDAO;
import examenProveedor1.examenProveedor1.datos.ProveedorDAO;
import examenProveedor1.examenProveedor1.modelo.Producto;
import examenProveedor1.examenProveedor1.modelo.Proveedor;

@Stateless
public class GestionProveedorON implements GestionProveedorLocale {
	@Inject
	private ProveedorDAO daoProveedor;
	@Inject
	private ProductoDAO daoProducto;

	public void registrarProducto(Producto producto) throws Exception {
		try {
			if (producto == null) {
				System.out.println("prodcuto nulo");
			} else {
				daoProducto.insertarProducto(producto);
				System.out.println("insertado");
			}
		} catch (Exception e) {
			throw new Exception("Error al momento de insertar producto on" + e.getLocalizedMessage());
		}
	}
	
	public void registrarProveedor(Proveedor proveedor) throws Exception {
		try {
			if (proveedor == null) {
				System.out.println("proveedor nulo");
			} else {
				daoProveedor.insertarProveedor(proveedor);
				System.out.println("insertado");
			}
		} catch (Exception e) {
			throw new Exception("Error al momento de insertar proveedor on" + e.getLocalizedMessage());
		}
	}
	
	public String actualizarStock(int stock, int nombre) {
		try {
			
			if(stock==0 & nombre ==0) {
				System.out.println("Valores nulos");
			}else {
				daoProducto.actualizarStock(stock, nombre);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Producto> obtenerProductos() throws Exception{
		try {
			List<Producto> lstProducto= daoProducto.obtenerProductos();
			return lstProducto;
		}catch (Exception e) {
			throw new Exception("Error al momento de insertar proveedor on" + e.getLocalizedMessage());

		}	
	}
	
	public List<Proveedor> obtenerProveedor() throws Exception{
		try {
			List<Proveedor> lstProducto= daoProveedor.obtenerProveedor();
			return lstProducto;
		}catch (Exception e) {
			throw new Exception("Error al momento de insertar proveedor on" + e.getLocalizedMessage());

		}	
	}
	public List<Producto> listadoProductoCodigo(int codigo){
		List<Producto> produc = daoProducto.listadoProductoCodigo(codigo);
		System.out.println("producto"+" "  + produc);
		return produc;
	}
}

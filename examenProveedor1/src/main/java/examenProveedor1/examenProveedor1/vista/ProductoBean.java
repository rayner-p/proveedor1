package examenProveedor1.examenProveedor1.vista;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import examenProveedor1.examenProveedor1.modelo.Producto;
import examenProveedor1.examenProveedor1.servicio.GestionProveedorLocale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProveedorLocale on;
	private Producto newProducto;
	private int newStock;
	private List<Producto> lstProducto;

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public int getNewStock() {
		return newStock;
	}

	public void setNewStock(int newStock) {
		this.newStock = newStock;
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	@PostConstruct
	public void init() {
		newProducto = new Producto();
		lstProducto = new ArrayList<Producto>();
		try {
			listarProductos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registrarProducto() throws Exception {
		try {
			on.registrarProducto(newProducto);
			System.out.println("REGISTRADO");
		} catch (Exception e) {
			throw new Exception("Error al insertar producto" + e.getLocalizedMessage());
		}
	}

	public void listarProductos() throws Exception {
		try {
			if (on.obtenerProductos() == null) {
				System.out.println("lista nula");
			} else {
				lstProducto = on.obtenerProductos();
			}
		} catch (Exception e) {
			throw new Exception("Error al listar producto" + e.getLocalizedMessage());

		}
	}

	public boolean actualizarStock() throws Exception {
		boolean bandera = true;
		try {
			if (newStock == 0) {
				System.out.println("STOCK EN 0");
			} else {
				System.out.println("a actualizar" + " " + newStock + " " + newProducto.getNombre());
				on.actualizarStock(newStock, newProducto.getCodigo());
				System.out.println("DONE!");
			}

		} catch (Exception e) {
			bandera = false;
			throw new Exception("Error al actualizar el producto" + e.getLocalizedMessage());

		}
		return bandera;
	}
}

/**
 *
 */
package model;

/**
 * @author YordanFelipeArenas
 * @author DanielGarzon
 *
 *
 */
import java.util.ArrayList;
import java.util.Objects;

import execeptions.AdministradorException;
import execeptions.ProductoException;
import execeptions.VendedorException;




public class Red {


	private String nombre;
	private ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
	private ArrayList <Producto> listaProductos = new ArrayList<Producto>();



	public Red(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList <Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList <Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList <Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList <Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}




	@Override
	public int hashCode() {
		return Objects.hash(listaProductos, listaUsuarios, nombre);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Red other = (Red) obj;
		return Objects.equals(listaProductos, other.listaProductos)
				&& Objects.equals(listaUsuarios, other.listaUsuarios) && Objects.equals(nombre, other.nombre);
	}




	@Override
	public String toString() {
		return "Red [nombre=" + nombre + ", listaUsuarios=" + listaUsuarios + ", listaProductos=" + listaProductos
				+ "]";
	}



	//-----//CRUD VENDEDOR//-----

	/**
	 * ESTE METODO NOS AYUDA A CREAR UN VENDEDOR
	 * @param nuevoVendedor
	 * @return
	 */
	public String crearVendedor( Vendedor nuevoVendedor) {
		String mensaje = "";
		try {
			verificarVendedor(nuevoVendedor.getNombre(), nuevoVendedor.getCedula());
			listaUsuarios.add(nuevoVendedor);
			mensaje = "Vendedor fue creado exitosamente";

		} catch (VendedorException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}


	/**
	 * ESTE METODO NOS AYUDA PARA VERIFICAR SI UN VENDEDOR EXITSE
	 * @param nombre
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	private Vendedor verificarVendedor(String nombre, String cedula) throws VendedorException {

		Vendedor vendedorVerif = null;
		for(Usuario vendedor : listaUsuarios) {
			if(vendedor instanceof Vendedor) {
				if(vendedor.getNombre().equals(nombre)&& vendedor.getCedula().equals(cedula)) {
					vendedorVerif = (Vendedor) vendedor;
					throw new VendedorException ("El vendedor ya existe");
				}
			}
		}
		return vendedorVerif;
	}



	/**
	 * ESTE METODO NOS PERMITE BUSCAR A UN VENDEDOR
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	public Vendedor buscarVendedor(String cedula) throws VendedorException {

		Vendedor vendedorEncon = null;
		for(Usuario vendedor : listaUsuarios) {
			if(vendedor instanceof Vendedor) {
				if(vendedor != null && vendedor.getCedula().equals(cedula)) {
					vendedorEncon = (Vendedor) vendedor;
					break;
				}
			}
		}
		if(vendedorEncon == null) {
			throw new VendedorException ("No fue posible encontrar el vendedor");
		}
		return vendedorEncon;
	}


	/**
	 * ESTE METODO NOS SRIVE PARA ACTUALIZAR A UN VENDEDOR
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @return
	 * @throws VendedorException
	 */
	public String actualizarVendedor(String nombre, String apellido, String cedula, String direccion) throws VendedorException {
		String mensaje = "";
		Vendedor vendedorAct = null;

		for(Usuario vendedor : listaUsuarios) {
			if(vendedor instanceof Vendedor) {
				if(vendedor.getCedula().equals(cedula)) {
					vendedorAct = (Vendedor) vendedor;
					vendedorAct.setApellidos(apellido);
					vendedorAct.setNombre(nombre);
					vendedorAct.setDireccion(direccion);
					mensaje = "Vendedor actualizado correctamente";
					break;
				}else {
					throw new VendedorException ("No fue posible actualizar el vendedor");
				}
			}
		}
		return mensaje;
	}


	/**
	 * ESTE METODO NOS AYUDA A ELIMINAR UN VENDEDOR DESEADO
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	public String eliminarVendedor(String cedula) throws VendedorException  {
		String mensaje = "";
		Vendedor vendedorEli = null;
		for(Usuario vendedor : listaUsuarios) {
			if(vendedor instanceof Vendedor) {
				if(vendedor.getCedula().equals(cedula)) {
					vendedorEli = (Vendedor) vendedor;
					listaUsuarios.remove(vendedorEli);
					mensaje = "Vendedor eliminado con exito";
					break;
				}else {
					throw new VendedorException ("No fue posible eliminar el vendedor");
				}
			}
		}
		return mensaje;
	}



	//--------//CRUD ADMINISTRADOR//---------


	/**
	 * ESTE METODO ES PARA CREAR UN ADMINISTRADOIR
	 * @param newAdministrador
	 * @return
	 */
	public String crearAdministrador( Administrador nuevoAdministrador) {

		String mensaje = "Administrador Creado";
		Administrador Administrador = null;
		try {
			Administrador  = verificarAdministrador(nuevoAdministrador.getNombre());
			listaUsuarios.add(nuevoAdministrador);
		}
		catch (AdministradorException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}


	/**
	 * ESTE METODO NOS AYUDA A VERIFICAR SI UN ADMINISTRADOR EXISTE
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	private Administrador verificarAdministrador(String cedula) throws AdministradorException {

		Administrador administradorVerificado= null;
		for(Usuario administrator : listaUsuarios) {
			if(administrator instanceof Administrador) {
				if(administrator.getCedula().equals(cedula)) {
					administradorVerificado = (Administrador) administrator;

				}else {
					throw new AdministradorException ("El administrador ya existe");
				}
			}
		}
		return  administradorVerificado;

	}

	/**
	 * ESTE METODO NOS AYUDA A ENCONTRAR UN ADMINISTRADOR
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	public Administrador buscarAdministrador(String cedula) throws AdministradorException {

		Administrador administradorEncon = null;
		for(Usuario administrator : listaUsuarios) {
			if(administrator instanceof Administrador) {
				if(administrator.getCedula().equals(cedula)) {
					administradorEncon = (Administrador) administrator;
				}
			}
		}if(administradorEncon == null) {
			throw new AdministradorException ("No fue posible encontrar el administrador");
		}
		return administradorEncon ;
	}

	/**
	 *  ESTE METODO NOS AYUDA A ACTUALIZAR UN ADMINISTRADOR
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param direccion
	 * @return
	 * @throws AdministradorException
	 */
	public String actualizarAdministrador(String nombre, String apellido, String cedula, String direccion) throws AdministradorException {

		String mensaje = "Administrador actualizado con exito";
		Administrador administrador = null;

		for(Usuario administrator : listaUsuarios) {
			if(administrator instanceof Administrador) {
				if(administrator.getCedula().equals(cedula)) {
					administrador = (Administrador) administrator;
					administrador.setApellidos(apellido);
					administrador.setDireccion(direccion);
					administrador.setNombre(nombre);
					break;
				}else {
					throw new AdministradorException ("No fue posible actualizar el administrador");
				}
			}
		}
		return mensaje;
	}

	/**
	 * ESTE METODO PERMITE ELIMINAR UN ADMINISTRADOR
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	public String eliminarAdministrador(String cedula) throws AdministradorException{
		String mensaje = "El administrador fue eliminado";
		Administrador administradorObtenido = buscarAdministrador(cedula);

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if(administradorObtenido.equals(listaUsuarios.get(i))) {
				listaUsuarios.add(i, null);
			}
		}
		if(administradorObtenido == null) {
			throw new AdministradorException("El administrador no existe");
		}
		return mensaje;
	}


	//----//CRUD PRODUCTO//----
	/**
	 * ESTE METODO NOS PERMITE CREAR UN PRODUCTO
	 * @param nuevoProducto
	 * @return
	 */
	public String crearProducto(Producto nuevoProducto) {

		String mensaje = "";


		try{
			 verificarProducto(nuevoProducto.getCodigo());
			listaProductos.add(nuevoProducto);
			mensaje = "Producto creado con exito";

		}catch (ProductoException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}


	/**
	 * ESTE METODO NOS PERMITE VERIFICAR SI UN PRODUCTO YA EXISTE
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */

	private Producto verificarProducto(String codigo) throws ProductoException {

		Producto productoVerif = null;
		for(Producto producto : listaProductos) {
			if(producto != null && producto.getCodigo().equals(codigo)) {
				productoVerif = producto;
				throw new ProductoException("No fue posible verificar el producto");
			}
		}

		return productoVerif;
	}


	/**
	 * ESTE METODO NOS PERIMITE PODER BUSCAR UN PRODUCTO POR MEDIO DEL CODIGO
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */
	private Producto buscarProducto(String codigo) throws ProductoException {

		Producto productoEncontrado = null;
		for(Producto producto : listaProductos) {
			if(producto != null && producto.getCodigo().equals(codigo)) {
				productoEncontrado = producto;
			}
		}if(productoEncontrado == null) {
			throw new ProductoException("No fue posible encontar el producto");
		}

		return productoEncontrado;
	}


	/**
	 * ESTE METODO NOS PERMITE ACTUALIZAR UN PRODUCTO
	 * @param nombre
	 * @param codigo
	 * @param categoria
	 * @param estado
	 * @return
	 * @throws ProductoException
	 */
	public String actualizarProducto(String nombre, String codigo,Estado estado ,String categoria, double precio) throws ProductoException{
		String mensaje = "El producto fue actualizado correctamente";
		Producto productoObtenido = buscarProducto(codigo);

		for (int i = 0; i< listaProductos.size(); i++) {
			if(productoObtenido.equals(listaProductos.get(i))) {
				(listaProductos.get(i)).setNombre(nombre);
				(listaProductos.get(i)).setCodigo(codigo);
				(listaProductos.get(i)).setCategoria(categoria);
				(listaProductos.get(i)).setEstado(estado);
			}
		}
		if(productoObtenido == null) {
			throw new ProductoException("No fue posible crear el producto");
		}


		return mensaje;
	}

	/**
	 * ESTE METODO ELIMINA EL PRODUCTO DESEADO
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */
	public String eliminarProducto(String codigo) throws ProductoException {
		String mensaje = "";
		Producto productoEliminado = null;
		for(Producto producto : listaProductos) {
			if(producto != null && producto.getCodigo().equals(codigo)) {
				productoEliminado = producto;
				listaProductos.remove(productoEliminado);
				mensaje = "El producto fue eliminado";
				break;
			}else {
				throw new ProductoException ("No fue posible eliminar el producto");
			}
		}

		return mensaje;
	}







}

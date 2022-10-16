/**
 *
 */
package test;

import execeptions.AdministradorException;
import execeptions.ProductoException;
import execeptions.VendedorException;
import junit.framework.TestCase;
import model.Administrador;
import model.Estado;
import model.Producto;
import model.Red;
import model.Vendedor;

/**
 * @author YordanFelipeArenas
 *
 *
 */
public class Test extends TestCase {

	private Red red1;
	Vendedor vendedor21 = new Vendedor("carlos", "lopez", "432 Street", "1028843", null);
	Administrador admin21 = new Administrador("daniel", "gutierrez", "45 Street", "107792321");
	Producto product21 = new Producto("Call of Duty", "23432", Estado.VENDIDO ,"Videojuegos", 230000.0 );


	public void TestRed() {
		red1 = new Red("Red de vendedores");
	}


	//JUnits de Vendedor
	public void testcreateVendedor() {
		TestRed();
		assertTrue(red1.crearVendedor(vendedor21) == "Vendedor Creado exitosamente");


	}


	public void testactualizarVendedor() throws VendedorException {
		TestRed();
		red1.crearVendedor(vendedor21);
		assertTrue(red1.actualizarVendedor("carlos", "alvarez","123456" ,"123 street") == ("Vendedor actualizado"));

	}

	public void testeliminarVendedor() throws VendedorException{
		TestRed();
		red1.crearVendedor(vendedor21);
		assertTrue(red1.eliminarVendedor("124628") ==  ("Vendedor eliminado"));

	}


	// JUnits de Administrador

	public void testCreateAdministrador() {
		TestRed();
		assertTrue(red1.crearAdministrador(admin21) == "Administrador Creado");


	}


	public void testUpdateAdministrador() throws AdministradorException {
		TestRed();
		red1.crearAdministrador(admin21);
		assertTrue(red1.actualizarAdministrador("Nicolas", "Villanueva", "24135", "Cl 34") == "Administrador actualizado");

	}

	public void testdeleteAdministrador() throws AdministradorException{
		TestRed();
		red1.crearAdministrador(admin21);
		assertTrue(red1.eliminarAdministrador("24135") == "Administrador Eliminado");

	}


	// JUnits de Producto

	public void testCreateProducto() {
		TestRed();
		assertTrue(red1.crearProducto(product21) == "Producto creado");


	}

	public void testupdateProducto() throws ProductoException {
		TestRed();
		red1.crearProducto(product21);
		assertTrue(red1.actualizarProducto( "Fifa", "343532", Estado.PUBLICADO ,"Videojuegos", 244000.0) == "Producto Actualizado");

	}

	public void testdeleteProducto() throws ProductoException{
		TestRed();
		red1.crearProducto(product21);
		assertTrue(red1.eliminarProducto("343532") == "Producto eliminado");

	}






}

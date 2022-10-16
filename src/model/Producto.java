/**
 *
 */
package model;

/**
 * @author YordanFelipeArenas
 *
 *
 */

public class Producto {


	private String nombre;
	private String codigo;
	private Estado estado;
	private String categoria;
	private double precio;


	public Producto(String nombre, String codigo, Estado estado, String categoria, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.estado = estado;
		this.categoria = categoria;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", estado=" + estado + ", categoria=" + categoria
				+ ", precio=" + precio + "]";
	}













}
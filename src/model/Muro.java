/**
 *
 */
package model;

/**
 * @author YordanFelipeArenas
 *
 *
 */
import java.util.Objects;

public class Muro {

	private int me_gusta;
	private String mensaje;
	private String comentarios;



	public Muro(String mensaje, String comentarios, int me_gusta) {
		super();
		this.setMensaje(mensaje);
		this.setComentarios(comentarios);
		this.setMe_gusta(me_gusta);
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public int getMe_gusta() {
		return me_gusta;
	}


	public void setMe_gusta(int me_gusta) {
		this.me_gusta = me_gusta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(comentarios, me_gusta, mensaje);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Muro other = (Muro) obj;
		return Objects.equals(comentarios, other.comentarios) && me_gusta == other.me_gusta
				&& Objects.equals(mensaje, other.mensaje);
	}


	@Override
	public String toString() {
		return "Muro [mensaje=" + mensaje + ", comentarios=" + comentarios + ", me_gusta=" + me_gusta + "]";
	}









}
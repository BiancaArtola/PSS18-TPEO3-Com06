package Juego;

import GUI.gui;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import Entidades.*;
import Entidades.Enemigos.Enemigo;

/**
 * 
 * @author 
 *
 */
public class Juego {
	
	private gui gui;
	private Nivel nivel; //Gestor de niveles
	
	private Jugador jugador;
	
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Entidad> entidades;
	
	//Constructor
	public Juego(gui gui) {
		this.gui = gui;
		
		//Creacion de jugador
		jugador = new Jugador(new Point(270, 600));
		gui.add(jugador.getGrafico());
		
		//Creacion del gestor de niveles
		nivel = new Nivel();
		
		entidades = new LinkedList<Entidad>();
		
		//Carga de enemigos
		enemigos = nivel.obtenerEnemigos();
		Iterator<Enemigo> i = enemigos.iterator();
		while(i.hasNext()) {
			gui.add(i.next().getGrafico());
		}	
	}
	
	// Metodos
	
	/**
	 * Devuelve el puntaje acumulado por el jugador en la partida.
	 * @return Puntaje jugador.
	 */
	public int obtenerPuntaje() {
		return jugador.getPuntaje();
	}
	
	/**
	 * Deuelve verdadero si hay enemigos, caso contrario, falso.
	 * @return Verdadero si hay enemigos, caso contrario, falso.
	 */
	public boolean hayEnemigos() {
		return !(enemigos.isEmpty());
	}
	
	/**
	 * Devuelve el jugador de la partida.
	 * @return jugador.
	 */
	public Jugador obtenerJugador() {
		return jugador;		
	}
	
	/**
	 * Devuelve la colección de enemigos.
	 * @return Coleccion de enemigos.
	 */
	public LinkedList<Enemigo> obtenerEnemigos(){
		return enemigos;
	}
	
	/**
	 * Devuelve la colección de entidades.
	 * @return Colección de entidades.
	 */
	public LinkedList<Entidad> obtenerEntidades(){
		return entidades;
	}
	
	/**
	 * Agrega la entidad recibida como parámetro al juego.
	 * @param e Entidad a agregar.
	 */
	public void agregarEntidad(Entidad e) {
		if(e != null) {
			entidades.add(e);
			gui.add(e.getGrafico());
		}
	}
	
	/**
	 * Agrega el enemigo recibido como parámetro al juego.
	 * @param e Enemigo a agregar.
	 */
	public void agregarEnemigo(Enemigo e) {
		if(e != null) {
			enemigos.add(e);
			gui.add(e.getGrafico());
		}
	}
	
	/**
	 * Elimina la entidad del juego.
	 * @param e Entidad a eliminar.
	 */
	public void eliminarEntidad(Entidad e) {
		if (e != null) {
			entidades.remove(e);
			gui.remove(e.getGrafico());
		}
	}
	
	/**
	 * Elimina el enemigo del juego.
	 * @param e Enemigo a eliminar.
	 */
	public void eliminarEnemigo(Enemigo e) {
		if (e != null) {
			enemigos.remove(e);
			gui.remove(e.getGrafico());
		}
	}
	
	//Metodos privados
	
}

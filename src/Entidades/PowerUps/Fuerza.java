package Entidades.PowerUps;

import java.awt.Point;
import javax.swing.ImageIcon;
import Colisionador.ColisionadorPowerUp;
import Hilos.HiloFuerza;

public class Fuerza extends PowerUp{

	public Fuerza(Point p) {
		super(p, 0, 0);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Galaxian/PowerUp/Vida/vida.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Galaxian/PowerUp/Vida/vida.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Galaxian/PowerUp/Vida/vida.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Galaxian/PowerUp/Vida/vida.png"));
		this.imagen[4] = null;
		
		colisionador = new ColisionadorPowerUp(this);
	}

	public void activar() {
		HiloFuerza hF = new HiloFuerza();
		hF.start();
	}
}
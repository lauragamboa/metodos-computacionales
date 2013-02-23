package metodos;

import processing.core.PApplet;

public class Principal extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7314558825277438212L;
	
	private Metas meta;

	public void setup() {
		size(600, 600);
		background(0);
		this.meta = new Metas(this);
	}

	public void draw() {
		meta.escribir();
		meta.mover();
		// println(titulo);
	}

	public void mouseClicked() {
		background(0);
		meta.escribir();
		meta.cambiar();
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "metodos.MyProcessingSketch" });
	}
}

package metodos;

import processing.core.PApplet;
import processing.core.PFont;
import processing.data.XML;

class Metas {

	PApplet parent; // The parent PApplet that we will render ourselves onto

	int posX, posY, i, tamano, vel;
	XML[] XmlMetas;
	XML XmlContenido;
	String titulo, url, tag;
	String[] palab;
	PFont fuente;
	Imagenes imagen;

	Metas(PApplet parent) {
		this.parent = parent;
		posX = parent.width;
		posY = parent.height - 20;
		vel = 15;
		fuente = parent.loadFont("ACaslonPro-BoldItalic-30.vlw");

		url = "http://www.43things.com/rss/goals/popular";
		XmlContenido = parent.loadXML(url);
		XmlMetas = XmlContenido.getChildren("channel/item/title");

		// selección de la meta
		i = (int) parent.random(1, XmlMetas.length);
		titulo = XmlMetas[i].getContent();

		// selección de la palabra para usar como tag
		palab = PApplet.splitTokens(titulo);
		if (palab.length <= 4) {
			tag = palab[palab.length - 1];
		} else {
			tag = palab[palab.length - 2] + " " + palab[palab.length - 1];
		}

		imagen = new Imagenes(this.parent, tag);
	}

	void escribir() {
		parent.background(0);
		parent.fill(255);
		tamano = (int) parent.random(15, 30);
		parent.textFont(fuente, 20);
		parent.text(titulo, posX, posY);
		imagen.pintar();
	}

	void mover() {
		if (posX > titulo.length() * 2) {
			posX = posX - vel;
		} else {
			posX = parent.width;
		}
	}

	void cambiar() {
		posX = parent.width;
		i = (int) parent.random(1, XmlMetas.length);
		titulo = XmlMetas[i].getContent();
		palab = PApplet.splitTokens(titulo);
		if (palab.length <= 4) {
			tag = palab[palab.length - 1];
		} else {
			tag = palab[palab.length - 2] + " " + palab[palab.length - 1];
		}

		imagen = new Imagenes(this.parent, tag);
	}
}
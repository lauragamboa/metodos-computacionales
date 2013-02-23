package metodos;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.data.XML;

public class Imagenes {

	PApplet parent; // The parent PApplet that we will render ourselves onto

	String url;
	XML xml;
	XML[] xmlImagenes;
	String farm, server, secret, id, titulo, urlImagen;
	PImage imagen;
	int i, posX, posY;

	Imagenes(PApplet parent, String tag) {
		this.parent = parent;
		posX = parent.width / 2;
		posY = (parent.height / 2) - 30;
		url = "http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=299409aec549bea23478a576bf09be4b&tags="
				+ tag + "&format=rest";

		xml = parent.loadXML(url);
		XML[] xmlImagenes = xml.getChildren("photos/photo");
		i = (int) parent.random(1, xmlImagenes.length);
		farm = xmlImagenes[i].getString("farm");
		server = xmlImagenes[i].getString("server");
		secret = xmlImagenes[i].getString("secret");
		id = xmlImagenes[i].getString("id");
		titulo = xmlImagenes[i].getString("title");

		urlImagen = "http://farm" + farm + ".staticflickr.com/" + server + "/"
				+ id + "_" + secret + ".jpg";
		imagen = parent.loadImage(urlImagen);
	}

	void pintar() {
		parent.imageMode(PConstants.CENTER);
		parent.image(imagen, posX, posY);
	}

}

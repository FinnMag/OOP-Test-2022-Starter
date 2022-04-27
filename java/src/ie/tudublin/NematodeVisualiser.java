package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	public void keyPressed() {
		if (keyCode == LEFT) {
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
	}

	public void loadNematodes() {

		ArrayList<Nematode> Nematodes = new ArrayList<Nematode>();

		Table table = loadTable("nematodes.csv", "header");
		for (TableRow row : table.rows()) {
			Nematode nema = new Nematode(row);
			Nematodes.add(nema);
		}

		
	}

	public void draw() {

	}
}

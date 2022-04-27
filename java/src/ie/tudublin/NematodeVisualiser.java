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
		Table table = loadTable("nematodes.csv", "header");
		for (TableRow row : table.rows()) {
			row.getString("name");
			row.getInt("length");
			row.getInt("limbs");
			row.getString("gender");
			row.getInt("eyes");
		}
	}

	public void draw() {
	}
}

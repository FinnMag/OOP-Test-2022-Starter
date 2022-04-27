package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	ArrayList<Nematode> NematodeList = new ArrayList<Nematode>();
	
	int nemaOption = 0;
	
	

	public void keyPressed() {
		if (keyCode == LEFT) {
			
			if (nemaOption != 0) 
				nemaOption--;
				
		}

		if (keyCode == RIGHT) {
			nemaOption++;
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
	}
		

	public void loadNematodes() {

		Table table = loadTable("nematodes.csv", "header");
		for (TableRow row : table.rows()) {
			Nematode nema = new Nematode(row);
			NematodeList.add(nema);
		}
	}	

	public void draw() {
		
		int amount = NematodeList.size();
		float offset = 50;

		String name = NematodeList.get(nemaOption).name;
		float noCircles = NematodeList.get(nemaOption).length;
		

		background(0);

        for (int i = 0; i < noCircles; i++) {
		
            strokeWeight(5);
			stroke(255);
			noFill();
			textSize(50);
			textAlign(CENTER);
			text(name, 400, 50);
			circle(400, (height / 2.5f) + offset * i, 50);

        }

	}
}

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
		String gender = NematodeList.get(nemaOption).gender;
		int limbs = NematodeList.get(nemaOption).limbs;
		int eyes = NematodeList.get(nemaOption).eyes;

		String male = "m";
		String female = "f";
		String herm = "h";
		

		background(0);
		textSize(50);
		textAlign(CENTER);
		text(name, 400, 50);

		for (int i = 0; i < noCircles; i++) {

			strokeWeight(5);
			stroke(255);
			noFill();

			//body length
			circle(400, (height / 2.5f) + (offset * i), 50);

			//limbs
			if (limbs == 1) {
				line(330, 320 + (offset * i), 370, 320 + (offset * i));
				line(430, 320 + (offset * i), 470, 320 + (offset * i));
			}

			//genitals
			if(gender.compareTo(male) == 0 || gender.compareTo(herm) == 0)
			{

				line(400, 310 + (offset * (noCircles - 1) + 40), 400, 320 + (offset * (noCircles - 1) + 60));
				circle(400, 320 + (offset * (noCircles - 1) + 70), 10);
			}

			if(gender.compareTo(female) == 0 || gender.compareTo(herm) == 0)
			{
				circle(400, 320 + (offset * (noCircles - 1)), 20);
			}
			
			//eyes
			if (eyes == 1) {
				circle(370, 320 - offset, 20);
				circle(430, 320 - offset, 20);
				line(370, 330 - offset, 400, 345 - offset);
				line(430, 330 - offset, 400, 345 - offset);
			}

		}

	}
}

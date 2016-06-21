package module3;

import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	//Stop eclipse from generating a warning
		private static final long serialVersionLongUID = 1L;
	private UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	
	public void setup(){
		size(800,600);
		
			
		map = new UnfoldingMap(this, 50, 50, 700, 500, new 
				  Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpByCountry = loadLifeExpectancyFromCVS("data/LifeExpectancyWorldBank.cvs");
	}
	public void draw() {
	    background(10);
	    map.draw();
	   
	}


}

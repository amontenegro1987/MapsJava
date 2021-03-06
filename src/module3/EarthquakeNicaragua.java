package module3;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PApplet;

public class EarthquakeNicaragua extends PApplet{

	//Stop eclipse from generating a warning
	private static final long serialVersionLongUID = 1L;
	
	//In case of work offline
	public static final boolean offline = false;
	
	//Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	
	//Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;
	
	//This is where to find the local titles in case of working offline
	public static String mbTilesString = "blankLight-1-3-.mbtiles";
	
	//The map
	private UnfoldingMap map;
	
	//Feed with magnitude 2.5+ earthquakes
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
	
	public void setup(){
		size(950,600/*,OPENGL*/);
		if(offline){
			map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
			earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else{
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			//if you want to test with a local file, uncomment the next line
		}
			map.zoomToLevel(2);
			MapUtils.createDefaultEventDispatcher(this,map);
			
			//The list you will populate with new SimplePointMarkers
			List<Marker> markers = new ArrayList<Marker>();
			
			//Use provided parser to collect properties for each earthquake 
			//Point features have a location method
			List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
			
			//These print statements show you (1) all of the relevant properties in the features
			//and (2) how to get one property and use it
			if(earthquakes.size()>0){
				PointFeature f = earthquakes.get(0);
				System.out.println(f.getProperties());
				Object magObj = f.getProperty("magnitude");
				float mag = Float.parseFloat(magObj.toString());
				//Point features also have a getLocation method
			}
			//Here is an example of how to use processing's color method to generate an int that
			//represents the color yellow;
			
			int yellow = color(255,255,0);
			
			//TODO add code here as appropriate
	}
	
			/*A suggested helper method that takes in an earthquake feature and returns
			  a SimplePointMarker for that earthquake
			  TODO: Implement this method and call it from setup, if it helps */
			private SimplePointMarker createMarker(PointFeature feature){
				//Finish implementing and use this method if it helps
				return new SimplePointMarker(feature.getLocation());
			}
			
			public void draw() {
			    background(10);
			    map.draw();
			    addKey();
			}


			// helper method to draw key in GUI
			// TODO: Implement this method to draw the key
			private void addKey() 
			{	
				// Remember you can use Processing's graphics methods here
			
			}
		}
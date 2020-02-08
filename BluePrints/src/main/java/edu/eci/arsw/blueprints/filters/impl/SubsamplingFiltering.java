package edu.eci.arsw.blueprints.filters.impl;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.filters.Filtering;
import edu.eci.arsw.blueprints.model.Point;
@Component("SubsamplingFiltering")
public class SubsamplingFiltering implements Filtering{
	public SubsamplingFiltering() {
		
	}
	@Override
	public Point[] filter(Point[] points) {
		Point[] pointsfilter = new Point[points.length%2 + points.length/2];
		for(int i=0;i<points.length;i+=1) {
			if(i%2==0) pointsfilter[i/2] = points[i];
		}
		return pointsfilter;
	}

}

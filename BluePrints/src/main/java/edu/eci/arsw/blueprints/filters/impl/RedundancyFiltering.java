package edu.eci.arsw.blueprints.filters.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.filters.Filtering;
import edu.eci.arsw.blueprints.model.Point;
@Component("RedundancyFiltering")
public class RedundancyFiltering implements Filtering{
	public RedundancyFiltering() {
		
	}
	@Override
	public Point[] filter(Point[] points) {
		Set<Point> filterpoints = new HashSet<>();
		for(Point p:points) {
			filterpoints.add(p);
		}
		//for(Point p:filterpoints) System.out.println("("+p.getX()+","+p.getY()+")");
		//System.out.println("------------------");
		return filterpoints.toArray(new Point[filterpoints.size()]);
	}
}

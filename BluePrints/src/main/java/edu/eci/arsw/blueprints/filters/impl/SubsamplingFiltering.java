package edu.eci.arsw.blueprints.filters.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.filters.Filtering;
import edu.eci.arsw.blueprints.model.Point;
@Component("SubsamplingFiltering")
public class SubsamplingFiltering implements Filtering{
	public SubsamplingFiltering() {
		
	}
	@Override
	public List<Point> filter(List<Point> points) {
		List<Point> pointsfilter = new ArrayList<>();
		for(int i=0;i<points.size();i++) {
			if(i%2==0) pointsfilter.add(points.get(i));
		}
		return pointsfilter;
	}

}

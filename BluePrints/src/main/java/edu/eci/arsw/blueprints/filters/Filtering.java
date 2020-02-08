package edu.eci.arsw.blueprints.filters;

import java.util.List;

import edu.eci.arsw.blueprints.model.Point;

public interface Filtering {
	public List<Point> filter(List<Point> list);
}

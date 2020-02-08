package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Point;

public interface Filtering {
	public Point[] filter(Point[] points);
}

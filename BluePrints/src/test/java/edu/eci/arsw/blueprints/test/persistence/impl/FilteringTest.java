package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.eci.arsw.blueprints.filters.Filtering;
import edu.eci.arsw.blueprints.filters.impl.RedundancyFiltering;
import edu.eci.arsw.blueprints.filters.impl.SubsamplingFiltering;
import edu.eci.arsw.blueprints.model.Point;

public class FilteringTest {

	@Test
	public void wouldBeFilteringByRedundancy() {
		Point[] points = new Point[] {new Point(2,3),new Point(4,7),new Point(2,3),
				new Point(5,3),new Point(9,3),new Point(4,7),new Point(0,0)};
		Point[] resp = new Point[] {new Point(2,3),new Point(4,7),new Point(5,3),
				new Point(9,3),new Point(0,0)};
		Filtering filter = new RedundancyFiltering();
		Point[] progResp = filter.filter(points);
		//for(Point p:progResp) System.out.println("("+p.getX()+","+p.getY()+"), ");
		assertEquals(resp.length,progResp.length);
		for(int i=0;i<resp.length;i++) assertEquals(resp[i],progResp[i]);
		
	}
	@Test
	public void wouldBeFilteringPointBySubsampling() {
		Point[] points = new Point[] {new Point(4,3),new Point(5,7),new Point(9,4),
				new Point(14,1),new Point(6,3),new Point(7,8),new Point(7,5),
				new Point(2,3),new Point(8,8),new Point(9,9),new Point(10,10)};
		Point[] resp = new Point[] {new Point(4,3),new Point(9,4),new Point(6,3),
				new Point(7,5),new Point(8,8),new Point(10,10)};
		Filtering filter = new SubsamplingFiltering();
		Point[] proResp = filter.filter(points);
		assertEquals(resp.length,proResp.length);
		for(int i=0;i<resp.length;i++)assertEquals(resp[i],proResp[i]);
	}

}

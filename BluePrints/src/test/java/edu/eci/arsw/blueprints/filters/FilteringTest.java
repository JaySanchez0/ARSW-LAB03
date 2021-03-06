package edu.eci.arsw.blueprints.filters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.blueprints.filters.Filtering;
import edu.eci.arsw.blueprints.filters.impl.RedundancyFiltering;
import edu.eci.arsw.blueprints.filters.impl.SubsamplingFiltering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

public class FilteringTest {

	@Test
	public void wouldBeFilteringByRedundancy() {
		Point[] points = new Point[] {new Point(2,3),new Point(4,7),new Point(2,3),
				new Point(5,3),new Point(9,3),new Point(4,7),new Point(0,0)};
		List<Point> resp = Arrays.asList(new Point[] {new Point(2,3),new Point(4,7),new Point(5,3),
				new Point(9,3),new Point(0,0)});
		Filtering filter = new RedundancyFiltering();
		Blueprint progResp = filter.filter(new Blueprint("me","me",points));
		//for(Point p:progResp) System.out.println("("+p.getX()+","+p.getY()+"), ");
		assertEquals(resp.size(),progResp.getPoints().size());
		for(int i=0;i<resp.size();i++) assertEquals(resp.get(i),progResp.getPoints().get(i));
		
	}
	@Test
	public void wouldBeFilteringPointBySubsampling() {
		Point[] points = new Point[] {new Point(4,3),new Point(5,7),new Point(9,4),
				new Point(14,1),new Point(6,3),new Point(7,8),new Point(7,5),
				new Point(2,3),new Point(8,8),new Point(9,9),new Point(10,10)};
		List<Point> resp = Arrays.asList(new Point[] {new Point(4,3),new Point(9,4),new Point(6,3),
				new Point(7,5),new Point(8,8),new Point(10,10)});
		Filtering filter = new SubsamplingFiltering();
		Blueprint proResp = filter.filter(new Blueprint("me","m",points));
		assertEquals(resp.size(),proResp.getPoints().size());
		for(int i=0;i<resp.size();i++) assertEquals(resp.get(i),proResp.getPoints().get(i));
	}

}

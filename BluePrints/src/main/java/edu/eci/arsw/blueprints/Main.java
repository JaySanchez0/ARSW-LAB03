package edu.eci.arsw.blueprints;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {
	public static void main(String[] args) {
		try {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlueprintsServices services = ac.getBean(BlueprintsServices.class);
		//Test add
		services.addNewBlueprint(new Blueprint("Juan","me",new Point[] {new Point(2,3),new Point(3,4),new Point(5,7)}));
		//Test optain
		Blueprint b = services.getBlueprint("Juan","me");
		//Test optain all
		System.out.println(services.getAllBlueprints());
		//Test filter
		System.out.println(services.getFilterBlueprint("Juan","me").getPoints().toString());
		//Test Filter all
		System.out.println("Filter all");
		services.addNewBlueprint(new Blueprint("Jose","Luis",new Point[] {new Point(2,5),new Point(4,3),new Point(9,7)}));
		for(Blueprint bl: services.getAllBlueprintFilering())
			System.out.println(bl.getPoints().toString());
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BlueprintPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

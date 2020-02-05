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
		services.addNewBlueprint(new Blueprint("Juan","me",new Point[] {new Point(2,3),new Point(3,4)}));
		Blueprint b = services.getBlueprint("Juan","me");
		System.out.println(services.getAllBlueprints());
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BlueprintPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

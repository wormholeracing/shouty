package shouty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;

public class LocationSteps {
	@Autowired
	private ShoutyHelper shoutyHelper;
	
	@Given("^people are located at$")
	public void peopleAreLocatedAt(DataTable arg1) throws Throwable {
		List<Person> people = arg1.asList(Person.class);
		
		for (Person person : people)
			shoutyHelper.shouty.setLocation(person.name,
					new Coordinate(person.x, person.y));
	}

	@Given("^(\\w+) is at (.*)$")
	public void person_is_at(String person,
			@Transform(CoordinateConverter.class) Coordinate coordinate) throws Throwable {
		shoutyHelper.shouty.setLocation(person, coordinate);
	}
}

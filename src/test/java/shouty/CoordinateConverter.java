package shouty;

import cucumber.api.Transformer;

public class CoordinateConverter extends Transformer<Coordinate> {
	public Coordinate transform(String input) {
		String[] component = input.split(",");
		int x = Integer.valueOf(component[0].trim());
		int y = Integer.valueOf(component[1].trim());

		return new Coordinate(x, y);
	}

}

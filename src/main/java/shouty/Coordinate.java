package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }
    
//    public Coordinate(String coordinate){
//    	String[] component = coordinate.split(",");
//    	x = Integer.valueOf(component[0].trim());
//    	y = Integer.valueOf(component[1].trim());   	
//    }

    public int distanceFrom(Coordinate other) {    	
    	return (int) Math.hypot(this.x-other.x, this.y-other.y);
    }
}

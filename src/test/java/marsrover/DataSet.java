package marsrover;

public class DataSet {

    static Coordinates someCoordinates() {
        return coordinates(2, 7);
    }

    static Coordinates coordinates(int x, int y) {
        return new Coordinates(x, y);
    }

    static Rover aRover(Planet planet, Coordinates position, Direction direction) {
        return new Rover(planet, position, direction);
    }

    static Planet mars() {
        return new Planet(20, 20);
    }

}
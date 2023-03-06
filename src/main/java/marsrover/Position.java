package marsrover;

public class Position extends Coordinates {
    public Position(int x, int y) {
        super(x, y);
    }

    Position translate(Vector vector) {
        return new Position(this.x + vector.getAbscissa(), this.y + vector.getOrdinate());
    }

}

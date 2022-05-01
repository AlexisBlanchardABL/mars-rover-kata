package marsrover;

public record Coordinates(int x, int y) {

    public Coordinates translate(Vector vector) {
        return new Coordinates(this.x + vector.getAbscissa(), this.y + vector.getOrdinate());
    }

}

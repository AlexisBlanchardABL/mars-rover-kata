package marsrover;

public record Rover(int x, int y, char direction) {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

}

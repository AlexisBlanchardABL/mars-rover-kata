package marsrover;

import java.util.Objects;

public abstract class Coordinates {
    protected final int x;
    protected final int y;

    protected Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinates) obj;
        return this.x == that.x &&
                this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

}

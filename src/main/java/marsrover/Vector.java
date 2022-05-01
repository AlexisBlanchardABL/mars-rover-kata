package marsrover;

public enum Vector {

    UP(0, 1) {
        Vector opposite() {
            return DOWN;
        }
    },
    DOWN(0, -1) {
        Vector opposite() {
            return UP;
        }
    },
    LEFT(-1, 0) {
        Vector opposite() {
            return RIGHT;
        }
    },
    RIGHT(1, 0) {
        Vector opposite() {
            return LEFT;
        }
    };

    private final int abscissa;
    private final int ordinate;

    Vector(int abscissa, int ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    abstract Vector opposite();

    public int getOrdinate() {
        return ordinate;
    }

    public int getAbscissa() {
        return abscissa;
    }

}

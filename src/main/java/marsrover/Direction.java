package marsrover;

public enum Direction {
    NORTH {
        Direction right() {
            return EAST;
        }

        Direction left() {
            return WEST;
        }
    },
    SOUTH {
        Direction right() {
            return WEST;
        }

        Direction left() {
            return EAST;
        }
    },
    EAST {
        Direction right() {
            return SOUTH;
        }

        Direction left() {
            return NORTH;
        }
    },
    WEST {
        Direction right() {
            return NORTH;
        }

        Direction left() {
            return SOUTH;
        }
    };

    abstract Direction right();

    abstract Direction left();

}

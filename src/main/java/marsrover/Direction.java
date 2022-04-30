package marsrover;

public enum Direction {
    N {
        Direction right() {
            return E;
        }

        Direction left() {
            return W;
        }
    },
    S {
        Direction right() {
            return W;
        }

        Direction left() {
            return E;
        }
    },
    E {
        Direction right() {
            return S;
        }

        Direction left() {
            return N;
        }
    },
    W {
        Direction right() {
            return N;
        }

        Direction left() {
            return S;
        }
    };

    abstract Direction right();

    abstract Direction left();

}

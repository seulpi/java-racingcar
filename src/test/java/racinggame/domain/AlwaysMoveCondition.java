package racinggame.domain;

public class AlwaysMoveCondition extends MoveCondition {

    @Override
    public boolean isMovable() {
        return true;
    }
}

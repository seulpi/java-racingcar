package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Position position;
    private final Name name;
    private final MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, new RandomMove());
    }

    public Car(String name, int position) {
        this(name, position, new RandomMove());
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this(name, 0, moveStrategy);
    }

    public Car(String name, int position, MoveStrategy strategy) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.moveStrategy = strategy;
    }

    public Car move() {
        if (moveStrategy.movable()) {
            this.position.move();
        }

        return new Car(getName(), getPosition(), this.moveStrategy);
    }

    public boolean isSamePosition(Position other) {
        return this.position.equals(other);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public int compareTo(Car o) {
        return o.position.compareTo(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name) && Objects.equals(moveStrategy, car.moveStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name, moveStrategy);
    }

}

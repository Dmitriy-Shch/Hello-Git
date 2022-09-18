package Zadacha3;

public class Dog implements Movable,Eat{
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is rou");
    }
}

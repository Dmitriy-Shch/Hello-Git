package Zadacha3;

public class Cat implements Eat,Edible,Movable{
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void beEaten() {
        System.out.println("Gray cat");
    }

    @Override
    public void move() {
        System.out.println("Cat is run");
    }
}

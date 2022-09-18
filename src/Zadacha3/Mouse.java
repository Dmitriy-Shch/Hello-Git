package Zadacha3;

public class Mouse implements Edible,Movable{
    @Override
    public void beEaten() {
        System.out.println("Gray mouse");
    }

    @Override
    public void move() {
        System.out.println("Gray mouse");
    }
}

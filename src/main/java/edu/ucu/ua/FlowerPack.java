package edu.ucu.ua;


public class FlowerPack {
    private Flower flower;
    private int amount;

    public FlowerPack(Flower flower, int amount) {
        this.flower = new Flower(flower);
        this.amount = amount;
    }

    public FlowerPack(FlowerPack flowerPack) {
        this.flower = new Flower(flowerPack.flower);
        this.amount = flowerPack.amount;
    }

    public double getPrice() {
        return (flower.getPrice() * amount);
    }
}

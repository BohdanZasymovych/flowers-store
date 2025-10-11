package edu.ucu.ua;

import java.util.ArrayList;

public class FlowerBucket {
    private ArrayList<FlowerPack> flowerPacks;

    FlowerBucket() {
        flowerPacks = new ArrayList<>();
    }

    FlowerBucket(FlowerBucket flowerBucket) {
        flowerPacks = new ArrayList<>();
        for (FlowerPack flowerPack : flowerBucket.flowerPacks) {
            flowerPacks.add(new FlowerPack(flowerPack));
        }
    }

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(new FlowerPack(flowerPack));
    }

    public double getPrice() {
        double totalPrice = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            totalPrice += flowerPack.getPrice();
        }
        return totalPrice;
    }
}

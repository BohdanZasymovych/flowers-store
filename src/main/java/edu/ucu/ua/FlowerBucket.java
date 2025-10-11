package edu.ucu.ua;

import java.util.ArrayList;

public class FlowerBucket {
    private ArrayList<FlowerPack> flowerPacks;

    FlowerBucket() {
        flowerPacks = new ArrayList<>();
    }

    public void add(FlowerPack flowerPack) {
        FlowerPack newFlowerPack = new FlowerPack(flowerPack);
        flowerPacks.add(newFlowerPack);
    }

    public double getPrice() {
        int totalPrice = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            totalPrice += flowerPack.getPrice();
        }
        return totalPrice;
    }
}

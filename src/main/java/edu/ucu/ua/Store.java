package edu.ucu.ua;

import java.util.ArrayList;

public class Store {
    private ArrayList<FlowerBucket> flowerBuckets;

    Store() {
        flowerBuckets = new ArrayList<>();
    }

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        flowerBuckets.add(new FlowerBucket(flowerBucket));
    }

    public ArrayList<FlowerBucket> searchByPrice(int min, int max) {
        ArrayList<FlowerBucket> suitableFlowerBuckets = new ArrayList<>();

        for (FlowerBucket flowerBucket : flowerBuckets) {
            if ((flowerBucket.getPrice() >= min) && (flowerBucket.getPrice() <= max)) {
                suitableFlowerBuckets.add(new FlowerBucket(flowerBucket));
            }
        }

        return suitableFlowerBuckets;
    }
}

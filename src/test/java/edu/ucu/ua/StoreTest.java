package edu.ucu.ua;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class StoreTest {
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    private FlowerBucket makeBucket(double pricePerFlower, int amount) {
        Flower f = new Flower();
        f.setPrice(pricePerFlower);
        FlowerPack pack = new FlowerPack(f, amount);
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);
        return bucket;
    }

    @Test
    public void testSearchByPrice_emptyStore_returnsEmpty() {
        ArrayList<FlowerBucket> res = store.searchByPrice(0, 100);
        Assertions.assertTrue(res.isEmpty());
    }

    @Test
    public void testSearchByPrice_singleBucket_withinRange_included() {
        FlowerBucket bucket = makeBucket(10.0, 2); // total 20
        store.addFlowerBucket(bucket);

        ArrayList<FlowerBucket> res = store.searchByPrice(15, 25);
        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals(20.0, res.get(0).getPrice(), 1e-9);
    }

    @Test
    public void testSearchByPrice_inclusiveBounds() {
        FlowerBucket b1 = makeBucket(5.0, 2);  // total 10
        FlowerBucket b2 = makeBucket(7.5, 2);  // total 15
        store.addFlowerBucket(b1);
        store.addFlowerBucket(b2);

        // bounds inclusive: both 10 and 15 should be found
        ArrayList<FlowerBucket> res1 = store.searchByPrice(10, 10);
        Assertions.assertEquals(1, res1.size());
        Assertions.assertEquals(10.0, res1.get(0).getPrice(), 1e-9);

        ArrayList<FlowerBucket> res2 = store.searchByPrice(10, 15);
        Assertions.assertEquals(2, res2.size());
    }

    @Test
    public void testSearchByPrice_multipleBuckets_returnCorrectOnes() {
        FlowerBucket b1 = makeBucket(2.0, 5);   // 10
        FlowerBucket b2 = makeBucket(3.0, 4);   // 12
        FlowerBucket b3 = makeBucket(10.0, 1);  // 10
        store.addFlowerBucket(b1);
        store.addFlowerBucket(b2);
        store.addFlowerBucket(b3);

        ArrayList<FlowerBucket> res = store.searchByPrice(11, 20);
        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals(12.0, res.get(0).getPrice(), 1e-9);
    }

    @Test
    public void testSearchByPrice_returnsDefensiveCopies() {
        FlowerBucket original = makeBucket(4.0, 3); // total 12
        store.addFlowerBucket(original);

        ArrayList<FlowerBucket> res = store.searchByPrice(10, 15);
        Assertions.assertEquals(1, res.size());

        Flower f = new Flower();
        f.setPrice(100.0);
        FlowerPack extra = new FlowerPack(f, 1);
        res.get(0).add(extra);

        ArrayList<FlowerBucket> res2 = store.searchByPrice(10, 15);
        Assertions.assertEquals(1, res2.size());
        Assertions.assertEquals(12.0, res2.get(0).getPrice(), 1e-9);
    }
}
package edu.ucu.ua;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Flower {
    private double sepalLength;
    private String color;
    private double price;
    private FlowerType flowerType;
}

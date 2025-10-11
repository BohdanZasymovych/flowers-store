package edu.ucu.ua;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower(Flower other) {
        this(other.sepalLength, other.color, other.price, other.flowerType);
    }

    public String getColor() {
        return color == null ? null : color.getHexColor();
    }
}

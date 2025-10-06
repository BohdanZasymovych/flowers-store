package edu.ucu.ua;

public enum FlowerColor {
    RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF")

    private String hexColor;

    FlowerColor(String hexColor) {
        this.hexColor = hexColor;
    }
}

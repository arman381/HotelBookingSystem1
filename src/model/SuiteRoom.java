package model;

public class SuiteRoom extends AbstractRoom {
    private static final double BASE_PRICE = 350.0;

    public SuiteRoom() {
        super(BASE_PRICE, "suite room with separate living room.");
    }
}
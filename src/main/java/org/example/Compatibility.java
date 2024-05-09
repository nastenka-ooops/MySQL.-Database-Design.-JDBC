package org.example;

public class Compatibility {
    private int dominantFlowerId;
    private int compatibleFlowerId;
    private double optimalQuantity;

    public Compatibility() {
    }

    public Compatibility(int dominantFlowerId, int compatibleFlowerId, double optimalQuantity) {
        this.dominantFlowerId = dominantFlowerId;
        this.compatibleFlowerId = compatibleFlowerId;
        this.optimalQuantity = optimalQuantity;
    }

    public int getDominantFlowerId() {
        return dominantFlowerId;
    }

    public void setDominantFlowerId(int dominantFlowerId) {
        this.dominantFlowerId = dominantFlowerId;
    }

    public int getCompatibleFlowerId() {
        return compatibleFlowerId;
    }

    public void setCompatibleFlowerId(int compatibleFlowerId) {
        this.compatibleFlowerId = compatibleFlowerId;
    }

    public double getOptimalQuantity() {
        return optimalQuantity;
    }

    public void setOptimalQuantity(double optimalQuantity) {
        this.optimalQuantity = optimalQuantity;
    }
}

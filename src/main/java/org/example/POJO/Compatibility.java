package org.example.POJO;

public class Compatibility {
    private long dominantFlowerId;
    private long compatibleFlowerId;
    private double optimalQuantity;

    public Compatibility() {
    }

    public Compatibility(long dominantFlowerId, long compatibleFlowerId, double optimalQuantity) {
        this.dominantFlowerId = dominantFlowerId;
        this.compatibleFlowerId = compatibleFlowerId;
        this.optimalQuantity = optimalQuantity;
    }

    public long getDominantFlowerId() {
        return dominantFlowerId;
    }

    public void setDominantFlowerId(long dominantFlowerId) {
        this.dominantFlowerId = dominantFlowerId;
    }

    public long getCompatibleFlowerId() {
        return compatibleFlowerId;
    }

    public void setCompatibleFlowerId(long compatibleFlowerId) {
        this.compatibleFlowerId = compatibleFlowerId;
    }

    public double getOptimalQuantity() {
        return optimalQuantity;
    }

    public void setOptimalQuantity(double optimalQuantity) {
        this.optimalQuantity = optimalQuantity;
    }
}

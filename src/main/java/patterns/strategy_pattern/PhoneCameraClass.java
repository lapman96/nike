package patterns.strategy_pattern;

import patterns.strategy_pattern.strategies.Shareable;

public abstract class PhoneCameraClass {
    private Shareable shareable;

    protected PhoneCameraClass(Shareable shareable) {
        this.shareable = shareable;
    }

    public void take(){
        System.out.println("Take a picture");
    }

    public abstract void edit();

    public void save(){
        System.out.println("Save a photo");
    }

    public void setSharingStrategy(Shareable shareable) {
        this.shareable = shareable;
    }

    public void share(){
        shareable.share();
    }
}

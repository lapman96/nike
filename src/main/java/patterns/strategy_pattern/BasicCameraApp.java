package patterns.strategy_pattern;

import patterns.strategy_pattern.strategies.Shareable;

public class BasicCameraApp extends PhoneCameraClass {
    public BasicCameraApp(Shareable shareable) {
        super(shareable);
    }

    @Override
    public void edit() {
        System.out.println("editing photo with basic quality");
    }
}

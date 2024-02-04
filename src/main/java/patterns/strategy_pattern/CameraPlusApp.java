package patterns.strategy_pattern;

import patterns.strategy_pattern.strategies.Shareable;

public class CameraPlusApp extends PhoneCamera {
    public CameraPlusApp(Shareable shareable) {
        super(shareable);
    }

    @Override
    public void edit() {
        System.out.println("editing photo with super quality");
    }
}

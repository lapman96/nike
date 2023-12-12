package patterns.strategy_pattern;

import patterns.strategy_pattern.strategies.TextSharingStrategy;

public class CameraApp {
    public static void main(String[] args) {
        BasicCameraApp basicCameraApp = new BasicCameraApp(new TextSharingStrategy());
        basicCameraApp.take();
        basicCameraApp.share();
    }
}

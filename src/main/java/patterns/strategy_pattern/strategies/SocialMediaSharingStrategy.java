package patterns.strategy_pattern.strategies;

public class SocialMediaSharingStrategy implements Shareable {
    @Override
    public void share() {
        System.out.println("Photo has been shared in the social media");
    }
}

package patterns.strategy_pattern.strategies;

public class EmailSharingStrategy implements Shareable{
    @Override
    public void share() {
        System.out.println("Photo has been shared by email");
    }
}

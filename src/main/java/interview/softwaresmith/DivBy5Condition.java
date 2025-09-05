package interview.softwaresmith;

public class DivBy5Condition implements NumberCondition{
    @Override
    public String message() {
        return "buzz";
    }

    @Override
    public boolean applicable(int i) {
        return i % 5 == 0;
    }
}

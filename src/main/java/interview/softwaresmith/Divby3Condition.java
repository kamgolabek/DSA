package interview.softwaresmith;

public class Divby3Condition implements NumberCondition{
    @Override
    public String message() {
        return "fizz";
    }

    @Override
    public boolean applicable(int i) {
        return i % 3 == 0;
    }
}

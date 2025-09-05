package interview.softwaresmith;

public class DivBy4 implements NumberCondition
{
    @Override
    public String message() {
        return "pop";
    }

    @Override
    public boolean applicable(int i) {
        return i % 4 == 0;
    }
}

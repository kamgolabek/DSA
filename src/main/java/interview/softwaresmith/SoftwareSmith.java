package interview.softwaresmith;


// new feature: if i % 4 == 0 -> 'pop'

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 *
 * dvisions:
 * - 3  -> fizz
 * - 5 -> buzz
 * - 4 -> pop
 * - 3 && 5 -> fizzbuz
 *
 *
 *
 *
 *
 *
 *
 *
 */


public class SoftwareSmith {
    private static final Logger log = LoggerFactory.getLogger(SoftwareSmith.class);

    void main() {
        System.out.println("hello world");

        List<NumberCondition> conditions = Arrays.asList(new Divby3Condition(), new DivBy5Condition(), new DivBy4());
        int n = 20;


        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            for(NumberCondition condition : conditions){
                if(condition.applicable(i)){
                    sb.append(condition.message());
                }
            }

            if(sb.isEmpty()){
                System.out.println(i);
            }else{
                System.out.println(sb);
            }
        }
    }
}

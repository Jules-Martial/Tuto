
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WDLTest {

    private List<Integer> cashRegister = Arrays.asList(50, 50, 20, 20, 10, 10, 5, 2, 1);

    private List<Integer> getChange(final Integer amount) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = cashRegister.iterator();
        boolean trouver = false;
        Integer sumAmount = 0;
        while (it.hasNext() && !trouver) {
            int currentValue = it.next();
            if (amount == currentValue) {
                trouver = true;
                result.add(amount);
                return result;
            } else if (currentValue < amount && !result.contains(currentValue)) {
                sumAmount = sumAmount + currentValue;
                if(sumAmount<amount) {
                    result.add(currentValue);
                }else if(sumAmount==amount){
                    result.add(currentValue);
                    trouver=true;
                    return result;
                }else{
                    sumAmount = sumAmount - currentValue;
                }
            }

        }
        return null;
    }

    @Test
    public void getChangeTest() {
        List<Integer> resul = getChange(81);
        System.out.println(resul);
    }
}

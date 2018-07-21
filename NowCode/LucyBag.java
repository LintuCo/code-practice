
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * LucyBag
 */
public class LucyBag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        List<Integer> bolls = new ArrayList<Integer>();
        for (int i = 0; i < cnt; i++) {
            bolls.add(scanner.nextInt());
        }
        Collections.sort(bolls);
        int sum = 0;
        int prod = 1;
        for (Integer var : bolls) {
            sum += var;
            prod *= var;
        }

        List<String> lists = new ArrayList<>();
        LuckyStatus(lists, sum, prod, bolls, 0);
        System.out.println(lists.size());
    }

    public static void LuckyStatus(List<String> lists, int sum, int prod, List<Integer> bolls, int index) {
        if (bolls.size() == 1) {
            return;
        }
        if (!lists.contains(bolls.toString()) && sum > prod) {
            lists.add(bolls.toString());
        }
        if (index >= bolls.size()) {
            return;
        }
        LuckyStatus(lists, sum, prod, bolls, index + 1);
        List<Integer> temp = new ArrayList<>(bolls);
        int val = temp.remove(index);
        LuckyStatus(lists, sum - val, prod / val, temp, index);

        // if(sum<)
        // if ((sum-bolls.get(index)) > prod/bolls.get(index)) {
        // List<Integer> temp = new ArrayList<>();
        // Collections.copy(temp, bolls);
        // temp.remove(index);
        // if(!lists.contains(temp)){
        // lists.add(new (ArrayList) temp);
        // }

        // }

    }
}
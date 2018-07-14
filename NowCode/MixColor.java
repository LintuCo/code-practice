import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Question: MixColor
 * 
 * url：https://www.nowcoder.com/practice/5b1116081ee549f882970eca84b4785a?tpId=85&tqId=29838&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * 
 * Description: 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。
 * 你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。
 * 混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。
 * 本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
 * 
 * Input Description: 第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50) 第二行为n个数xi(1 ≤ xi ≤
 * 1,000,000,000)，表示需要的各种颜料.
 * 
 * Output Description: 输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色
 * 
 * Example: Input: 3, 1 7 3 Output: 3
 * 
 * Solution； 两个数进行异或操作产生第三个数可以和其中任意一个数异或得到另一个数，因此只需要将所有数排序之后求其秩即可， 当最大的两个数a，b
 * 进行异或，当a^b>b时，说明a和b的二进制最高为不同，则秩+1 当a^b<b时，说明a和b的最高为相同，
 * a可以用a^b代替，如果存在a^b,则只需要删除a，否则删除a并且添加a^b代替a
 */
public class MixColor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        List<Integer> nums = new LinkedList<Integer>();
        for (int i = 0; i < cnt; i++) {
            int temp = scanner.nextInt();
            if (!nums.contains(temp)) {
                nums.add(temp);
            }
        }
        scanner.close();
        Collections.sort(nums);
        Collections.reverse(nums);
        for (int i = 0; i < nums.size() - 2; i++) {
            int temp = nums.get(i) ^ nums.get(i + 1);
            if (temp < nums.get(i + 1)) {
                nums.remove(nums.get(i));
                if (!nums.contains(temp)) {
                    nums.add(temp);
                    Collections.sort(nums);
                    Collections.reverse(nums);
                }
                i--;
            }
        }
        System.out.println(nums.size());
    }
}
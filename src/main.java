import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2018/1/7.
 */
/*
* 测试数据：
*   1
*   2
*   100000
* */
public class main {
    public static void main(String[] args) {
        System.out.println(MthPrime(10));
        System.out.println(countPrimes2(12));

    }

    public static int MthPrime(int n) {
        int i = 2, j = 1;                   //2是第一个素数，从第一个素数开始判断
        while (true) {
            j = j + 1;
            if (j > i / j) {                //j^2>i时，说明此时的i是素数，但不是所要的第n个素数
                n--;
                if (n == 0) break;          //n==0时，此时的i是第n个素数
                j = 1;                       //这一步使下一个if成立，i加1，即开始找下一个素数
                System.out.print(i + " ");
            }
            if (i % j == 0) {               //计算2→根号i的数能否除尽i，若存在，则i不是素数
                i++;                        //接着判断下一个整数
                j = 1;
            }
        }
        return i;
    }

    //大数据超时
    public static int countPrimes1(int n) {
        if (n <= 2)
            return 0;
        int count = 0;
        int i = 2, j = 1;
        while (true) {
            j = j + 1;
            if (j > i / j) {
                count++;
                j = 1;
            }
            if (i % j == 0) {
                i++;
                j = 1;
            }
            if (i >= n) {
                break;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {
        if (n <= 2)
            return 0;
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(1);
        }
        list.set(0,0);
        list.set(1,0);
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (list.get(i) != 1) count++;
            for (int j = i * i; j < n; j += i) {
                list.set(j, 0);
            }

        }
        for (int i = 0; i < n; i++) {
            if (list.get(i) == 1) {
                count++;
            }
        }
        return count;
    }
    
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] flag = new boolean[n];
        int cnt = n / 2;

        for (int i = 3; i * i < n; i += 2) {
            if (flag[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += 2 * i) {
                if (!flag[j]) {
                    cnt--;
                    flag[j] = true;
                }
            }
        }

        return cnt;
    }
}

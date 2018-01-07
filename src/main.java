import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2018/1/7.
 */
/*
* �������ݣ�
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
        int i = 2, j = 1;                   //2�ǵ�һ���������ӵ�һ��������ʼ�ж�
        while (true) {
            j = j + 1;
            if (j > i / j) {                //j^2>iʱ��˵����ʱ��i����������������Ҫ�ĵ�n������
                n--;
                if (n == 0) break;          //n==0ʱ����ʱ��i�ǵ�n������
                j = 1;                       //��һ��ʹ��һ��if������i��1������ʼ����һ������
                System.out.print(i + " ");
            }
            if (i % j == 0) {               //����2������i�����ܷ����i�������ڣ���i��������
                i++;                        //�����ж���һ������
                j = 1;
            }
        }
        return i;
    }

    //�����ݳ�ʱ
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

package Algorithm;

/**
 * @Classname Palindrome
 * @Description TODO 判断回文数
 * 负数，以0结尾的数，不属于回文数
 * 测x数位的一半，
 * if num == help
 * help为num的逆序数
 * @Date 2019-03-17 15:23
 * @Created by guo
 */
public class Palindrome {


    public static boolean palindrome1(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int help = 1;
//        若num=32323 help为10000的时候停止,此时num/help =3;
        while (num / help >= 10) {
            help *= 10;
        }
        while (num > 0) {
            if (num / help != num % 10) {
                return false;
            }
            num = (num % help) / 10; //去头去尾
            help /= 100;
        }
        return true;
    }

    public static boolean palindrome2(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int help = 0;
        while (num > help) {
            help = help * 10 + num % 10;
            num /= 10;
        }

        return num == help || num == help / 10;
    }

    public static void main(String[] args) {
        boolean res = palindrome2(101);
        System.out.println(res);
    }

}

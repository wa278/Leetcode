import java.math.BigInteger;
import java.util.List;

/**
 * Created by wa941 on 2018/5/3.
 */
public class AddTwoNumbers {
/*纪念一个愚蠢的我
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int a = 0;
        BigInteger c1 = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        BigInteger beishu = new BigInteger("1");
        while (l1!=null){
            c1 = c1.add((beishu.multiply(new BigInteger(l1.val+""))));
            beishu = beishu.multiply(ten);
            l1 = l1.next;
        }
        int b = 0;
        BigInteger c2 = new BigInteger("0");
        beishu = new BigInteger("1");
        while (l2 != null){
            c2 = c2.add((beishu.multiply(new BigInteger(l2.val+""))));
            beishu = beishu.multiply(ten);
            l2 = l2.next;
        }
        BigInteger x = c1.add(c2);

        BigInteger v = x.remainder(ten);
        x = x.divide(ten);
        ListNode re = new ListNode(v.intValue());
        ListNode result = re;
        while (!x.equals(zero)){
            BigInteger z = x.remainder(ten);
            x = x.divide(ten);
            ListNode k = new ListNode(z.intValue());
            re.next = k;
            re = k;
        }
        return result;
    }
*/
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode result = new ListNode(0);
        ListNode re = result;
        int up = 0;
        while (true){
            if(l1 != null && l2 != null){
                int num = l1.val + l2.val + up;
                up = num / 10;
                ListNode a = new ListNode(num % 10);
                result.next = a;
                result = result.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 == null && l2 != null){
                int num = l2.val + up;
                up = num / 10;
                ListNode a = new ListNode(num % 10);
                result.next = a;
                result = result.next;
                l2 = l2.next;
            }
            else if(l1 != null && l2 == null){
                int num = l1.val + up;
                up = num / 10;
                ListNode a = new ListNode(num % 10);
                result.next = a;
                result = result.next;
                l1 = l1.next;
            }
            else {
                if(up == 0)
                    return re.next;
                else {
                    ListNode a = new ListNode(1);
                    result.next = a;
                    return re.next;
                }
            }
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

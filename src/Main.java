import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("china");
        Address address1 = (Address) address.clone();
        System.out.println(address1.getCity());
        address1.setCity("america");
        System.out.println(address1.getCity());
        /*Address address = new Address("china");
        Person p1 = new Person("tom", address);
        Person p2 = (Person)p1.clone();

        System.out.println("p1:"+p1.getName()+p1.getAddress().getCity());
        System.out.println("p2:"+p2.getName()+p2.getAddress().getCity());
        address.setCity("america");


        System.out.println("p1:"+p1.getName()+p1.getAddress().getCity());
        System.out.println("p2:"+p2.getName()+p2.getAddress().getCity());*/
        /*String str1 = new String("ab") + new String("c");
        String str2 = new String("ab") + new String("c");
        System.out.println(str1.intern()==str2.intern());*/

    }
}

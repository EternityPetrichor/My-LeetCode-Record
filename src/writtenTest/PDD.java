package writtenTest;

public class PDD {
    //T1
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        while (number>0){
            int score = 0;
            String s = scanner.nextLine();
            char[] chars;
            boolean flag = true;
            while (flag){
                chars = s.toCharArray();
                for (int i = 0; i < chars.length - 2; i++) {
                    if (isPDD(chars, i)){
                        flag = false;
                        s = deletePDD(s, i);
                        score++;
                        break;
                    }
                }

                if (!flag)
                    flag = true;
                else
                    flag=false;
            }


            System.out.println(score);
            number--;
        }
    }

    public static boolean isPDD(char[] chars, int index){
        if (chars[index]=='p' || chars[index] == 'P')
            if (chars[index+1]=='d' || chars[index+1] == 'D')
                return chars[index + 2] == 'd' || chars[index + 2] == 'D';
        return false;
    }

    public static String deletePDD(String s, int start){
        if (start==0)
            return s.substring(start+3);
        else {
            return s.substring(0, start) + s.substring(start+3);
        }
    }*/

    //T2
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        while (number>0){
            boolean flag = false;
            int dataNum = Integer.parseInt(scanner.nextLine());
            String[] split = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>(dataNum);
            for (String s : split)
                list.add(Integer.parseInt(s));
            if (isNine(list) && dataNum >= 9)
                flag = true;

            if (flag){
                System.out.println("YES");
            } else
                System.out.println("NO");

            number--;
        }
    }
    public static boolean isNine(List<Integer> list){
        Integer[] array = list.toArray(new Integer[0]);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (j==i) continue;
                for (int k = 0; k < list.size(); k++) {
                    if (k==i || k == j) continue;
                    for (int l = 0; l < list.size(); l++) {
                        if (l==i || l==j || l==k) continue;
                        for (int m = 0; m < list.size(); m++) {
                            if (m==i || m==j || m==k || m==l) continue;
                            for (int n = 0; n < list.size(); n++) {
                                if (n==i || n==j || n==k || n==l || n==m) continue;
                                for (int o = 0; o < list.size(); o++) {
                                    if (o==i || o==j || o==k || o==l || o==m || o==n) continue;
                                    for (int p = 0; p < list.size(); p++) {
                                        if (p==i || p==j || p==k || p==l || p==m || p==n || p==o) continue;
                                        for (int q = 0; q < list.size(); q++) {
                                            if (q==i || q==j || q==k || q==l || q==m || q==n || q==o || q==p) continue;
                                            if ((array[i] + array[j] + array[k] == array[i] + array[l] + array[o]) && (array[i] + array[j] + array[k] == array[i] + array[m] + array[q]) && (array[i] + array[j] + array[k] == array[l] + array[m] + array[n]) && (array[i] + array[j] + array[k] == array[q] + array[p] + array[o]))
                                                return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }


        return false;
    }*/
}

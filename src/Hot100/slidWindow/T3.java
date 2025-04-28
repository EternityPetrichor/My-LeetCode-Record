package Hot100.slidWindow;

import java.util.*;

public class T3 {
    /*个人暴力解法*/
    /*public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int first, second;
        for (first = 0; first < s.length(); first++) {
            set.add(String.valueOf(chars[first]));
            for (second=first+1;second<s.length();second++){
                if (!set.add(String.valueOf(chars[second]))){
                    list.add(set.size());
                    set.clear();
                    break;
                }
            }
            list.add(set.size());
            set.clear();
        }
        System.out.println(list);
        Object[] array = list.toArray();
        Arrays.sort(array);
        if(array.length-1<0){
            return 1;
        }
        return (int) array[array.length-1];

    }*/

    /*滑动窗口模板解法*/
    /*外层循环扩展右边界，内层循环扩展左边界
    for (int l = 0, r = 0 ; r < n ; r++) {
    //当前考虑的元素
    while (l <= r && check()) {//区间[left,right]不符合题意
    //扩展左边界
    }
    //区间[left,right]符合题意，统计相关信息
    }*/
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        for(int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while(set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
}

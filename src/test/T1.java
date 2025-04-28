package test;

public class T1 {
    public float test(String str){
        String[] split = str.split(" ");
        float fenmu = split.length;
        float fenzi = 0;
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            fenzi += chars.length;
        }
        return fenzi /fenmu;
    }
}

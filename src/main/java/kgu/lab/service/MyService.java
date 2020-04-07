package kgu.lab.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public static String lightning(double test){
        return String.valueOf(test * 330.0);
    }

    public  static  String marathon (String[] Name, int[] time)
    {
        int min = time[0], x = 0;
        for (int i = 1; i < time.length; i++){
            if (time[i] < min){
                min = time[i]; // сохраняем минимльное число массива
                x = i;}
        }
        String nm=Name[x];
        return (nm + " - " + min);
    }
    public  static String recurcion (String s, String tmp)
    {
        if (!s.isEmpty()) {
            tmp+=s.charAt(s.length() - 1);
            s = s.substring(0, s.length() - 1);
            tmp=recurcion(s,tmp);
        }
        return tmp;
    }

    public static boolean isPalindrome(String text) {
        return text.replaceAll("\\W","")
                .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W",""))
                        .reverse().toString());
    }
    public static int[] sytki (int Day)
    {
        int[] time=new int[3];
        time[0]=Day*24;
        time[1]=time[0]*60;
        time[2]=time[1]*60;
        return time;
    }
}

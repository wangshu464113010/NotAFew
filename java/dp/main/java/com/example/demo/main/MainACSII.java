package com.example.demo.main;

/**
 * Created by wangshu on 2019/8/7.
 *
 */
public class MainACSII {

    public static void main(String[] args) {
        String s = "ssss\taaa\faa\naaa\0x1234\1\40";
        char a = 29;
        System.out.println(s);
        System.out.println(a);
        System.out.println(s);

        String str = "abcdeftdfsf20194";
        char c = str.charAt(str.length() - 1);
        String substring = str.substring(str.length() - 5);
        System.out.println(substring.matches("\\d"));

        System.out.println(substring);


    }


}

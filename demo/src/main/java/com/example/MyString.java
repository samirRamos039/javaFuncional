package com.example;

public class MyString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner scn = new Scanner(System.in);
        String A = "hello";
        String B = "java";
        
        int sum = A.length() + B.length();
        System.out.println();
        System.out.println(sum);
        if(A.compareTo(B)<1){
            System.out.println("No");
        }else {System.out.println("YES");}
        String fcu = A.substring(0,1).toUpperCase()+A.substring(1);
        String scu = B.substring(0,1).toUpperCase()+B.substring(1);
        System.out.println(fcu+" "+scu);
    }
}

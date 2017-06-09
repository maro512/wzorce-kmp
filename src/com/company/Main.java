package com.company;

public class Main {

    public static int[] pi(String p){
        int k = 0, m = p.length();
        int pi[] = new int[m];
        pi[0] = 0;

        for (int i = 1; i < m; i++) {
            while (k > 0 && p.charAt(k) != p.charAt(i)) k = pi[k-1];
            if (p.charAt(k) == p.charAt(i)) k++;
            pi[i] = k;
        }
        return pi;
    }

    public static void kmp(String T, String P){
        int n = T.length();
        int m = P.length();
        int pi[] = pi(P);
        int k = 0;

        for (int i = 0; i < n; i++) {
            while (k > 0 && P.charAt(k) != T.charAt(i)) k = pi[k-1];
            if (P.charAt(k) == T.charAt(i)) k++;
            if (k == m) {
                if(i > m) System.out.print(T.substring(0,i-m+1) + " ");
                System.out.print(T.substring(i-m + 1,i + 1));
                if (i < n) System.out.print(" " + T.substring(i + 1));
                System.out.println();
                k = pi[k-1];
            }
        }
    }

    public static void main(String[] args) {
	    String T = "qwerwqrqwrwrqwerwqwererwqrqwreqwerqerqwrqrqeewewqrrerwqwerqrqwrqwrqrqw";
        String P = "qwer";
        kmp(T,P);
    }
}

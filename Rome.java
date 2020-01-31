import javafx.util.Pair;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Rome {
    String key;
    int value;
    myPair arr[]= {
            new myPair ("I", 1),
            new myPair ("IV",4),
            new myPair ("V", 5),
            new myPair ("IX", 9),
            new myPair ("X", 10),
            new myPair ("XL", 40),
            new myPair ("L", 50),
            new myPair ("XC", 90),
            new myPair ("C", 100)
    };

    Rome(String k) {
        int v = 0;
        char[] k_arr = k.toCharArray();
        for(int i = 0; i < k_arr.length - 1; i += 2) {
            for (int j = 1; j < arr.length - 1; j += 2) {
                if ((Character.toString(k_arr[i]) + Character.toString(k_arr[i+1])).equals(arr[j].key())) {
                    v += arr[j].value();
                    k_arr[i] = '0';
                    k_arr[i+1] = '0';
                }
            }
        }
        for(int i = 0; i < k_arr.length; i ++) {
            for (int j = 0; j < arr.length-1; j += 2) {
                if ((Character.toString(k_arr[i])).equals(arr[j].key())) {
                    v += arr[j].value();
                    k_arr[i] = '0';
                }
            }
        }

        this.key = k;
        this.value = v;
    }

    Rome(int v) {
        String k = "";
        int temp = v;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (temp / arr[i].value() >= 1) {
                k += arr[i].key();
                temp -= arr[i].value();
            }
        }
        this.key = k;
        this.value = v;
    }

    public String key(){return key;}
    public int value(){return value;}
}

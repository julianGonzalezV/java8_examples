package com.java.certification.chapter1;

public class Salmon {
int count;
public void Salmon() {

        count = 4;
         }
 public static void main(String[] args) {
         Salmon s = new Salmon();
         System.out.println(s.count);

     short x = 14;
     float y = 13;//no requiere la f cuando es parte entera
     double z = 30;

     double res = x * y / z;
     System.out.println(res);

     double a = 39.21;
     float b = 2.1f;//SI REQUIERE LA F
     double resab = a + b;
     System.out.println(resab);


        } }

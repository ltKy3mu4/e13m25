package ru.mpei.lec1;

public class MyStarter {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        boolean myVariable = true;
        int myFirstIntVar = 10;
        double myFirstDoubleVar = 10.5;

        System.out.println("int var " + myFirstIntVar);

        long myLongVar = 10;
        myLongVar = myFirstIntVar;

        long l2 = 1_000_000_000_000L;
        System.out.println(l2);
        int i2 = (int) l2;
        System.out.println(i2);

        int i3 = Integer.MAX_VALUE;
        System.out.println("max = " + i3);
        int i4 = i3 + 1;
        System.out.println("max + 1 = " + i4);

        double d2 = 2.5;
        System.out.println(d2);

        double d3 = 0.2 + 0.1;
        System.out.println(d3);

        float f2 = 0.5f;

        char a2 = 'a';
        char a3 = 97;

        System.out.println(a2);
        System.out.println(a3);
//        int a;
//        a = 20;
//        a = a /20;

        boolean b1 = true;
        boolean b2 = false;

        boolean b3 = b1 && b2;
        boolean b4 = b1 || b2;

        int a = 20;
        if (a != 30) {
            System.out.println("a is 0");
        } else if (a < 21) {

        } else if (a == 45) {

        } else {

        }
        int b = 30;
        switch (b) {
            case 20:
                System.out.println("a is 20");
                break;
            case 30:
                System.out.println("a is 30");
                break;
            case 45:
                System.out.println("a is 45");
                break;
            default:
                System.out.println("a is unknown");
                break;
        }
//
//        int ii = 0;
//        int counter = 1_000_000;
//        while (ii < 10) {
//            counter = counter - 1;
//            System.out.println(ii);
//            ii++;
//            if (ii > 9) {
//                ii = ii - 10;
//            }
//            if (counter < 0){
//                break;
//            }
//        }
//
//        for (int j = 0; j < 10; j++) {
//            System.err.println(j);
//
//        }
//        int h = 0;
//
//        h = h+1;
//        h++;
//
//        h =h -1;
//        h--;

        int i = 5, j = 5;
        int aa = 1 + ++i; // Используется значение до инкремента, но переменная i увеличивается на 1
        System.out.println("a = " + aa);
        System.out.println("i = " + i);

//        int[] arr = new int[10];
        int[] arr = {1,2,4, (int) 5.9,6};
        for (int k = 0; k < arr.length; k++) {
            System.out.println("arr[" + k + "] = " + arr[k]);
        }

    }
}
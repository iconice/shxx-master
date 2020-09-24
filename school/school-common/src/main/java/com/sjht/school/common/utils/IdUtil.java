package com.sjht.school.common.utils;

import java.util.Random;

public class IdUtil {

    static Random random = new Random();

    public static String getId() {
        try {
            Thread.sleep(10);
            String n = String.valueOf(random.nextInt(999));
            if (n.length() == 2) {
                n = "0"+n;
            } else if (n.length() == 1) {
                n = "00"+n;
            } else  {

            }
            String id = String.valueOf(System.currentTimeMillis()) + n;
            return id;
        } catch (Exception e) {
            Integer n = random.nextInt(99);
            while (true) {
                if (n > 10) {
                    break;
                }
                n = random.nextInt(99);
            }
            String id = String.valueOf(System.currentTimeMillis()) + n;
            return id;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.err.println(IdUtil.getId());
        }
    }
}

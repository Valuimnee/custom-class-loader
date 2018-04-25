package com.epam.customclassloader.main;

import com.epam.customclassloader.cl.CustomCL;
import com.epam.customclassloader.entity.User;

/**
 * @author Tsalapava Maryia
 * @version 1.0, 4/25/2018
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Main.class.getClassLoader());
        CustomCL customCL=new CustomCL(Main.class.getClassLoader());
        System.out.println(customCL);
        try {
            customCL.loadClass("com.epam.customclassloader.entity.User");
            User user=new User(1L, "tockweet", "hy45__vbhf", true);
            System.out.println(user.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            System.err.println("Class com.epam.customclassloader.entity.User not found");
            e.printStackTrace();
        }
    }
}

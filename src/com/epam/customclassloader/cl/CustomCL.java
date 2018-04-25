package com.epam.customclassloader.cl;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tsalapava Maryia
 * @version 1.0, 4/25/2018
 */
public class CustomCL extends ClassLoader {
    public CustomCL(ClassLoader parent) {
        super(parent);
    }

    private Class<?> loadClassWithCustomCL(String name) throws ClassNotFoundException{
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            b = loadFile(file);
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] loadFile(String file) throws IOException {
        InputStream is=getClass().getClassLoader().getResourceAsStream(file);
        byte[] bytes=new byte[is.available()];
        DataInputStream dis=new DataInputStream(is);
        dis.readFully(bytes);
        dis.close();
        return bytes;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("com.epam")){
            return loadClassWithCustomCL(name);
        }
        return super.loadClass(name);
    }
}

package com.example.thermostatapp.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author DarkSeraphim
 */
public class Serializable implements java.io.Serializable {

    protected void writeString(ObjectOutputStream out, String s) throws IOException {
        out.writeShort(s.length());
        for(char c : s.toCharArray())
            out.writeChar(c);
    }

    protected String readString(ObjectInputStream in) throws IOException {
        short len = in.readShort();
        char[] chars = new char[len];
        for(int i = 0; i < len; i++)
            chars[i] = in.readChar();
        return new String(chars);
    }
}

package com.masiv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parcer {

    private File file;
    public synchronized void setFile(File f) {
        file = f;
    }
    public synchronized File getFile() {
        return file;
    }
    public String getContent() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int data;
        while ((data = i.read()) > 0) {
            output += (char) data;
        }
        return output;
    }
    public String getContentWithoutUnicode() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int count = 0;
        int data;
        while ((data = i.read()) > 0) {
          //  Thread.sleep(1000);
            Integer dataAux = data;
            if (dataAux.compareTo(0x80)<0) {
                output += (char) data;
                count ++;
            }
        }
        System.out.println("contador: "+count);
        return output;
    }
    public void saveContent(String content)  {
        try {
            FileOutputStream o = new FileOutputStream(file);


            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

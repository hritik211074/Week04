package com.day04_exception.checked_exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class IOExceptionProgramme {
    public static void main(String[] args) {
        String path="data.txt";   // Here  a file path

        //  Make the FileReader class to read a file
        FileReader fr;
        try{
            fr= new FileReader(path);
            // Make the  BufferReader class to read a file
            BufferedReader br=new BufferedReader(fr);
            String ans;  // To store the lines

            while((ans=br.readLine())!=null){
                System.out.println(ans);
            }
        }catch(Exception ex){
            System.out.println("Exception handled :" +ex.getMessage());
        }

    }
}

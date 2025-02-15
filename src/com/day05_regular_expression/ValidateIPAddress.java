package com.day05_regular_expression;

import java.util.*;
public class ValidateIPAddress {
    public static boolean isValidIP(String ip) {
        return ip.matches("^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$");
    }

    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        String ip = sc.nextLine();
        System.out.println(isValidIP(ip) ? "Valid IP" : "Invalid IP");
    }
}


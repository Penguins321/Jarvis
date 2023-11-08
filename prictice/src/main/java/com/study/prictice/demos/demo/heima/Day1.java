package com.study.prictice.demos.demo.heima;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);



    }

    @Test
    public void test(){
        StringWriter sw = new StringWriter();
        sw.append("欧阳志威");
        System.out.println(sw);
    }



}

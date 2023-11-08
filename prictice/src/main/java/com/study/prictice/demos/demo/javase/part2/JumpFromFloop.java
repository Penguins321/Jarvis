package com.study.prictice.demos.demo.javase.part2;

/**
 * @Author ouyang    @Date 2023/10/10 0010
 * @Description
 * @menu
 */
public class JumpFromFloop {
    public static void main(String[] args) {

        // 使用标号跳出多层嵌套循环
        angry:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("标号跳出多层循环");
                break angry;
            }
        }
    }
}

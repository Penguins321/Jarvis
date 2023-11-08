package com.study.prictice.demos.demo.reflection;

import lombok.Data;

/**
 * @Author ouyang    @Date 2023/10/6 0006
 * @Description
 * @menu
 */
@Data
public class TestReflection {

    public String field;

    public void publicMethlod(String str) {
        System.out.println("hello public method" + str);
    }

    private void privateMethold(String str) {
        System.out.println("hello public method" + str);

    }

}

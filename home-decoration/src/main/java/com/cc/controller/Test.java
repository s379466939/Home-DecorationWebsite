package com.cc.controller;

import org.springframework.expression.spel.ast.OpNE;

public class Test {
    public enum PageSize {
        ONE,TWO,THREE
    }

    ;

    public static void main(String[] args) {
        PageSize pageSize =PageSize.ONE;
        System.out.println(pageSize.name() + "  " + pageSize.ordinal());
    }
}

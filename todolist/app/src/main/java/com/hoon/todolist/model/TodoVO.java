package com.hoon.todolist.model;

public class TodoVO {

    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TodoVO{" +
                "msg='" + msg + '\'' +
                '}';
    }


}

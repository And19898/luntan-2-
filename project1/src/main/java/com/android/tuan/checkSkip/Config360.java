package com.android.tuan.checkSkip;

import java.io.Serializable;

/**
 * author: Rea.X
 * date: 2018/1/2.
 */

public class Config360 implements Serializable{
    /**
     * data : eyJpZCI6IjU4OCIsIjAiOiI1ODgiLCJ1cmwiOiJodHRwczovLzhjYzAxLmNvbS9oNSIsIjEiOiJodHRwczovLzhjYzAxLmNvbS9oNSIsInR5cGUiOiJhbmRyb2lkIiwiMiI6ImFuZHJvaWQiLCJzaG93X3VybCI6IjEiLCIzIjoiMSIsImFwcGlkIjoiMjAxODAxMDIxNjE1IiwiNCI6IjIwMTgwMTAyMTYxNSIsImNvbW1lbnQiOiIxIiwiNSI6IjEiLCJjcmVhdGVBdCI6IjIwMTgtMDEtMDIgMTY6MTg6NDciLCI2IjoiMjAxOC0wMS0wMiAxNjoxODo0NyIsInVwZGF0ZUF0IjoiMjAxOC0wMS0wMiAxNjoxODo0NyIsIjciOiIyMDE4LTAxLTAyIDE2OjE4OjQ3In0=
     * rt_code : 200
     */

    private String data;
    private String rt_code;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRt_code() {
        return rt_code;
    }

    public void setRt_code(String rt_code) {
        this.rt_code = rt_code;
    }
}

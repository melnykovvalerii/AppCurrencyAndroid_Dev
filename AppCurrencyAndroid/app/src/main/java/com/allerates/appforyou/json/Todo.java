package com.allerates.appforyou.json;


import java.util.Date;


public class Todo {

    public final long id;
    private String summary;

    Todo(long i, String summary, String description, boolean b, Date date) {
        this.id = i;
        this.summary = summary;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return 31 + (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", summary=" + summary + "]";
    }

}

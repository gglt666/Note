package pers.gglt.note.java;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Generics {
    /**通配符*/
    // ? 和 T (?表示不确定类型) (T表示确定类型)
    // K 和 V (表示键值)
    // E (表示集合元素)

    /**泛型类*/
    class Person<T, U> {
        T age;
        U name;
    }

    /**泛型接口*/
    interface Info<T, U> {
        T getVar();
        void setVar(U u);
    }
    /**普通类实现泛型接口*/
    class InfoImpl implements Info<Integer, String> {
        public Integer getVar() {return null;}
        public void setVar(String str) {}
    }
    /**泛型类实现泛型接口*/
    class InfoImpl2<T, U> implements Info<T, U> { //实现类把泛型变量T,U传给了Info<T,U>
        public T getVar() {return null;}
        public void setVar(U u) {}
    }

    /**泛型函数*/
    <T> void function() {}
    <T> T f(T t) {return t;}
    static <T> void staticFunction(T t) {}
    static <T> T parseObject(String response, Class<T> object) {
        T t = new Gson().fromJson(response, object);
        return t;
    }

    /**使用*/
    void use() {
        Person<Integer, String> person = new Person();
        person.age = 21;
        person.name = "GG";
    }

    //https://zhuanlan.zhihu.com/p/433014792
}

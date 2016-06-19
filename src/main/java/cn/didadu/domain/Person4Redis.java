package cn.didadu.domain;

/**
 * Created by jinggg on 16/4/25.
 */
public class Person4Redis {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;

    public Person4Redis() {
        super();
    }
    public Person4Redis(String id,String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}

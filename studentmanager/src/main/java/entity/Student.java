package entity;
public class Student {
    private Integer sid;
    private String sname;
    private Integer sage;
    private String ssex;
    private String sclass;
    // 无参构造
    public Student() {}
    // 全参构造
    public Student(Integer sid, String sname, Integer sage, String ssex, String sclass) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.sclass = sclass;
    }

    // getter/setter
    public Integer getSid() { return sid; }
    public void setSid(Integer sid) { this.sid = sid; }
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    public Integer getSage() { return sage; }
    public void setSage(Integer sage) { this.sage = sage; }
    public String getSsex() { return ssex; }
    public void setSsex(String ssex) { this.ssex = ssex; }
    public String getSclass() { return sclass; }
    public void setSclass(String sclass) { this.sclass = sclass; }
}
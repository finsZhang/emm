package com.ai.emm.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 16:45
 * Email:zhangfz3@asiainfo.com
 */
@Entity
@Table(name="jpa_cutomers")
public class Customer {
    private Integer id;
    private String lastName;
    private String email;
    private int age;
    private Date createDate;
    private Date birthday;
    private Set<Order> orders = new HashSet<Order>();
    public Customer() {
    }

    public Customer(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    @Column(name="LAST_NAME",nullable = false,length = 64)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Column(columnDefinition = "DATE")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    //映射单向 1-n 的关联关系
    //使用 @OneToMany 来映射 1-n 的关联关系
    //使用 @JoinColumn 来映射外键列的名称
    //可以使用 @OneToMany 的 fetch 属性来修改默认的加载策略
    //可以通过 @OneToMany 的 cascade 属性来修改默认的删除策略.
    //注意: 若在 1 的一端的 @OneToMany 中使用 mappedBy 属性, 则 @OneToMany 端就不能再使用 @JoinColumn 属性了.
    //	@JoinColumn(name="CUSTOMER_ID")
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE},mappedBy = "customer")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    //工具方法. 不需要映射为数据表的一列.
    @Transient
    public String getInfo(){
        return "lastName: " + lastName + ", email: " + email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                ", birthday=" + birthday +
                ", orders=" + orders +
                '}';
    }
}

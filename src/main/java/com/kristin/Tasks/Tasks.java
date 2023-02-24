package com.kristin.Tasks;

import javax.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)

    private Long id;
    private String task;
    private Integer pay;
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User user;

    public Tasks() {
    }

    public Tasks(Long id, String task, Integer pay) {
        this.id = id;
        this.task = task;
        this.pay = pay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }


    @Override
    public String toString() {
        return task;
    }
}

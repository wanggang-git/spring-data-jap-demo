package com.wg.japdemo.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/4 14:54
 * @todo
 */
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;

    @OneToOne(mappedBy = "wallet")//指定通过Author的wallet属性一对一关联Author，Wallet实体类为关系被维护方法
    private User user;
    public Wallet(){}
    public Wallet(BigDecimal balance){
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}

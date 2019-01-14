package com.wg.japdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/4 15:11
 * @todo
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String areaCode;
    private String telnum;
    private String recevier;
    @ManyToOne
    @JoinColumn(name = "clientid" )
    private User client;
    public Address(){}
    @JsonIgnore //避免fastjons序列化时的循环应用
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", telnum='" + telnum + '\'' +
                ", recevier='" + recevier + '\'' +
                ", client=" + client +
                '}';
    }
}

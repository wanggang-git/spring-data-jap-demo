package com.wg.japdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/4 15:29
 * @todo
 */
@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @ManyToMany//(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_tag_good",
            joinColumns = @JoinColumn(name = "good_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    @JsonIgnore
    private List<Tag>tagsList = new ArrayList<>();



    public Good(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public List<Tag> getTags() {
//        return tagsList;
//    }

    public void setTagsList(List<Tag> tagsList) {
        this.tagsList = tagsList;
    }
}

package com.wg.japdemo.domain;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/13 16:52
 * @todo
 */
@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;

    @Transient
    private String author;

    @Column(name = "blog_content", nullable = false)
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String content;
}

package com.wg.japdemo.controller;

import com.wg.japdemo.domain.Good;
import com.wg.japdemo.domain.GoodRepository;
import com.wg.japdemo.domain.Tag;
import com.wg.japdemo.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 14:54
 * @todo
 */
@RestController
    @RequestMapping("tag")
public class TagController {
    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("get")
    public Tag getTag(Long id)
    {
        Tag tag = tagService.find(id);
        return tag;
    }
    @GetMapping("save")
    public Tag saveTag(String name){
        Tag  tag= new Tag();
        tag.setTag(name);
        tagService.save(tag);
        return tag;
    }

    @GetMapping("include")
    public Tag includeGood(Long tagId,Long goodId)
    {
        return tagService.includeGood(tagId, goodId);
    }
}

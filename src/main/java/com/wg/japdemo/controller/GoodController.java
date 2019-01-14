package com.wg.japdemo.controller;

import com.wg.japdemo.domain.Good;
import com.wg.japdemo.domain.Tag;
import com.wg.japdemo.service.GoodServiceImpl;
import com.wg.japdemo.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 15:30
 * @todo
 */
@RestController
@RequestMapping("good")
public class GoodController {
    @Autowired
    private GoodServiceImpl goodService;
    @Autowired
    private TagServiceImpl tagService;
    @GetMapping("save")
    public Good  saveGood(String name , BigDecimal price)
    {
        Good good = new Good();
        good .setName(name);
        good.setPrice(price);
        goodService.save(good);
        return  good;
    }

    @GetMapping("get")
    public Good getGood(Long id)
    {
        return goodService.find(id);
    }
    @GetMapping("del")
    public void delGood(Long id)
    {
        goodService.delete(id);
    }
}

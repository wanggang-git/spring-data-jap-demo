package com.wg.japdemo.service;

import com.wg.japdemo.domain.Good;
import com.wg.japdemo.domain.GoodRepository;
import com.wg.japdemo.domain.Tag;
import com.wg.japdemo.domain.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 14:23
 * @todo
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private GoodRepository goodRepository;
    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag find(Long id) {
        Tag tag =
         tagRepository.findById(id).get();
        return tag;
    }

    @Override
    public Tag update(Tag tag) {
        return tagRepository.saveAndFlush(tag);
    }

    @Override
    public Tag includeGood(Long tagId, Long goodId) {
        Tag tag = tagRepository.findById(tagId).get();
        Good good = goodRepository.findById(goodId).get();
        tag.getGoods().add(good);
        return tag;
    }

    @Override
    public Tag unIncludeGood(Long TagId, Long goodId) {
        return null;
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}

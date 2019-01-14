package com.wg.japdemo.service;

import com.wg.japdemo.domain.Good;
import com.wg.japdemo.domain.GoodRepository;
import com.wg.japdemo.domain.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 15:28
 * @todo
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private TagRepository tagRepository;
    @Override
    public Good save(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public Good find(Long id) {
        return goodRepository.findById(id).get();
    }

    @Override
    public Good update(Good good) {
        return goodRepository.saveAndFlush(good);
    }

    @Override
    public void delete(Long id) {
         goodRepository.deleteById(id);
    }
}

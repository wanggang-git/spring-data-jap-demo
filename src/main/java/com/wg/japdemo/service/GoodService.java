package com.wg.japdemo.service;

import com.wg.japdemo.domain.Good;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 14:21
 * @todo
 */
public interface GoodService {
    Good save(Good Good);

    Good find(Long id);

    Good update(Good Good);

    void delete(Long id);
}

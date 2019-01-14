package com.wg.japdemo.service;

import com.wg.japdemo.domain.Tag;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 14:21
 * @todo
 */
public interface TagService {
    Tag save(Tag Tag);

    Tag find(Long id);

    Tag update(Tag Tag);

    Tag includeGood(Long TagId, Long articleId);

    Tag unIncludeGood(Long TagId, Long articleId);

    void delete(Long id);
}

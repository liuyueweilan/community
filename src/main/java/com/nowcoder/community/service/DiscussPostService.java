package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    //DiscussPost里面有一个userId外键，但是在现实的时候现实的是用户的名称
    //方法一：sql上关联用户表（直接在数据库层面查询用户名） 方法二：先查到userid，然后再单独的根据userId再去查询用户名（业务层），最后discusspost
    // 与用户名最后一起返回，使用redis缓存方面，代码可看性
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}

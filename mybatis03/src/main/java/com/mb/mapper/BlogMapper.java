package com.mb.mapper;

import com.mb.entiry.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/29
 */
public interface BlogMapper {

    public int insertBlog(Blog blog);

    public List<Blog> queryBlogIf(Map<String,Object> map);

    public List<Blog> queryBlogDymic(Map<String, Object> map);
}


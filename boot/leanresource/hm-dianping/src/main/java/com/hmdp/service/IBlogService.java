package com.hmdp.service;

import com.hmdp.dto.BlogDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rolyfish

 */
public interface IBlogService extends IService<Blog> {

    Result queryHotBlog(Integer current);

    Result queryBlogById(Long id);

    Result likeBlog(Long id);

    Result queryBlogLikes(Long id);

    Result saveBlog(BlogDTO blog);

    Result queryBlogOfFollow(Long max, Integer offset);

    Result queryMyBlogPage(Integer current);
}

package com.roily.vo;

import lombok.*;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
@Data
@Builder
public class PageResult<T> extends PageUtil{

    //总记录数
    private Long totalCount;
    //总页数
    private Long totalPage;
    //列表数据
    private List<T> list;

}

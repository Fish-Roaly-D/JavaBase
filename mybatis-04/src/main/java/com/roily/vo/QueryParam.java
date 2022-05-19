package com.roily.vo;

import lombok.Builder;
import lombok.Data;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
@Data
@Builder
public class QueryParam {

    private String keyWord;

    private PageUtil pageUtil;

}

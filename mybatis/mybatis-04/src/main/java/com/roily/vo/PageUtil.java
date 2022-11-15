package com.roily.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
@Data
public class PageUtil {

    public Long currentPage;
    public Long limit;

    public Long getStart() {
        return (currentPage-1)*limit;
    }

}

package com.hmdp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 * @author rolyfish
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BlogDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "BlogDTO.shopId不可为空")
    private Long shopId;

    private Long userId;

    private String icon;

    private String name;

    private Boolean isLike;

    private String title;

    private String images;

    private String content;

    private Integer liked;

    private Integer comments;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

package com.roily.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.roily.entity.ResultEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/10
 */
@Repository
public interface ResultMapper extends BaseMapper<ResultEntity> {


    public ResultEntity getREByID(@Param("id") Integer id);

    public Map<String, Object> getREByIDMap(@Param("id") Integer id);


}

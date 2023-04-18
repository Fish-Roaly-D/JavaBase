package com.roily.mp01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roily.mp01.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author roilyFish
 * @since 2023-01-04
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}

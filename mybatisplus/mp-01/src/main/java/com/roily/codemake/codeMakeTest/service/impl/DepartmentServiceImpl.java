package com.roily.codemake.codeMakeTest.service.impl;

import com.roily.codemake.codeMakeTest.entity.Department;
import com.roily.codemake.codeMakeTest.mapper.DepartmentMapper;
import com.roily.codemake.codeMakeTest.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roilyFish
 * @since 2022-04-04
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}

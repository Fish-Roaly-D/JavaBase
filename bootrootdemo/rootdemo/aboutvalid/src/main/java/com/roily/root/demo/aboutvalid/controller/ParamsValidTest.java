package com.roily.root.demo.aboutvalid.controller;

import com.roily.root.demo.aboutvalid.pojo.vo.ValidTestVo;
import com.roily.root.demo.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @version 1.0.0
 * @Description @Valid 校验参数，并处理异常
 * @ClassName ParamsValidTest.java
 * @author: RoilyFish
 * @date: 2022/5/28 14:05
 */
@RestController
@Slf4j
public class ParamsValidTest {

    @RequestMapping(value = "/valid",method = RequestMethod.POST)
    public ResultVo<Object> validTest01(@RequestBody @Valid ValidTestVo validTestVo, BindingResult bindingResult) {

        log.info("参数:{}", validTestVo);
        log.info("参数校验结果:{}", bindingResult);

        return ResultVo.success();
    }


}

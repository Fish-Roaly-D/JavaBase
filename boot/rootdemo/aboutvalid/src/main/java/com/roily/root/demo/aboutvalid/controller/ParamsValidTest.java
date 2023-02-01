package com.roily.root.demo.aboutvalid.controller;

import com.roily.root.demo.aboutvalid.pojo.vo.Param01;
import com.roily.root.demo.aboutvalid.pojo.vo.ValidTestVo;
import com.roily.root.demo.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
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

    /**
     * 如果不使用valid
     *
     * @return ResultVo<Object>
     */
    @RequestMapping(value = "/withOutValid", method = RequestMethod.POST)
    public ResultVo<Object> validTest01(@RequestBody ValidTestVo validTestVo) {

        if (!ObjectUtils.isEmpty(validTestVo)){
            if (ObjectUtils.isEmpty(validTestVo.getParam01a())){
                return ResultVo.error("param01参数不能为空");
            }
            //、、、、
        }
        log.info("参数:{}", validTestVo);

        return ResultVo.success();
    }

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public ResultVo<Object> validTest02(@RequestBody @Valid ValidTestVo validTestVo) {

        log.info("参数:{}", validTestVo);
        //log.info("参数校验结果:{}", bindingResult);

        return ResultVo.success();
    }

    @RequestMapping(value = "/validated", method = RequestMethod.POST)
    public ResultVo<Object> validTest03(@RequestBody @Validated ValidTestVo validTestVo) {

        log.info("参数:{}", validTestVo);

        return ResultVo.success();
    }

    @RequestMapping(value = "/validated2", method = RequestMethod.POST)
    public ResultVo<Object> validTest03(@RequestBody @Validated  Param01 param01) {

        log.info("参数:{}", param01);

        return ResultVo.success();

    }

    /**
     * 聚合校验
     * @param param01
     * @return
     */
    @RequestMapping(value = "/validX", method = RequestMethod.POST)
    public ResultVo<Object> validTest04(@RequestBody @Valid Param01 param01) {

        log.info("参数:{}", param01);
        //log.info("参数校验结果:{}", bindingResult);

        return ResultVo.success();
    }

}

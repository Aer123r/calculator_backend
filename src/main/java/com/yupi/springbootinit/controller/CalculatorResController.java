package com.yupi.springbootinit.controller;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.DeleteRequest;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.common.ResultUtils;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.model.entity.CalculatorRes;
import com.yupi.springbootinit.service.CalculatorResService;
import com.yupi.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 帖子接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/calculatorRes")
@Slf4j
public class CalculatorResController {

    @Resource
    private CalculatorResService calculatorResService;

    @Resource
    private UserService userService;

    // region 增删改查

    @PostMapping("/add")
    public BaseResponse<Long> addCalculatorRes(@RequestBody CalculatorRes calculatorResAddRequest, HttpServletRequest request) {
        if (calculatorResAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        CalculatorRes calculatorRes = new CalculatorRes();
        BeanUtils.copyProperties(calculatorResAddRequest, calculatorRes);
        boolean result = calculatorResService.save(calculatorRes);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newCalculatorResId = calculatorRes.getId();
        return ResultUtils.success(newCalculatorResId);
    }


    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteCalculatorRes(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        CalculatorRes oldCalculatorRes = calculatorResService.getById(id);
        ThrowUtils.throwIf(oldCalculatorRes == null, ErrorCode.NOT_FOUND_ERROR);
        boolean b = calculatorResService.removeById(id);
        return ResultUtils.success(b);
    }


    @GetMapping("/get/vo")
    public BaseResponse<CalculatorRes> getCalculatorResVOById(long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        CalculatorRes calculatorRes = calculatorResService.getById(id);
        if (calculatorRes == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(calculatorRes);
    }


    @PostMapping("/list/vo")
    public BaseResponse<List<CalculatorRes>> listCalculatorResVOByPage(@RequestBody CalculatorRes calculatorResQueryRequest,
            HttpServletRequest request) {
        // 限制爬虫
        List<CalculatorRes> calculatorResList = calculatorResService.list();
        return ResultUtils.success(calculatorResList);
    }

    // endregion

}

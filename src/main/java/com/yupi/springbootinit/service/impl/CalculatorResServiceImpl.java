package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.model.entity.CalculatorRes;
import com.yupi.springbootinit.service.CalculatorResService;
import com.yupi.springbootinit.mapper.CalculatorResMapper;
import org.springframework.stereotype.Service;

/**
* @author bopeng
* @description 针对表【calculator_res(计算记录)】的数据库操作Service实现
* @createDate 2023-10-15 17:15:30
*/
@Service
public class CalculatorResServiceImpl extends ServiceImpl<CalculatorResMapper, CalculatorRes>
    implements CalculatorResService{

}





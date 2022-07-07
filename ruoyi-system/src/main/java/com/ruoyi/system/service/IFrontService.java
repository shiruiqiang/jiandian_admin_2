package com.ruoyi.system.service;

/**
 * @Author: shiRuiQiang
 * 2022/6/26 17:32
 */
public interface IFrontService {
    String  getPhoneNumber(String code)throws Exception;
    String getOpenid(String code) throws Exception;
}

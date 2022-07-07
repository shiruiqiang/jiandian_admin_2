package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.service.IFrontService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: shiRuiQiang
 * 2022/6/26 17:33
 */
@Service
public class FrontServiceImpl implements IFrontService {

    @Value("${wx_appid}")
    private String wx_appid;

    @Value("${wx_secret}")
    private String wx_secret;

    /**
     * 获取手机号
     * @param code
     * @return
     */
    public String  getPhoneNumber(String code) throws Exception {
        Map<String,Object> phone_info_map = null;
        Map<String , String> requestMap = new HashMap<>();
        requestMap.put("code",code);
        String resultStr = HttpUtils.sendPost("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + getAccessToken(), JSONObject.toJSONString(requestMap));
        Map<String,Object> map = JSONObject.parseObject(resultStr,Map.class);
        if((int)map.get("errcode")  == 0){
            phone_info_map = (Map)map.get("phone_info");
        }else {
            throw new Exception("获取微信手机号失败");
        }
        return MapUtils.getString(phone_info_map, "phoneNumber");
    }

    /**
     * 获取微信token
     * @return
     */
    public String getAccessToken(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ServletContext servletContext =  request.getServletContext();
        int date_difference =  7200;  //7200
        if(servletContext.getAttribute("access_token_date") != null){
            date_difference = DateUtils.calLastedTime((Date) servletContext.getAttribute("access_token_date"),new Date());
        }

        if(date_difference > 7000){
            String resultStr = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token","grant_type=client_credential&appid=" +wx_appid + "&secret=" + wx_secret);
            Map map = JSONObject.parseObject(resultStr,Map.class);
//            if((int)map.get("errcode")  == 0){
                servletContext.setAttribute("access_token",map.get("access_token"));
                servletContext.setAttribute("access_token_date",new Date());
//            }
        }
        return (String) servletContext.getAttribute("access_token");
    }

    /**
     * 获取微信小程序 openid
     * @return
     */
    public String getOpenid(String code) throws Exception{
        Map<String,Object> phone_info_map = null;
        Map<String , String> requestMap = new HashMap<>();
        requestMap.put("code",code);
        String resultStr = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session?appid="+  wx_appid +"&secret="+ wx_secret +"&js_code="+ code +"&grant_type=authorization_code" + getAccessToken());
        Map<String,Object> map = JSONObject.parseObject(resultStr,Map.class);
//        if((int)map.get("errcode")  == 0){
//            phone_info_map = (Map)map.get("phone_info");
//        }else {
//            throw new Exception("获取微信openid失败");
//        }
        return MapUtils.getString(map, "openid");
    }


//    public static void main(String[] s){
//
//        try {
//            System.out.println(DateUtils.calLastedTime(DateUtils.parseDateStrictly("2022-06-26 19:32:00","yyyy-MM-dd HH:mm:ss"),new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }




}

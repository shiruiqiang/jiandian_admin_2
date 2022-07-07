package com.ruoyi.web.controller.blinddate;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.XqMember;
import com.ruoyi.system.service.IFrontService;
import com.ruoyi.system.service.IXqMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 前端控制器
 * @Author: shiRuiQiang
 * 2022/6/21 18:29
 */
@Controller
@RequestMapping("/mini_program")
public class FrontController extends BaseController {

    @Autowired
    private IXqMemberService xqMemberService;

    @Autowired
    private IFrontService frontService;

    /**
     * 保存用户注册信息
     * @param xqMember
     * @return
     */
    @PostMapping("/member_save")
    @ResponseBody
    public Map memberSave(@RequestBody XqMember xqMember){
        xqMemberService.insertXqMember(xqMember);
        return success();
    }


    @GetMapping("/getPhoneNumber")
    @ResponseBody
    public Map getPhoneNumber(String code){
        String phone;
        try{
            phone = frontService.getPhoneNumber(code);
        }catch (Exception e){
            return error(e.getMessage());
        }
        return success(phone);
    }

    @GetMapping("/getOpenid")
    @ResponseBody
    public Map getOpenid(String code){
        String phone;
        try{
            phone = frontService.getOpenid(code);
        }catch (Exception e){
            return error(e.getMessage());
        }
        return success(phone);
    }



}

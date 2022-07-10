package com.ruoyi.web.controller.blinddate;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
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
     * 保存、修改用户注册信息
     * @param xqMember
     * @return
     */
    @PostMapping("/member_save")
    @ResponseBody
    public Map memberSave(@RequestBody XqMember xqMember){
        try{
            if(xqMember.getId() > 0){
                xqMemberService.updateXqMember(xqMember);
            }else{
                xqMemberService.insertXqMember(xqMember);
            }
        }catch (Exception e){
            return error(e.getMessage());
        }
        return success();
    }

    /**
     * 获取微信openid
     * @param openid
     * @return
     */
    @GetMapping("/getMemberbyOpenid")
    @ResponseBody
    public Map getMemberbyOpenid(String openid){
        AjaxResult ajaxResult;
        try{
            XqMember xqMember = xqMemberService.getMemberbyOpenid(openid);
            ajaxResult = success();
            if(xqMember != null && xqMember.getId() != null && xqMember.getId() > 0){
                ajaxResult.put(AjaxResult.DATA_TAG , xqMember);
            }else {
                throw new Exception("用户不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return ajaxResult;
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

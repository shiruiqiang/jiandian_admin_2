package com.ruoyi.web.controller.blinddate;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.XqMember;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IXqMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author shirq
 * @date 2022-07-02
 */
@RestController
@RequestMapping("/member/member")
public class XqMemberController extends BaseController
{
    @Autowired
    private IXqMemberService xqMemberService;

    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('member:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(XqMember xqMember)
    {
        startPage();
        List<XqMember> list = xqMemberService.selectXqMemberList(xqMember);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('member:member:export')")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XqMember xqMember)
    {
        List<XqMember> list = xqMemberService.selectXqMemberList(xqMember);
        ExcelUtil<XqMember> util = new ExcelUtil<XqMember>(XqMember.class);
        util.exportExcel(response, list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(xqMemberService.selectXqMemberById(id));
    }

    /**
     * 新增会员
     */
    @PreAuthorize("@ss.hasPermi('member:member:add')")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XqMember xqMember)
    {
        return toAjax(xqMemberService.insertXqMember(xqMember));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('member:member:edit')")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XqMember xqMember)
    {
        return toAjax(xqMemberService.updateXqMember(xqMember));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('member:member:remove')")
    @Log(title = "会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xqMemberService.deleteXqMemberByIds(ids));
    }
}

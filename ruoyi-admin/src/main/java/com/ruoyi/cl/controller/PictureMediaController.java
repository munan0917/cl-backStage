package com.ruoyi.cl.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.cl.domain.PictureMedia;
import com.ruoyi.cl.service.IPictureMediaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片管理Controller
 * 
 * @author zqn
 * @date 2023-04-26
 */
@RestController
@RequestMapping("/cl/clPicture")
public class PictureMediaController extends BaseController
{
    @Autowired
    private IPictureMediaService pictureMediaService;

    /**
     * 查询图片管理列表
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:list')")
    @GetMapping("/list")
    public TableDataInfo list(PictureMedia pictureMedia)
    {
        startPage();
        List<PictureMedia> list = pictureMediaService.selectPictureMediaList(pictureMedia);
        return getDataTable(list);
    }

    /**
     * 导出图片管理列表
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:export')")
    @Log(title = "图片管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PictureMedia pictureMedia)
    {
        List<PictureMedia> list = pictureMediaService.selectPictureMediaList(pictureMedia);
        ExcelUtil<PictureMedia> util = new ExcelUtil<PictureMedia>(PictureMedia.class);
        util.exportExcel(response, list, "图片管理数据");
    }

    /**
     * 获取图片管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pictureMediaService.selectPictureMediaById(id));
    }

    /**
     * 新增图片管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:add')")
    @Log(title = "图片管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PictureMedia pictureMedia)
    {
        return toAjax(pictureMediaService.insertPictureMedia(pictureMedia));
    }

    /**
     * 修改图片管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:edit')")
    @Log(title = "图片管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PictureMedia pictureMedia)
    {
        return toAjax(pictureMediaService.updatePictureMedia(pictureMedia));
    }

    /**
     * 删除图片管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clPicture:remove')")
    @Log(title = "图片管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pictureMediaService.deletePictureMediaByIds(ids));
    }
}

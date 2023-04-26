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
import com.ruoyi.cl.domain.VideoMedia;
import com.ruoyi.cl.service.IVideoMediaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频管理Controller
 * 
 * @author zqn
 * @date 2023-04-26
 */
@RestController
@RequestMapping("/cl/clVideo")
public class VideoMediaController extends BaseController
{
    @Autowired
    private IVideoMediaService videoMediaService;

    /**
     * 查询视频管理列表
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:list')")
    @GetMapping("/list")
    public TableDataInfo list(VideoMedia videoMedia)
    {
        startPage();
        List<VideoMedia> list = videoMediaService.selectVideoMediaList(videoMedia);
        return getDataTable(list);
    }

    /**
     * 导出视频管理列表
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:export')")
    @Log(title = "视频管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VideoMedia videoMedia)
    {
        List<VideoMedia> list = videoMediaService.selectVideoMediaList(videoMedia);
        ExcelUtil<VideoMedia> util = new ExcelUtil<VideoMedia>(VideoMedia.class);
        util.exportExcel(response, list, "视频管理数据");
    }

    /**
     * 获取视频管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(videoMediaService.selectVideoMediaById(id));
    }

    /**
     * 新增视频管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:add')")
    @Log(title = "视频管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VideoMedia videoMedia)
    {
        return toAjax(videoMediaService.insertVideoMedia(videoMedia));
    }

    /**
     * 修改视频管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:edit')")
    @Log(title = "视频管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VideoMedia videoMedia)
    {
        return toAjax(videoMediaService.updateVideoMedia(videoMedia));
    }

    /**
     * 删除视频管理
     */
    @PreAuthorize("@ss.hasPermi('cl:clVideo:remove')")
    @Log(title = "视频管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(videoMediaService.deleteVideoMediaByIds(ids));
    }
}

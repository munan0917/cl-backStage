package com.ruoyi.cl.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cl.mapper.VideoMediaMapper;
import com.ruoyi.cl.domain.VideoMedia;
import com.ruoyi.cl.service.IVideoMediaService;

/**
 * 视频管理Service业务层处理
 * 
 * @author zqn
 * @date 2023-04-26
 */
@Service
public class VideoMediaServiceImpl implements IVideoMediaService 
{
    @Autowired
    private VideoMediaMapper videoMediaMapper;

    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    @Override
    public VideoMedia selectVideoMediaById(Long id)
    {
        return videoMediaMapper.selectVideoMediaById(id);
    }

    /**
     * 查询视频管理列表
     * 
     * @param videoMedia 视频管理
     * @return 视频管理
     */
    @Override
    public List<VideoMedia> selectVideoMediaList(VideoMedia videoMedia)
    {
        return videoMediaMapper.selectVideoMediaList(videoMedia);
    }

    /**
     * 新增视频管理
     * 
     * @param videoMedia 视频管理
     * @return 结果
     */
    @Override
    public int insertVideoMedia(VideoMedia videoMedia)
    {
        String username = SecurityUtils.getUsername();
        videoMedia.setUserName(username);
        videoMedia.setIsDeleted(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        videoMedia.setGmtModified(date);
        videoMedia.setGmtCreate(date);
        return videoMediaMapper.insertVideoMedia(videoMedia);
    }

    /**
     * 修改视频管理
     * 
     * @param videoMedia 视频管理
     * @return 结果
     */
    @Override
    public int updateVideoMedia(VideoMedia videoMedia)
    {
        String username = SecurityUtils.getUsername();
        videoMedia.setUserName(username);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        videoMedia.setGmtModified(date);
        return videoMediaMapper.updateVideoMedia(videoMedia);
    }

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideoMediaByIds(Long[] ids)
    {
        return videoMediaMapper.deleteVideoMediaByIds(ids);
    }

    /**
     * 删除视频管理信息
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    @Override
    public int deleteVideoMediaById(Long id)
    {
        return videoMediaMapper.deleteVideoMediaById(id);
    }
}

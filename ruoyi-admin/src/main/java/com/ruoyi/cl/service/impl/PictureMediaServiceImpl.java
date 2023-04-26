package com.ruoyi.cl.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cl.mapper.PictureMediaMapper;
import com.ruoyi.cl.domain.PictureMedia;
import com.ruoyi.cl.service.IPictureMediaService;

/**
 * 图片管理Service业务层处理
 * 
 * @author zqn
 * @date 2023-04-26
 */
@Service
public class PictureMediaServiceImpl implements IPictureMediaService 
{
    @Autowired
    private PictureMediaMapper pictureMediaMapper;

    /**
     * 查询图片管理
     * 
     * @param id 图片管理主键
     * @return 图片管理
     */
    @Override
    public PictureMedia selectPictureMediaById(Long id)
    {
        return pictureMediaMapper.selectPictureMediaById(id);
    }

    /**
     * 查询图片管理列表
     * 
     * @param pictureMedia 图片管理
     * @return 图片管理
     */
    @Override
    public List<PictureMedia> selectPictureMediaList(PictureMedia pictureMedia)
    {

        return pictureMediaMapper.selectPictureMediaList(pictureMedia);
    }

    /**
     * 新增图片管理
     * 
     * @param pictureMedia 图片管理
     * @return 结果
     */
    @Override
    public int insertPictureMedia(PictureMedia pictureMedia)
    {
        String username = SecurityUtils.getUsername();
        pictureMedia.setUserName(username);
        pictureMedia.setIsDeleted(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        pictureMedia.setGmtCreate(date);
        pictureMedia.setGmtModified(date);
        return pictureMediaMapper.insertPictureMedia(pictureMedia);
    }

    /**
     * 修改图片管理
     * 
     * @param pictureMedia 图片管理
     * @return 结果
     */
    @Override
    public int updatePictureMedia(PictureMedia pictureMedia)
    {
        String username = SecurityUtils.getUsername();
        pictureMedia.setUserName(username);
        pictureMedia.setIsDeleted(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        pictureMedia.setGmtModified(date);
        return pictureMediaMapper.updatePictureMedia(pictureMedia);
    }

    /**
     * 批量删除图片管理
     * 
     * @param ids 需要删除的图片管理主键
     * @return 结果
     */
    @Override
    public int deletePictureMediaByIds(Long[] ids)
    {
        return pictureMediaMapper.deletePictureMediaByIds(ids);
    }

    /**
     * 删除图片管理信息
     * 
     * @param id 图片管理主键
     * @return 结果
     */
    @Override
    public int deletePictureMediaById(Long id)
    {
        return pictureMediaMapper.deletePictureMediaById(id);
    }
}

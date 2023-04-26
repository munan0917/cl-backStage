import request from '@/utils/request'

// 查询图片管理列表
export function listClPicture(query) {
  return request({
    url: '/cl/clPicture/list',
    method: 'get',
    params: query
  })
}

// 查询图片管理详细
export function getClPicture(id) {
  return request({
    url: '/cl/clPicture/' + id,
    method: 'get'
  })
}

// 新增图片管理
export function addClPicture(data) {
  return request({
    url: '/cl/clPicture',
    method: 'post',
    data: data
  })
}

// 修改图片管理
export function updateClPicture(data) {
  return request({
    url: '/cl/clPicture',
    method: 'put',
    data: data
  })
}

// 删除图片管理
export function delClPicture(id) {
  return request({
    url: '/cl/clPicture/' + id,
    method: 'delete'
  })
}

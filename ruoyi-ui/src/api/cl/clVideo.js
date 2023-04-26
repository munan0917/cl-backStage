import request from '@/utils/request'

// 查询视频管理列表
export function listClVideo(query) {
  return request({
    url: '/cl/clVideo/list',
    method: 'get',
    params: query
  })
}

// 查询视频管理详细
export function getClVideo(id) {
  return request({
    url: '/cl/clVideo/' + id,
    method: 'get'
  })
}

// 新增视频管理
export function addClVideo(data) {
  return request({
    url: '/cl/clVideo',
    method: 'post',
    data: data
  })
}

// 修改视频管理
export function updateClVideo(data) {
  return request({
    url: '/cl/clVideo',
    method: 'put',
    data: data
  })
}

// 删除视频管理
export function delClVideo(id) {
  return request({
    url: '/cl/clVideo/' + id,
    method: 'delete'
  })
}

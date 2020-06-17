package cn.org.dianjiu.security.controller;

import cn.org.dianjiu.security.common.req.TTaskReq;
import cn.org.dianjiu.security.common.vo.RespVO;
import cn.org.dianjiu.security.service.TTaskServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * 定时任务信息表(TTask)表控制层
 *
 * @author makejava
 * @since 2020-06-17 23:42:10
 */
@RestController
@RequestMapping("/tTask")
public class TTaskController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TTaskServiceI tTaskService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> getById(@PathVariable Long id) {
      RespVO<TTaskResp> result = new RespVO<>();
        TTaskResp tTaskResp = tTaskService.getById(id);
      if(null == tTaskResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tTaskResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tTaskReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> getByEntity(TTaskReq tTaskReq) {
      RespVO<TTaskResp> result = new RespVO<>();
        TTaskResp tTaskResp = tTaskService.getByEntity(tTaskReq);
      if(null == tTaskResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tTaskResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tTaskReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TTaskReq tTaskReq) {
        RespVO<List> result = new RespVO<>();
      List<TTaskResp> tTaskRespList = tTaskService.listByEntity(tTaskReq);
        if(null == tTaskRespList || tTaskRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tTaskRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tTaskReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> insert(@RequestBody @Validated TTaskReq tTaskReq){
        RespVO<TTaskResp> result = new RespVO<>();
      int insert = tTaskService.insert(tTaskReq);
        if(insert !=1 ){
            result.setCode("400");
            result.setMsg("新增数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("新增数据成功！");
        return result;
    }

   /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param tTaskReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> update(@RequestBody @Validated TTaskReq tTaskReq){
        RespVO<TTaskResp> result = new RespVO<>();
      int update = tTaskService.update(tTaskReq);
      if(update != 1){
            result.setCode("400");
            result.setMsg("更新数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("更新数据成功！");
        return result;
   }
   
   /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> deleteOne(@PathVariable Long id){
      RespVO<TTaskResp> result = new RespVO<>();
        int delete = tTaskService.deleteById(id);
      if(delete != 1){
            result.setCode("400");
            result.setMsg("删除数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("删除数据成功！");
        return result;
    }

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param ids 实例对象
     * @return 实例对象
     */
    @DeleteMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TTaskResp> deleteBatch(@RequestBody List<Long> ids){
        RespVO<TTaskResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tTaskService.deleteByIds(ids);
      }
      if(dels <= 0){
            result.setCode("400");
            result.setMsg("批量删除数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("批量删除数据成功！");
        return result;
    }

}
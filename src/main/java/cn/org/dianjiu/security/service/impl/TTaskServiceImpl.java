package cn.org.dianjiu.security.service.impl;

import cn.org.dianjiu.security.dao.TTaskDao;
import cn.org.dianjiu.security.service.TTaskServiceI;
import cn.org.dianjiu.security.entity.TTask;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.List;

/**
 * 定时任务信息表(TTask)表服务实现类
 *
 * @author makejava
 * @since 2020-06-17 23:42:10
 */
@Slf4j
@Service
public class TTaskServiceImpl implements TTaskServiceI {

    @Autowired
    private TTaskDao tTaskDao;

    public TTaskResp getById(Long id) {
        TTaskResp tTaskResp = new TTaskResp();
        TTask tTask = tTaskDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tTask)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tTask,tTaskResp);
        return tTaskResp;
    }

    public TTaskResp getByEntity(TTaskReq tTaskReq) {
      TTaskResp tTaskResp = new TTaskResp();
        TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        TTask tTask1 = tTaskDao.getByEntity(tTask);
        if(ObjectUtils.checkObjAllFieldsIsNull(tTask1)){
            log.error("根据tTaskReq【"+tTaskReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tTask1,tTaskResp);
        return tTaskResp;
    }

    public List<TTaskResp> listByEntity(TTaskReq tTaskReq) {
        List<TTaskResp> list = new ArrayList<>();
        TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        List<TTask> tTasks = tTaskDao.listByEntity(tTask);
        if(null == tTasks || tTasks.isEmpty()){
            log.error("根据tTaskReq【"+tTaskReq+"】没有查到相关记录！");
            return list;
        }
        for (TTask tTask1 : tTasks ) {
            TTaskResp tTaskResp = new TTaskResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tTask1)){
                log.error("根据tTaskReq【"+tTaskReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tTask1,tTaskResp);
            list.add(tTaskResp);
        }
        return list;
    }

    public List<TTaskResp> listByIds(List<Long> ids) {
      List<TTaskResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TTask> tTasks  = tTaskDao.listByIds(ids);
        if(null != tTasks && !tTasks.isEmpty()){
            for (TTask tTask1 : tTasks ) {
                TTaskResp tTaskResp = new TTaskResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tTask1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tTask1,tTaskResp);
                list.add(tTaskResp);
            }
        }
        return list;
    }

    public int insert(TTaskReq tTaskReq) {
      TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        Date date = new Date();
        tTask.setCreateTime(date);
        tTask.setUpdateTime(date);
        return tTaskDao.insert(tTask);
    }

    public int insertBatch(List<TTaskReq> list) {
      List<TTask> tTasks = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TTaskReq tTaskReq : list) {
            TTask tTask = new TTask();
            if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tTaskReq,tTask);
            tTasks.add(tTask);
        }
        return tTaskDao.insertBatch(tTasks);
    }

    public int update(TTaskReq tTaskReq) {
      TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        tTask.setUpdateTime(new Date());
        return tTaskDao.update(tTask);
    }

    public int updateBatch(List<TTaskReq> list) {
      List<TTask> tTasks = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TTaskReq tTaskReq : list) {
            TTask tTask = new TTask();
            if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tTaskReq,tTask);
            tTasks.add(tTask);
        }
        return tTaskDao.updateBatch(tTasks);
    }

    public int deleteById(Long id) {
        return tTaskDao.deleteById(id);
    }

    public int deleteByEntity(TTaskReq tTaskReq) {
      TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        return tTaskDao.deleteByEntity(tTask);
    }
  
    public int deleteByIds(List<Long> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tTaskDao.deleteByIds(ids);
    }

    public int countAll() {
        return tTaskDao.countAll();
    }
    
    public int countByEntity(TTaskReq tTaskReq) {
      TTask tTask = new TTask();
        if(ObjectUtils.checkObjAllFieldsIsNull(tTaskReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tTaskReq,tTask);
        return tTaskDao.countByEntity(tTask);
    }

}
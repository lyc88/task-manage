package cn.org.dianjiu.security.controller;

import cn.org.dianjiu.security.common.vo.RespVO;
import com.example.quartz.config.response.Response;
import com.example.quartz.service.JobManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * job操作Controller
 *
 * @author DianJiu
 * @date 2019/4/9
 */
@RestController
@RequestMapping(value = "/quartz/task")
public class JobController {

    @Autowired
    private TQuartzTaskDetailsServiceI tQuartzTaskDetailsService;

    @RequestMapping(value = "/pause", method = RequestMethod.POST)
    public RespVO pauseJob(@RequestParam(name = "jobName") String jobName,
                           @RequestParam(name = "jobGroup") String jobGroup) {

        jobManageService.pauseJob(jobName, jobGroup);
        return Response.success();
    }

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public RespVO resumeJob(@RequestParam(name = "jobName") String jobName,
                              @RequestParam(name = "jobGroup") String jobGroup) {

        jobManageService.resumeJob(jobName, jobGroup);
        return Response.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RespVO deleteJob(@RequestParam(name = "jobName") String jobName,
                              @RequestParam(name = "jobGroup") String jobGroup) {

        jobManageService.deleteJob(jobName, jobGroup);
        return Response.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RespVO updateJob(@RequestParam(name = "jobName") String jobName,
                              @RequestParam(name = "jobGroup") String jobGroup,
                              @RequestParam(name = "cronExpression") String cronExpression) {

        jobManageService.updateCronExpression(jobName, jobGroup, cronExpression);
        return Response.success();
    }

}

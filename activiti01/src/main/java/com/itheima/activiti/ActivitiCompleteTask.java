package com.itheima.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * @author : Hiccup
 * create at : 2020/9/16 11:10 下午
 * description :
 * remark : 处理当前用户的任务
 * 背后影响的表:
 * act_hi_actinst
 * act_hi_identitylink
 * act_hi_taskinst
 * act_ru_identitylink
 * act_ru_task
 **/
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        // 处理7505任务
        taskService.complete("2505");
    }
}

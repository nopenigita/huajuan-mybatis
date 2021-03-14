package com.itheima.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author : Hiccup
 * create at : 2020/9/16 10:39 下午
 * description :
 * remark : 流程实例启动 前提完成流程定义部署
 *  背后影响的表:
 *  act_hi_actinst 已完成的活动信息
 *  act_hi_identitylink 参与者信息
 *  act_hi_procinst 流程实例
 *  act_hi_taskinst 任务实例
 *  act_ru_execution 执行表
 *  act_ru_identitylink 参与者信息
 *  act_ru_task 任务
 **/
public class ActivitiStartInstance {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        System.out.println("流程部署ID:" + processInstance.getDeploymentId());
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("业务ID:" + processInstance.getBusinessKey());
        System.out.println("活动ID:" + processInstance.getActivityId());
    }
}

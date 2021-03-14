package com.itheima.day03_activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author : Hiccup
 * create at : 2020/9/17 5:02 下午
 * description :
 * remark : 单个流程实例挂起与激活
 **/
public class SuspendProcessInstance2 {
    public static void main(String[] args) {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 查询流程实例的对象
        ProcessInstance holiday = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("holiday").singleResult();
        String id = holiday.getId();
        // 得到当前流程实例是否为暂停状态
        boolean b = holiday.isSuspended();
        System.out.println(b);
        if (b){
            // 如果是暂停状态,就可以激活操作
            runtimeService.activateProcessInstanceById(id);
            System.out.println("流程实例=" + id + "被激活");
        } else {
            // 如果是激活状态,就可以暂停操作
            runtimeService.suspendProcessInstanceById(id);
            System.out.println("流程实例=" + id + "被挂起");
        }
    }
}

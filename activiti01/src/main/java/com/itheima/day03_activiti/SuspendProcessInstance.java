package com.itheima.day03_activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * @author : Hiccup
 * create at : 2020/9/17 5:02 下午
 * description :
 * remark : 全部流程实例挂起与激活
 **/
public class SuspendProcessInstance {
    public static void main(String[] args) {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 查询流程定义的对象
        ProcessDefinition holiday = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday").singleResult();
        // 得到当前流程定义中的实例是否都为暂停状态
        boolean suspended = holiday.isSuspended();
        System.out.println(suspended);
        if (suspended){
            // 如果是暂停状态,就可以激活操作
            repositoryService.activateProcessDefinitionById(holiday.getId(), true, null);
            System.out.println("流程定义=" + holiday.getId() + "被激活");
        } else {
            // 如果是激活状态,就可以暂停操作
            repositoryService.suspendProcessDefinitionById(holiday.getId(), true, null);
            System.out.println("流程定义=" + holiday.getId() + "被挂起");
        }
    }
}

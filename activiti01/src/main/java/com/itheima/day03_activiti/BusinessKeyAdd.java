package com.itheima.day03_activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author : Hiccup
 * create at : 2020/9/17 4:41 下午
 * description :
 * remark :
 **/
public class BusinessKeyAdd {
    public static void main(String[] args) {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 启动流程实例,同时指定业务标识BusinessKey 它本身就是请假单的ID
        // 第一个参数是指流程定义的Key
        // 第二个参数是业务标识
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "1001");
        // 输出processInstance相关的属性
        System.out.println("业务标识 = " + processInstance.getBusinessKey());
    }
}

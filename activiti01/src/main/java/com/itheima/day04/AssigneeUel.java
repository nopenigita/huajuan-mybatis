package com.itheima.day04;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Hiccup
 * create at : 2020/9/17 8:05 下午
 * description : 启动流程实例,动态设置Assignee
 * remark :
 **/
public class AssigneeUel {
    public static void main(String[] args) {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 设置Assignee的取值
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0", "花卷");
        map.put("assignee1", "黎洛");
        map.put("assignee2", "图图");
        // 启动流程实例,同时还要设置流程定义Assignee值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday1", map);
        System.out.println("processInstance.getName() = " + processInstance.getName());
    }
}

package com.itheima.day03_activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author : Hiccup
 * create at : 2020/9/17 10:02 上午
 * description :
 * remark : 查询已经部署的流程定义
 **/
public class QueryProcessDefinition {
    public static void main(String[] args) {
        // 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 得到ProcessDefinitionQuery对象,可以认为它就是一个查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 设置条件,并查询出当前的所有流程定义
        List<ProcessDefinition> holiday = processDefinitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion()
                .desc().list();
        // 输出流程定义信息
        for (ProcessDefinition processDefinition : holiday) {
            System.out.println("流程定义ID = " + processDefinition.getId());
            System.out.println("流程定义名称 = " + processDefinition.getName());
            System.out.println("流程定义Key = " + processDefinition.getKey());
            System.out.println("流程定义版本号 = " + processDefinition.getVersion());
            System.out.println("流程定义部署ID = " + processDefinition.getDeploymentId());
        }
    }
}

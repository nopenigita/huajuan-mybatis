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
 * remark : 删除已经部署的流程定义
 * 背后影响的表:
 * act_ge_bytearray
 * act_re_deployment
 * act_re_procdef
 * 当我们正在执行的这一套流程没有完全审批结束的时候,此时如果要删除流程定义就会失败
 **/
public class DeleteProcessDefinition {
    public static void main(String[] args) {
        // 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 执行删除流程定义 参数代表流程部署的id
        repositoryService.deleteDeployment("1");
        // 参数true代表级联删除,此时就会删除没有完成的流程节点,最后删除流程定义信息
        // repositoryService.deleteDeployment("1", true);
    }
}

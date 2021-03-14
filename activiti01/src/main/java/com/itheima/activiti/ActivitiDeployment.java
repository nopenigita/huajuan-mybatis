package com.itheima.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @Author : Hiccup
 * create at : 2020/10/14 20:33 下午
 * description :
 * remark : 流程部署
 * 背后影响的表:
 * act_ge_bytearray
 * act_re_deployment
 * act_re_procdef
 **/
public class ActivitiDeployment {

    /** 流程定义部署
     * @param args
     */
    public static void main(String[] args) {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 进行部署
        Deployment deploy = repositoryService.createDeployment()
                .disableSchemaValidation()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请流程")
                .deploy();
        // 输出部署的信息
        System.out.println(deploy.getName());
        System.out.println(deploy.getId());

    }
}

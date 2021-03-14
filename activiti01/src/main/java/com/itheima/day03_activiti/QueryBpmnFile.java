package com.itheima.day03_activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : Hiccup
 * create at : 2020/9/17 2:33 下午
 * description :
 * remark : 从activiti的act_ge_bytearray表中读取两个资源文件 保存到/Users/huajuan/Downloads
 * 技术方案:
 * 1.使用activiti的api来实现
 * 2.可以使用jdbc对blob类型,clob类型数据的读取,并保存
 * 3.IO流转换,最好commons-io.jar可以轻松解决IO操作
 * 真实应用场景:用户想查看这个请假流程具体有哪些步骤要走?
 **/
public class QueryBpmnFile {
    public static void main(String[] args) throws IOException {
        // 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 得到查询器:流程定义信息
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday");
        // 执行查询操作,查询出想要的流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        // 通过流程定义信息,得到部署的ID
        String deploymentId = processDefinition.getDeploymentId();
        // 通过repositoryService的方法,实现读取图片信息及bpmn文件信息(输入流)
        // processDefinition.getDiagramResourceName() 获取png图片资源的名称
        // processDefinition.getResourceName() 获取bpmn资源的名称
        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        // 构建出OutputStream流
        FileOutputStream pngOs = new FileOutputStream("/Users/huajuan/Downloads/holiday.png");
        FileOutputStream bpmnOs = new FileOutputStream("/Users/huajuan/Downloads/holiday.bpmn");
        // 输入流,输出流的转换
        IOUtils.copy(pngIs, pngOs);
        IOUtils.copy(bpmnIs, bpmnOs);
        // 关闭流
        pngOs.close();
        bpmnOs.close();
        pngIs.close();
        bpmnIs.close();
    }
}

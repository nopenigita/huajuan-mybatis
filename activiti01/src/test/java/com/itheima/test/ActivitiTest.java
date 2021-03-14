package com.itheima.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author : Hiccup
 * create at : 2020/9/16 8:52 下午
 * description :
 * remark : 测试Activiti所需要的25张表的生成
 **/
public class ActivitiTest {

    @Test
    public void testGenTable() {
        // 创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.
                createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 输出processEngine对象
        System.out.println(processEngine);
    }

}

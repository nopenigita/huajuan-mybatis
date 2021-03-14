package com.itheima.day03_activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;

import java.util.List;

/**
 * @author : Hiccup
 * create at : 2020/9/17 3:36 下午
 * description :
 * remark : 历史数据的查看
 **/
public class HistoryQuery {
    public static void main(String[] args) {
        // 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到HistoryService对象
        HistoryService historyService = processEngine.getHistoryService();
        // 得到HistoricActivityInstanceQuery查询器
        HistoricActivityInstanceQuery hisQuery = historyService.createHistoricActivityInstanceQuery();
        // 设置查询条件
        hisQuery.processInstanceId("2501");
        // 执行查询
        List<HistoricActivityInstance> list = hisQuery.orderByHistoricActivityInstanceStartTime().asc().list();
        // 遍历查询结果
        for (HistoricActivityInstance instance : list) {
            System.out.println("instance = " + instance.getActivityId());
            System.out.println("instance = " + instance.getActivityName());
            System.out.println("instance = " + instance.getProcessInstanceId());
            System.out.println("instance = " + instance.getProcessDefinitionId());
            System.out.println("------------------------");
        }
    }
}

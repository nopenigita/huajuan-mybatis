package com.huajuan.domain;

import org.apache.log4j.Logger;

/**
 * @author : huajuan
 * create at : 2019-05-16 00:12
 * description :
 * remark :
 * @program: day01_mybaits
 **/
public class test1 {
    private static Logger logger = Logger.getLogger(test.class);
    private static Logger logger1 = Logger.getLogger("FILE1");
    public static void main(String[] args) {
        logger.info("===info====");
        logger1.info("new info");

    }
}

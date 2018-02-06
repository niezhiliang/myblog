package com.suyu.alioss.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OssUtilTest {
    @Autowired
    private OssUtil ossUtil;
    @Test
    public void testupload1() {
        String paht = "/Users/suyu/Pictures/test.png";
        String key = "test";
        //ossUtil.upload(paht,key);
    }

}
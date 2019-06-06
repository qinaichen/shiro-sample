package com.cns.shiro;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.junit.Test;

public class TestShiro {

    @Test
    public void test01(){
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformat;

import multiformat.models.TestBeachBean;
import multiformat.models.TestStoryBean;
import multiformat.models.TestUserBean;

/**
 *
 * @author slewis
 */
public class BeanFactory {

    public static Class getBeanClass(String type) {

        if ("Beach".equalsIgnoreCase(type)) {
            return new TestBeachBean().getClass();
        } else if ("Story".equalsIgnoreCase(type)) {
            return new TestStoryBean().getClass();
        } else if ("User".equalsIgnoreCase(type)) {
            return new TestUserBean().getClass();
        }
        return null;
    }

    public static Object getBeanInstance(String type) {

        if ("Beach".equalsIgnoreCase(type)) {
            return new TestBeachBean();
        } else if ("Story".equalsIgnoreCase(type)) {
            return new TestStoryBean();
        } else if ("User".equalsIgnoreCase(type)) {
            return new TestUserBean();
        }
        return null;

    }
}

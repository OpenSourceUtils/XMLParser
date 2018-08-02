package com.boonya.xmlparser;

import com.boonya.xmlparser.dom.DomReader;
import com.boonya.xmlparser.dom4j.Dom4jReader;
import com.boonya.xmlparser.jdom.JDomReader;
import com.boonya.xmlparser.sax.SAXReader;

/**
 * @ClassName: MainTest
 * @Description: TODO(XML解析测试)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-08-01
 */
public class MainTest {

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Dom4j-------------------------------");
        Dom4jReader dom4jReader=new Dom4jReader();
        dom4jReader.parser();

        System.out.println("Dom-------------------------------");
        DomReader domReader=new DomReader();
        domReader.parser();

        System.out.println("Jdom-------------------------------");
        JDomReader jDomReader=new JDomReader();
        jDomReader.parser();

        System.out.println("SAX-------------------------------");
        SAXReader saxReader=new SAXReader();
        saxReader.parser();
    }
}

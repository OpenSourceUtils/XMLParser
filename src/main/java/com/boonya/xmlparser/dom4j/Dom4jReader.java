package com.boonya.xmlparser.dom4j;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * @ClassName: Dom4jReader
 * @Description: TODO(DOM4J解析)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-08-01
 */
public class Dom4jReader {
    
    public void parser(){
        long lasting = System.currentTimeMillis();
        try {
            String path = this.getClass().getResource("/test.xml").getPath();
            File f = new File(path);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("VALUE"); i.hasNext();) {
                foo = (Element) i.next();
                System.out.print("车牌号码:" + foo.elementText("NO"));
                System.out.println(" 车主地址:" + foo.elementText("ADDR"));
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + " 毫秒");
    }
}

package com.boonya.xmlparser.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName: DomParser
 * @Description: TODO(DOM解析)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-08-01
 */
public class DomReader {
    
    public void parser(){
        long start =System.currentTimeMillis();
        try{
            String path = this.getClass().getResource("/test.xml").getPath();
            File f = new File(path);
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList nl = doc.getElementsByTagName("VALUE");
            for (int i=0;i<nl.getLength();i++){
                System.out.print("车牌号码:" + doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
                System.out.println(" 车主地址:" + doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("运行时间："+(System.currentTimeMillis() - start)+" 毫秒");
    }

}

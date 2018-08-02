package com.boonya.xmlparser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * @ClassName: SAXParser
 * @Description: TODO(SAX解析)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-08-01
 */
public class SAXReader extends DefaultHandler{

    java.util.Stack tags = new java.util.Stack();

    public void parser() {
        long start = System.currentTimeMillis();
        try {
            SAXParserFactory sf = SAXParserFactory.newInstance();
            SAXParser sp = sf.newSAXParser();
            SAXReader reader = new SAXReader();
            String path = this.getClass().getResource("/test.xml").getPath();
            sp.parse(new InputSource(path), reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("运行时间：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String tag = (String) tags.peek();
        String value=new String(ch, start, length).trim();
        if (tag.equals("NO")&&value.length()>0) {
            System.out.println("车牌号码：" + value);
        }
        if (tag.equals("ADDR")&&value.length()>0) {
            System.out.println("地址:" + value);
        }
    }

    @Override
    public void startElement(String uri,String localName,String qName,Attributes attrs) {
       tags.push(qName);
    }
}

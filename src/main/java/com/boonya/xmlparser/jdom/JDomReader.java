package com.boonya.xmlparser.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.util.List;

/**
 * @ClassName: JDomReader
 * @Description: TODO(JDOM解析)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-08-01
 */
public class JDomReader {
    
    public void parser(){
        long start = System.currentTimeMillis();
        try {
            SAXBuilder builder = new SAXBuilder();
            String path = this.getClass().getResource("/test.xml").getPath();
            File f = new File(path);
            Document doc = builder.build(f);
            Element foo = doc.getRootElement();
            List allChildren = foo.getChildren();
            for(int i=0;i<allChildren.size();i++) {
                System.out.print("车牌号码:" + ((Element)allChildren.get(i)).getChild("NO").getText());
                System.out.println(" 车主地址:" + ((Element)allChildren.get(i)).getChild("ADDR").getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("运行时间：" + (System.currentTimeMillis() - start) + " 毫秒");
    }
}

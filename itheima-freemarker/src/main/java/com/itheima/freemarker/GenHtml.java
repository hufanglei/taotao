package com.itheima.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenHtml {

    private static final String diretorypath = "E:\\workspace\\mvc\\2\\taotao\\itheima-freemarker\\src\\main\\resources\\template";
    private static final String prehtmlfilepath = "E:\\workspace\\mvc\\2\\taotao\\itheima-freemarker\\src\\main\\resources\\html";

    //生成静态页面的方法
    @Test
    public void testFreeMarker() throws Exception{
        //1.创建个configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.设置模板文件所在的路径的目录
        configuration.setDirectoryForTemplateLoading(new File(diretorypath));
        //3.设置模板文件的字符集
        configuration.setDefaultEncoding("utf-8");
        //4.首先创建模板文件，再加载模板文件 模板文件的后缀官方提供是.ftl 其实任何类型都行。
        Template template = configuration.getTemplate("template.htm");//相对路径
        //5.创建模板文件需要展示数据的数据集对象，可以使用POJO，也可以使用map 一般是使用map
        Map model = new HashMap<>();

        Person person1 = new Person(1L, "嬴荡");
        Person person2 = new Person(2L, "嬴政");
        Person person3 = new Person(3L, "嬴稷");
       //对象
        model.put("person1", person1);
        model.put("person2", person2);
        model.put("person3", person3);
        //集合
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        model.put("list",list);

        //测试map
        Map<String, Person> map = new HashMap<>();
        map.put("m1", new Person(1L,"大乔"));
        map.put("m2", new Person(1L,"貂蝉"));
        map.put("m3", new Person(3L,"貂蝉"));
        model.put("map",map);
        //6.创建一个FileWriter对象 指定生成的静态文件的文件路径及文件名
        //拼接一个前缀和后缀
        FileWriter writer = new FileWriter(new File(prehtmlfilepath+"/person.html"));
        //7.调用模板对象的process方法，执行输出文件。
        template.process(model, writer);
        //8.关闭流
        writer.close();
    }


}

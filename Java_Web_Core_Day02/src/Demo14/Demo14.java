package Demo14;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/demo14")
public class Demo14 extends HttpServlet {
    private ArrayList<Student> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Map<String, String[]> parameterMap = req.getParameterMap();

        Class<Student> studentClass = Student.class;
        try {
            Student student = studentClass.newInstance();
            for (String s : parameterMap.keySet()) {
                Field declaredField = studentClass.getDeclaredField(s);
                declaredField.setAccessible(true);
                String[] values = parameterMap.get(s);
                declaredField.set(student, values[0]);
            }
            System.out.println(student);
            list.add(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.getWriter().println("保存成功！");
        resp.setHeader("refresh", "2;url=/Java_Web_Core_Day02/SaveStu.html");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Documents/Programming/Source_Codes/Java_Learning_In_Heima/Learn_Java_Web/Java_Web_Core_Day02/src/Demo14/Stu.txt", true));
        for (Student student : list) {
            bufferedWriter.write(student.getName() + "," + student.getAge() + "," + student.getScore());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}

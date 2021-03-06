package Demo3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo3 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Initialize a servlet instance");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Extend HttpServlet And Override doGet method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Extend HttpServlet And Override doPost method");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy the servlet instance");
    }
}

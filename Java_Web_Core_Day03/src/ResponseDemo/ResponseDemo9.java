package ResponseDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/ResponseDemo9")
public class ResponseDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        String encode = URLEncoder.encode(filename);
        ServletContext servletContext = getServletContext();
//        resp.setHeader("content-type", servletContext.getMimeType(encode));
        resp.setHeader("content-disposition", "attachment;filename=" + encode);
        InputStream resourceAsStream = servletContext.getResourceAsStream("/downloads/" + encode);
        ServletOutputStream outputStream = resp.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        while ((len = resourceAsStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        resourceAsStream.close();
    }
}

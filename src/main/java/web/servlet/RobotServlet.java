package web.servlet;

import com.context.RobotSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2018/3/24.
 */
@WebServlet(name="robot",urlPatterns="/robot")
public class RobotServlet extends HttpServlet {
    private static RobotSingleton robotSingleton = RobotSingleton.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
        request.setCharacterEncoding("utf-8"); //设置通过post方法进行传参的字符集
        String question = request.getParameter("question");
        String result = robotSingleton.input(question);
        System.out.println("返回结果 : " + result);
        response.getWriter().write(result);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}

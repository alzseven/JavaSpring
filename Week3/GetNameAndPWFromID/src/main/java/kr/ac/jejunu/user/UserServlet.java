package kr.ac.jejunu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import java.io.IOException;

@Controller("/userServlet")
public class UserServlet extends GenericServlet {
    @Autowired
    private UserDao userDao;
    @Override
    public void destroy() {
        System.out.println("*************** destroy *****************");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
        userDao = applicationContext.getBean("userDao",UserDao.class);
        System.out.println("*************** init *****************");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = userDao.findById(id);
        res.setContentType("text/html; charset=UTF-8");
        System.out.println("*************** service *****************");
        StringBuilder response = new StringBuilder();
        response.append("<html>");
        response.append("<body>");
        response.append("<h1>");
        response.append(String.format("Hello %s !!!", user.getName()));
        response.append("<h1>");
        response.append("</body>");
        response.append("</html>");
        res.getWriter().println(response.toString());


    }
}

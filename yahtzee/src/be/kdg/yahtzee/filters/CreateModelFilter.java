package be.kdg.yahtzee.filters;

import be.kdg.yahtzee.model.YahtzeeController;

import javax.servlet.*;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CreateModelFilter implements Filter {
    private ServletContext servletContext;

    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        findModel();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void findModel() {
        // Get spring bean factory and put through to controller
        /*
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        BeanFactory beanFactory = (BeanFactory)ctx;

        YahtzeeController yahtzeeController = (YahtzeeController) servletContext.getAttribute("yahtzeeController");
        if (yahtzeeController == null) {
            yahtzeeController = new YahtzeeController(beanFactory);
            servletContext.setAttribute("yahtzeeController", yahtzeeController);
        }   */

        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        BeanFactory beanFactory = (BeanFactory)ctx;

        YahtzeeController yahtzeeController = (YahtzeeController) beanFactory.getBean("yahtzeeController");
        yahtzeeController.populate();
    }

    public void destroy() {
    }

}

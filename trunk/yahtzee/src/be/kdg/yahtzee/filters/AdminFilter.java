/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.filters;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter class for protecting hidden pages.
 * If no userBean is detected, the visitor is redirected to the login page.
 * Players are redirected to the game page.
 */
public class AdminFilter implements Filter {
    private ServletContext application;

    /**
     * Initiates the filter class.
     *
     * @param filterConfig filterConfig object
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        application = filterConfig.getServletContext();
    }

    /**
     * Main filter method.
     * Userbean is requested, if none found user is redirected to login.
     * If user is player, user is redirected to game page.
     *
     * @param servletRequest  servletRequest object.
     * @param servletResponse servletResponse object.
     * @param filterChain     filterChain object.
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("userBean") != null) {
            UserBean userBean = (UserBean) session.getAttribute("userBean");

            YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
            be.kdg.yahtzee.model.remoteObjects.YahtzeeController yahtzeeController = null;
            try {
                yahtzeeController = serviceLocator.getyahtzee();
            } catch (javax.xml.rpc.ServiceException e) {

            }

            if (yahtzeeController.isAdministrator(userBean.getUsername())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                if (yahtzeeController.isPlayer(userBean.getUsername())) {
                    ((HttpServletResponse) servletResponse).sendRedirect("/player/gameRoom.jsp");
                } else {
                    ((HttpServletResponse) servletResponse).sendRedirect("/");
                }
            }
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        }
    }

    /**
     * Method to destroy filter.
     */
    public void destroy() {
    }
}

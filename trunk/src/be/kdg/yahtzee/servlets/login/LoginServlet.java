package be.kdg.yahtzee.servlets.login;

import be.kdg.yahtzee.servlets.YahtzeeServlet;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.util.Security;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.beans.OnlineUsersBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class LoginServlet extends YahtzeeServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = Security.getInstance().encrypt(password);
        YahtzeeController yahtzeeController = findYahtzeeController();

        User user = yahtzeeController.findUser(username);
        boolean loginOK = user.getPassword().equals(password);

        OnlineUsersBean onlineUsersBean = findOnlineUsersBean();
        onlineUsersBean.addUser(user);

        if (loginOK){
            maakObjectenAan(request, username, yahtzeeController);
            forwardUser(request, response, username, yahtzeeController);
        }else{
            foutBoodschap(request, response, 0);
        }
    }

    private void maakObjectenAan(HttpServletRequest request, String username, YahtzeeController yahtzeeController){
        UserBean userBean = new UserBean(yahtzeeController, username);
        HttpSession session = request.getSession();
        session.setAttribute("userBean", userBean);
    }

    private void forwardUser(HttpServletRequest request,HttpServletResponse response, String username, YahtzeeController yahtzeeController)throws ServletException, IOException{
        if (yahtzeeController.isPlayer(username)) {
            System.out.println("user is a player");
            Set<Object> games =  new HashSet<Object>(yahtzeeController.getGames());
            HttpSession session = request.getSession();
            session.setAttribute("games", games);
            OnlineUsersBean onlineUsersBean = findOnlineUsersBean();
            List onlineUsers = onlineUsersBean.getUsers();
            session.setAttribute("onlineUsers", onlineUsers);
            response.sendRedirect("/player/gameRoom.jsp");
        } else if (yahtzeeController.isAdministrator(username)) {
            System.out.println("user is an administrator");
            response.sendRedirect("/admin/administrator.jsp");
        } else {
            foutBoodschap(request, response, 0);
        }
    }

    private void foutBoodschap(HttpServletRequest request, HttpServletResponse response, long seconden){
        request.setAttribute("seconden", seconden);
        request.setAttribute("fout", "U bent er niet in geslaagd om juist in te loggen. De oorzaak kan zijn: <br> Verkeerde username of password <br>");
        forward("/login/loginError.jsp", request, response);
    }
}

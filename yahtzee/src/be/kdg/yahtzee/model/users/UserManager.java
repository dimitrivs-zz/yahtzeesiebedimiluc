/*
Exeption handeling: OK
Logging: OK
Java 5: OK
Refacorting: 1 geel lijntje niet mogelijk weg te werken 
Testen: OK
 */

package be.kdg.yahtzee.model.users;

import be.kdg.util.Security;
import be.kdg.yahtzee.dao.RoleDao;
import be.kdg.yahtzee.dao.UserDao;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.util.*;


public class UserManager {
    private static Logger logger = Logger.getLogger(UserManager.class);
    static final String FILENAME = "UserManagerLog.txt";

    private UserDao userDao;
    private RoleDao roleDao;
    private Set<User> users = new HashSet<User>();

    private Map<String, Role> roles = new HashMap<String, Role>();

    public void initLogger(Level level) {
        SimpleLayout layout = new SimpleLayout();

        FileAppender appender = null;
        try {
            appender = new FileAppender(layout, FILENAME, false);
        } catch (Exception e) {
            // empty catch block!
        }

        logger.addAppender(appender);
        logger.setLevel(level);
    }

    // ---------- User methoden

    // --- Nodig voor beans

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        for (Object o : userDao.getUsers()) {
            User user = (User) o;
            users.add(user);
        }
    }

    // ----getMethoden

    public List<User> getUsers() {
        return Collections.unmodifiableList(userDao.getUsers());
    }

    public List<User> getOnlineUsers() {
        List<User> onlineUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.isOnline()) {
                onlineUsers.add(user);
            }
        }
        return onlineUsers;
    }

    public List<User> getUsersByKeyword(String keyword) {
        List<User> foundUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getUsername().contains(keyword)) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return User.NULL_USER;
    }

    // --- createMethoden

    private User createUser(String username, String plainPassword, String surname, String firstName, String email, String telephone, Role role, Address address) {
        Security security = Security.getInstance();
        User user = new User(username, security.encrypt(plainPassword), surname, firstName, email, telephone, role, address);
        if (!users.contains(user)) {
            userDao.saveUser(user);
            users.add(user);
        }
        logger.info("User " + user.getUsername() + " created");
        return user;
    }

    public User createAdministrator(String username, String plainPassword, String surname, String firstName, String email, String telephone, Address address) {
        Role role = roles.get("Administrator");
        logger.info("Administrator " + username + " created");
        return createUser(username, plainPassword, surname, firstName, email, telephone, role, address);
    }

    public User createPlayer(String username, String plainPassword, String surname, String firstName, String email, String telephone, Address address) {
        Role role = roles.get("Player");
        logger.info("Player " + username + " created");
        return createUser(username, plainPassword, surname, firstName, email, telephone, role, address);
    }

    // --- changeMethoden

    public User changeUser(User orgUser, String surname, String firstName, String email, String telephone, Address address, Role role) {
        orgUser.setAddress(address);
        orgUser.setFirstname(firstName);
        orgUser.setSurname(surname);
        orgUser.setTelephone(telephone);
        orgUser.getPerson().setEmail(email);
        orgUser.setRole(role);
        userDao.saveUser(orgUser);
        logger.info("User " + orgUser.getUsername() + " changed profile");
        return orgUser;
    }

    public boolean changePassword(User user, String orgPass, String password, String password2) {
        Security security = Security.getInstance();
        if (user.getPassword().equals(security.encrypt(orgPass))) {
            if (password.equals(password2)) {
                user.setPassword(security.encrypt(password));
                userDao.saveUser(user);
                logger.info("User " + user.getUsername() + " changed his password");
                return true;
            }
        }
        logger.info("User " + user.getUsername() + " failed to change his password");
        return false;
    }
    /*
    public User changePlayer(User user, String username, String surname, String firstName, String email, String telephone, Address address) {
        return changeUser(user, surname, firstName, email, telephone, address);
    } */
    /*
  public void changePassword(User user, String orgPass, String password, String password2) {
      changeUserPassword(user, orgPass, password, password2);
  }  */
    /*
    public void changePassword(User user, String password, String password2) {
        changeUserPassword(user, password, password2);
    }

    private void changeUserPassword(User user, String password, String password2) {
        Security security = Security.getInstance();

        if (password.equals(password2)) {
            user.setPassword(security.encrypt(password));
            userDao.saveUser(user);
        }
    } */

    // --- removeMethoden

    public void removeUser(String username) {
        User user = getUser(username);
        users.remove(user);
        userDao.deleteUser(user);
        logger.info("User " + user.getUsername() + " removed");
    }
    /*
    public void setAddressOfUser(String username, Address address) {
        User user = getUser(username);
        user.setAddress(address);
        userDao.saveUser(user);
    }

    public Address getAddressOfUser(String username) {
        User user = getUser(username);
        return user.getAddress();
    } */

    // --- blockMethoden

    public void blockUser(String username) {
        User user = getUser(username);
        user.setBlocked(true);
        userDao.saveUser(user);
        logger.info("User " + user.getUsername() + " blocked");
    }

    public void unblockUser(String username) {
        User user = getUser(username);
        user.setBlocked(false);
        userDao.saveUser(user);
        logger.info("User " + user.getUsername() + " unblocked");
    }
    /*
  public void setPasswordOfUser(String username, String plainPassword) {
      User user = getUser(username);
      Security security = Security.getInstance();
      user.setPassword(security.encrypt(plainPassword));
      userDao.saveUser(user);
  }  */

    // --- userRoleMethoden

    public boolean isUserInRole(User user, Role role) {
        return user.getRole().equals(role);
    }

    public void addUserToRole(User user, Role role) {
        user.setRole(role);
        userDao.saveUser(user);
        logger.info("User " + user.getUsername() + " removed");
    }

    // --- Andere methoden
    /*
  public int getNumberOfUsers() {
      return users.size();
  }  */

    // ----------- Role methdoen

    // --- Nodig voor beans

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
        for (Object o : roleDao.getRoles()) {
            Role role = (Role) o;
            roles.put(role.getName(), role);
        }
        createRole("Administrator");
        createRole("Player");
    }

    // --- getMethoden
    public Role getRole(String rolename) {
        return roles.get(rolename);
    }

    // --- createMethoden

    public Role createRole(String name) {
        Role role = new Role(name);
        if (!roles.containsValue(role)) {
            roleDao.saveRole(role);
            roles.put(role.getName(), role);
        }
        logger.info("Role " + role.getName() + " created");
        return role;
    }

    public Map<String, Role> getRoles() {
        return roles;
    }

    /*  Wordt niet gebruikt denk ik
   public void removeRole(String name) {
       Role role = roles.get(name);
       roleDao.deleteRole(role);
   } */

    public boolean isLastAdministrator() {
        int adminCount = 0;

        for (User user : users) {
            if (user.getRole().getName().equals("Administrator")) {
                adminCount++;
            }
        }

        return adminCount < 2;
    }
}

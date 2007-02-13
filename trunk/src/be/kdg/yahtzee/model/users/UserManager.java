package be.kdg.yahtzee.model.users;

import be.kdg.util.Security;
import be.kdg.yahtzee.dao.RoleDao;
import be.kdg.yahtzee.dao.UserDao;

import java.util.*;


public class UserManager {
    private UserDao userDao;
    private RoleDao roleDao;
    private Set<User> users = new HashSet<User>();
    private Map<String, Role> roles = new HashMap<String, Role>();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        for (Object o : userDao.getUsers()) {
            User user = (User) o;
            users.add(user);
        }
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
        for (Object o : roleDao.getRoles()) {
            Role r = (Role) o;
            roles.put(r.getName(), r);
        }
        createRole("Administrator");
        createRole("Player");
    }

    public Role createRole(String name) {
        Role role = new Role(name);
        if (!roles.containsValue(role)) {
            roleDao.saveRole(role);
            roles.put(role.getName(), role);
        }
        return role;
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

    public void removeRole(String name) {
        Role role = roles.get(name);
        roleDao.deleteRole(role);
    }

    public Role getRole(String rolename) {
        return roles.get(rolename);
    }

    private User createUser(String username, String plainPassword, String surname, String firstName, String email, String telephone, Role role, Address address) {
        Security security = Security.getInstance();
        User user = new User(username, security.encrypt(plainPassword), surname, firstName, email, telephone, role, address);
        if (!users.contains(user)) {
            userDao.saveUser(user);
            users.add(user);
        }
        return user;
    }

    private User changeUser(User user, String username, String surname, String firstName, String email, String telephone, Role role, Address address) {
        user.setAddress(address);
        user.setFirstname(firstName);
        user.setSurname(surname);
        user.setTelephone(telephone);
        user.getPerson().setEmail(email);
        userDao.saveUser(user);
        return user;
    }

    private void changeUserPassword(User user, String orgPass, String password, String password2) {
        Security security = Security.getInstance();
        if (user.getPassword().equals(security.encrypt(orgPass))) {
            if (password.equals(password2)) {
                user.setPassword(security.encrypt(password));
                userDao.saveUser(user);
            }
        }
    }


    public User createAdministrator(String username, String plainPassword, String surname, String firstName, String email, String telephone, Address address) {
        Role role = roles.get("Administrator");
        return createUser(username, plainPassword, surname, firstName, email, telephone, role, address);
    }

    public User createPlayer(String username, String plainPassword, String surname, String firstName, String email, String telephone, Address address) {
        Role role = roles.get("Player");
        return createUser(username, plainPassword, surname, firstName, email, telephone, role, address);
    }

    public User changePlayer(User user, String username, String surname, String firstName, String email, String telephone, Address address) {
        Role role = roles.get("Player");
        return changeUser(user, username, surname, firstName, email, telephone, role, address);
    }

    public void changePassword(User user, String orgPass, String password, String password2) {
        changeUserPassword(user, orgPass, password, password2);
    }

    public void removeUser(String username) {
        User user = getUser(username);
        userDao.deleteUser(user);
    }

    public void setAddressOfUser(String username, Address address) {
        User user = getUser(username);
        user.setAddress(address);
        userDao.saveUser(user);
    }

    public Address getAddressOfUser(String username) {
        User user = getUser(username);
        return user.getAddress();
    }

    public void setPasswordOfUser(String username, String plainPassword) {
        User user = getUser(username);
        Security security = Security.getInstance();
        user.setPassword(security.encrypt(plainPassword));
        userDao.saveUser(user);
    }

    public void addUserToRole(User user, Role role) {
        user.setRole(role);
        userDao.saveUser(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(userDao.getUsers());
    }

    public boolean isUserInRole(User user, Role role) {
        return user.getRole().equals(role);
    }

    public int getNumberOfUsers() {
        return users.size();
    }
}

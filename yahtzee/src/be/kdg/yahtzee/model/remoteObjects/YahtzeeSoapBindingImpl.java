/**
 * YahtzeeSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.model.remoteObjects;


import be.kdg.yahtzee.model.chat.ChatMessage;
import be.kdg.yahtzee.model.game.*;
import be.kdg.yahtzee.model.users.User;

import java.rmi.RemoteException;
import java.util.*;

public class YahtzeeSoapBindingImpl implements be.kdg.yahtzee.model.remoteObjects.YahtzeeController {
    private UserManager userManager;
    private GameManager gameManager;

    public YahtzeeSoapBindingImpl() throws RemoteException {
        userManager = UserManager.getInstance();
        gameManager = GameManager.getInstance();
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Highscore getHighscore() throws java.rmi.RemoteException {
        return null;
    }

    public be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect getScoreAspect() throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.Object[] getRolesList() throws java.rmi.RemoteException {
        return null;
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Score getScore(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        return convertScoreObject(gameManager.getScore(in0, in1));
    }

    public void addMessage(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        gameManager.addMessage(in0, in1);
    }

    public void createPlayer(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException {
        userManager.createPlayer(in0, in1, in2, in3, in4, in5, convertAddressRemObject(in6));
    }

    public void createAdministrator(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException {
        userManager.createAdministrator(in0, in1, in2, in3, in4, in5, convertAddressRemObject(in6));
    }

    public be.kdg.yahtzee.model.remoteObjects.users.User changeUser(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, be.kdg.yahtzee.model.remoteObjects.users.Address in5, be.kdg.yahtzee.model.remoteObjects.users.Role in6) throws java.rmi.RemoteException {
        return convertUserObject(userManager.changeUser(convertUserRemObject(in0), in1, in2, in3, in4, convertAddressRemObject(in5), convertRoleRemObject(in6)));
    }

    public boolean changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException {
        return userManager.changePassword(convertUserRemObject(in0), in1, in2, in3);
    }

    public void changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException {

    }

    public void setOnline(be.kdg.yahtzee.model.remoteObjects.users.User in0, boolean in1) throws java.rmi.RemoteException {
    }

    public void removeUser(java.lang.String in0) throws java.rmi.RemoteException {
        userManager.removeUser(in0);
    }

    public be.kdg.yahtzee.model.remoteObjects.users.User findUser(java.lang.String in0) throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.users.User userOrg = userManager.getUser(in0);
        return convertUserObject(userOrg);
    }

    public java.lang.Object[] getUsers() throws java.rmi.RemoteException {
        System.out.println(userManager.getUsers().size());
        List<User> userlist = userManager.getUsers();
        return convertListUsers(userlist);
    }

    public java.lang.Object[] findUsersByKeyword(java.lang.String in0) throws java.rmi.RemoteException {
        return convertListUsers(userManager.getUsersByKeyword(in0));
    }

    public java.lang.Object[] getOnlineUsers() throws java.rmi.RemoteException {
        return convertListUsers(userManager.getOnlineUsers());
    }

    public boolean isPlayer(java.lang.String in0) throws java.rmi.RemoteException {
        return userManager.isUserInRole(in0, "player");
    }

    public boolean isAdministrator(java.lang.String in0) throws java.rmi.RemoteException {
        return userManager.isUserInRole(in0, "admin");
    }

    public boolean isLastAdministrator() throws java.rmi.RemoteException {
        return userManager.isLastAdministrator();
    }

    public void blockUser(java.lang.String in0) throws java.rmi.RemoteException {
        userManager.blockUser(in0);
    }

    public void unblockUser(java.lang.String in0) throws java.rmi.RemoteException {
        userManager.unblockUser(in0);
    }

    public java.util.HashMap getRoles() throws java.rmi.RemoteException {
        return null;
    }

    public boolean createGame(java.lang.String in0, int in1, be.kdg.yahtzee.model.remoteObjects.users.User in2) throws java.rmi.RemoteException {
        return gameManager.createGame(in0, in1, convertUserRemObject(in2));
    }

    public void removeGame(java.lang.String in0) throws java.rmi.RemoteException {
        gameManager.removeGame(in0);
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Game getGame(java.lang.String in0) throws java.rmi.RemoteException {
        return convertGameObject(gameManager.getGame(in0));
    }

    public java.lang.String getCreator(java.lang.String in0) throws java.rmi.RemoteException {
        return gameManager.getCreator(in0);
    }

    public java.lang.Object[] getGames() throws java.rmi.RemoteException {
        return convertSetGames(gameManager.getGames());
    }

    public java.lang.Object[] getUsersOfGame(java.lang.String in0) throws java.rmi.RemoteException {
        return convertSetUsers(gameManager.getUsersOfGame(in0));
    }

    public java.lang.String startGame(java.lang.String in0) throws java.rmi.RemoteException {
        return gameManager.startGame(in0);
    }

    public boolean joinGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException {
        return gameManager.joinGame(in0, convertUserRemObject(in1));
    }

    public void leaveGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException {
        gameManager.leaveGame(in0, convertUserRemObject(in1));
    }

    public java.lang.Object[] playGameRound(java.lang.String in0) throws java.rmi.RemoteException {
        return convertListDies(gameManager.playRound(in0));
    }

    public java.lang.Object[] getDiceList(java.lang.String in0) throws java.rmi.RemoteException {
        return convertListDies(gameManager.getDiceList(in0));
    }

    public boolean fixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException {
        return gameManager.fixDie(in0, in1);
    }

    public boolean unfixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException {
        return gameManager.unfixDie(in0, in1);
    }

    public java.lang.String getActivePlayer(java.lang.String in0) throws java.rmi.RemoteException {
        return gameManager.getActivePlayer(in0);
    }

    public java.lang.String getGameState(java.lang.String in0) throws java.rmi.RemoteException {
        return gameManager.getGameState(in0);
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Score selectScore(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        //return gameManager.selectScore(in0, in1);
        return convertScoreObject(gameManager.selectScore(in0, in1));
    }

    public java.util.HashMap getScores(java.lang.String in0) throws java.rmi.RemoteException {
        return null;
    }

    public int getPlayerScore(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1) throws java.rmi.RemoteException {
        return gameManager.getPlayerScore(convertUserRemObject(in0), in1);
    }

    public java.lang.Object[] getScorePossibilities(java.lang.String in0) throws java.rmi.RemoteException {
        return convertListScorePosibilities(gameManager.getScorePossibilities(in0));
    }

    public java.lang.Object[] getHighscores() throws java.rmi.RemoteException {
        return convertListHighscores(gameManager.getHighscores());
    }

    public java.lang.Object[] getTop10Highscores() throws java.rmi.RemoteException {
        return convertListHighscores(gameManager.getTop10Highscores());
    }

    public void saveHighscore(be.kdg.yahtzee.model.remoteObjects.users.User in0, int in1, java.util.Calendar in2) throws java.rmi.RemoteException {
        gameManager.saveHighscore(convertUserRemObject(in0), in1, null);
    }

    public int getHighestScore(be.kdg.yahtzee.model.remoteObjects.users.User in0) throws java.rmi.RemoteException {
        return gameManager.getHighestScore(convertUserRemObject(in0));
    }

    public java.lang.Object[] getMessages(java.lang.String in0) throws java.rmi.RemoteException {
        return convertListChatMessages(gameManager.getMessages(in0));
    }

    public void addGlobalMessage(java.lang.String in0) throws java.rmi.RemoteException {
        gameManager.addGlobalMessage(in0);
    }

    public java.lang.Object[] getGlobalMessages() throws java.rmi.RemoteException {
        return (convertListChatMessages(gameManager.getGlobalMessages()));
    }

    // Converters

    //--- listen

    private java.util.HashMap convertMap(Map<String, Score> scoreMap) {
        Map returnMap = new HashMap<String, Score>();
        for (Iterator it = scoreMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Score value = (Score) entry.getValue();
            returnMap.put(key, value);
        }
        return new HashMap(returnMap);
        //return new HashMap(scoreMap);
    }

    private java.lang.Object[] convertListChatMessages(List<ChatMessage> chatList) {
        List returnlist = new ArrayList();
        for (ChatMessage chatMessage : chatList) {
            String message = chatMessage.getText();
            returnlist.add(message);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertListUsers(List<User> userlist) {
        List returnlist = new ArrayList();
        for (User user : userlist) {
            be.kdg.yahtzee.model.remoteObjects.users.User userRem = convertUserObject(user);
            returnlist.add(userRem);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertListScorePosibilities(List<ScoreAspect> scoreposlist) {
        List returnlist = new ArrayList();
        for (ScoreAspect scoreAspect : scoreposlist) {
            be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect scoreaspectRem = convertScoreAspectObject(scoreAspect);
            returnlist.add(scoreaspectRem);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertListDies(List<Die> dielist) {
        List returnlist = new ArrayList();
        for (Die die : dielist) {
            be.kdg.yahtzee.model.remoteObjects.game.Die dieRem = convertDieObject(die);
            returnlist.add(dieRem);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertListHighscores(List<Highscore> highscorelist) {
        List returnlist = new ArrayList();
        for (Highscore highscore : highscorelist) {
            returnlist.add(highscore);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertSetUsers(Set<User> userset) {
        List returnlist = new ArrayList();
        for (User user : userset) {
            be.kdg.yahtzee.model.remoteObjects.users.User userRem = convertUserObject(user);
            returnlist.add(userRem);
        }
        return returnlist.toArray();
    }

    private java.lang.Object[] convertSetGames(Set<Game> gameSet) {
        List returnlist = new ArrayList();
        for (Game game : gameSet) {
            be.kdg.yahtzee.model.remoteObjects.game.Game gameRem = convertGameObject(game);
            returnlist.add(gameRem);
        }
        return returnlist.toArray();
    }

    private be.kdg.yahtzee.model.remoteObjects.game.Die[] convertListDie(List<Die> dielist) {
        be.kdg.yahtzee.model.remoteObjects.game.Die[] returnlist = new be.kdg.yahtzee.model.remoteObjects.game.Die[0];
        int i = 0;
        for (Die die : dielist) {
            be.kdg.yahtzee.model.remoteObjects.game.Die dieRem = convertDieObject(die);
            returnlist[i] = dieRem;
            i++;
        }
        System.out.println("komt hier");
        //be.kdg.yahtzee.model.remoteObjects.game.Die[] dieqsdf = (be.kdg.yahtzee.model.remoteObjects.game.Die[]) returnlist.toArray();
        System.out.println("komt niet");

        return returnlist;
    }
    /*
       private java.lang.Object[] convertListScoreAspect(List<ScoreAspect> scorelist){
       List returnlist = new ArrayList();
       for(ScoreAspect scoreAspect: scorelist){
           be.kdg.yahtzee.model.remoteObjects.game dieRem = convertDieObject(die) ;
           returnlist.add(dieRem);
       }
       return returnlist.toArray();
   } */

    //--- gewone objecten

    // ------user objecten

    private be.kdg.yahtzee.model.users.Address convertAddressRemObject(be.kdg.yahtzee.model.remoteObjects.users.Address remAddress) {
        return new be.kdg.yahtzee.model.users.Address(remAddress.getCity(), remAddress.getCountry(), remAddress.getNumber(), remAddress.getStreet(), remAddress.getZip());
    }

    private be.kdg.yahtzee.model.users.Person convertPersonRemObject(be.kdg.yahtzee.model.remoteObjects.users.Person remPerson) {
        return new be.kdg.yahtzee.model.users.Person(remPerson.getSurname(), remPerson.getFirstName(), remPerson.getEmail(), convertAddressRemObject(remPerson.getAddress()), remPerson.getTelephone());
    }

    private be.kdg.yahtzee.model.users.Role convertRoleRemObject(be.kdg.yahtzee.model.remoteObjects.users.Role remRole) {
        return userManager.getRole(remRole.getName());
        //return new be.kdg.yahtzee.model.users.Role(remRole.getName());
    }

    private be.kdg.yahtzee.model.users.User convertUserRemObject(be.kdg.yahtzee.model.remoteObjects.users.User remUser) {
        return userManager.getUser(remUser.getUsername());
        //return new be.kdg.yahtzee.model.users.User(remUser.getUsername(), remUser.getPassword(), remUser.getSurname(), remUser.getFirstname(), convertPersonRemObject(remUser.getPerson()).getEmail(), remUser.getTelephone(), convertRoleRemObject(remUser.getRole()), convertAddressRemObject(remUser.getAddress()));
    }

    // ------game objecten

    private be.kdg.yahtzee.model.game.Game convertGameRemObject(be.kdg.yahtzee.model.remoteObjects.game.Game remGame) {
        return gameManager.getGame(remGame.getGameName());
        //return new be.kdg.yahtzee.model.game.Game(remGame.getGameName(), remGame.getMaxPlayer(), convertUserRemObject(remGame.getCreator()));
    }

    private be.kdg.yahtzee.model.game.Die convertDieRemObject(be.kdg.yahtzee.model.remoteObjects.game.Die remDie) {
        return new be.kdg.yahtzee.model.game.Die(remDie.getDieId());
    }

    private be.kdg.yahtzee.model.game.Score convertScoreRemObject(be.kdg.yahtzee.model.remoteObjects.game.Score remScore) {
        return new be.kdg.yahtzee.model.game.Score();
    }

    // ------chat objecten

    private be.kdg.yahtzee.model.chat.Chat convertChatRemObject(be.kdg.yahtzee.model.remoteObjects.chat.Chat remChat) {
        return new be.kdg.yahtzee.model.chat.Chat();
    }

    //--- remote objecten

    // ------ user objecten

    private be.kdg.yahtzee.model.remoteObjects.users.Address convertAddressObject(be.kdg.yahtzee.model.users.Address address) {
        return new be.kdg.yahtzee.model.remoteObjects.users.Address(address.getCity(), address.getCountry(), address.getNumber(), address.getStreet(), address.getZip());
    }

    private be.kdg.yahtzee.model.remoteObjects.users.Person convertPersonObject(be.kdg.yahtzee.model.users.Person person) {
        return new be.kdg.yahtzee.model.remoteObjects.users.Person(convertAddressObject(person.getAddress()), person.getEmail(), person.getFirstName(), person.getSurname(), person.getTelephone());
    }

    private be.kdg.yahtzee.model.remoteObjects.users.Role convertRoleObject(be.kdg.yahtzee.model.users.Role role) {
        return new be.kdg.yahtzee.model.remoteObjects.users.Role(role.getName(), role.getRoleId());
    }

    private be.kdg.yahtzee.model.remoteObjects.users.User convertUserObject(be.kdg.yahtzee.model.users.User user) {
        return new be.kdg.yahtzee.model.remoteObjects.users.User(convertAddressObject(user.getAddress()), user.isBlocked(), user.getFirstname(), user.isOnline(), user.getPassword(), convertPersonObject(user.getPerson()), convertRoleObject(user.getRole()), user.getSurname(), user.getTelephone(), user.getUserId(), user.getUsername());
    }

    // ---- game objecten

    private be.kdg.yahtzee.model.remoteObjects.game.Game convertGameObject(be.kdg.yahtzee.model.game.Game game) {
        /*System.out.println(convertUserObject(game.getActivePlayer()).getUsername());
        System.out.println(convertChatObject(game.getChat()).getMessages());
        System.out.println(convertUserObject(game.getCreator()).getUsername());
        System.out.println(convertListDie(game.getDiceList()));
        System.out.println(game.getGameName());
        System.out.println(game.getMaxPlayer());
        System.out.println(game.getNumberOfPlayers());
        System.out.println(game.getMaxPlayer());
        System.out.println(convertScoreObject(game.getScore("username")));
        System.out.println(convertListScorePosibilities(game.getScorePossibilities()));
        System.out.println(convertMap(game.getScores()));
        System.out.println(game.getState());
        System.out.println(convertSetUsers(game.getUsers())); */

        return new be.kdg.yahtzee.model.remoteObjects.game.Game(
                //convertUserObject(game.getActivePlayer()),
                //convertChatObject(game.getChat()),
                //convertUserObject(game.getCreator()),
                //convertListDie(game.getDiceList()),
                game.getGameName(), game.getMaxPlayer(),
                game.getNumberOfPlayers(),
                //convertScoreObject(game.getScore("username")),
                //convertListScorePosibilities(game.getScorePossibilities()),
                game.getState(),
                convertSetUsers(game.getUsers())
        );
    }

    private be.kdg.yahtzee.model.remoteObjects.game.Die convertDieObject(be.kdg.yahtzee.model.game.Die die) {
        return new be.kdg.yahtzee.model.remoteObjects.game.Die(die.isDieFixed(), die.isDieFixed(), die.getDieId(), die.getValue());
    }

    private be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect convertScoreAspectObject(ScoreAspect scoreAspect) {
        return new be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect(scoreAspect.getDescription(), scoreAspect.isFixed(), scoreAspect.getPoints());
    }

    private be.kdg.yahtzee.model.remoteObjects.game.Score convertScoreObject(be.kdg.yahtzee.model.game.Score score) {
        return new be.kdg.yahtzee.model.remoteObjects.game.Score(
                score.getCarre(), score.isCarreFixed(),
                score.getChance(), score.isChanceFixed(),
                score.getFives(), score.isFivesFixed(),
                score.getFours(), score.isFoursFixed(),
                score.getFullHouse(), score.isFullHouseFixed(),
                score.getLargeStreet(), score.isLargeStreetFixed(),
                score.getOnes(), score.isOnesFixed(),
                score.getSixes(), score.isSixesFixed(),
                score.getSmallStreet(), score.isSmallStreetFixed(),
                score.getThreeOfAKind(), score.isThreeOfAKindFixed(),
                score.getThrees(), score.isThreesFixed(),
                score.getTotalLowerHalf(),
                score.getTotalScore(),
                score.getTotalUpperHalf(),
                score.getTwos(), score.isTwosFixed(),
                score.getUpperHalfBonus(),
                score.getUpperHalfWithoutBonus(),
                score.getYahtzee(),
                score.getYahtzeeBonus(),
                score.isYahtzeeFixed()
        );
    }

    // ------chat objecten

    private be.kdg.yahtzee.model.remoteObjects.chat.Chat convertChatObject(be.kdg.yahtzee.model.chat.Chat chat) {
        return new be.kdg.yahtzee.model.remoteObjects.chat.Chat();
    }

}

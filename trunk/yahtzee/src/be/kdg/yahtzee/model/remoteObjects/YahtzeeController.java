/**
 * YahtzeeController.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.model.remoteObjects;

public interface YahtzeeController extends java.rmi.Remote {
    public void addMessage(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.game.Highscore getHighscore() throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect getScoreAspect() throws java.rmi.RemoteException;

    public java.lang.Object[] getRolesList() throws java.rmi.RemoteException;

    public void createPlayer(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException;

    public void createAdministrator(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.users.User changeUser(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, be.kdg.yahtzee.model.remoteObjects.users.Address in5, be.kdg.yahtzee.model.remoteObjects.users.Role in6) throws java.rmi.RemoteException;

    public boolean changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;

    public void changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;

    public void setOnline(be.kdg.yahtzee.model.remoteObjects.users.User in0, boolean in1) throws java.rmi.RemoteException;

    public void removeUser(java.lang.String in0) throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.users.User findUser(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getUsers() throws java.rmi.RemoteException;

    public java.lang.Object[] findUsersByKeyword(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getOnlineUsers() throws java.rmi.RemoteException;

    public boolean isPlayer(java.lang.String in0) throws java.rmi.RemoteException;

    public boolean isAdministrator(java.lang.String in0) throws java.rmi.RemoteException;

    public boolean isLastAdministrator() throws java.rmi.RemoteException;

    public void blockUser(java.lang.String in0) throws java.rmi.RemoteException;

    public void unblockUser(java.lang.String in0) throws java.rmi.RemoteException;

    public java.util.HashMap getRoles() throws java.rmi.RemoteException;

    public boolean createGame(java.lang.String in0, int in1, be.kdg.yahtzee.model.remoteObjects.users.User in2) throws java.rmi.RemoteException;

    public void removeGame(java.lang.String in0) throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.game.Game getGame(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.String getCreator(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getGames() throws java.rmi.RemoteException;

    public java.lang.Object[] getUsersOfGame(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.String startGame(java.lang.String in0) throws java.rmi.RemoteException;

    public boolean joinGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException;

    public void leaveGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException;

    public java.lang.Object[] playGameRound(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getDiceList(java.lang.String in0) throws java.rmi.RemoteException;

    public boolean fixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException;

    public boolean unfixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException;

    public java.lang.String getActivePlayer(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.String getGameState(java.lang.String in0) throws java.rmi.RemoteException;

    public be.kdg.yahtzee.model.remoteObjects.game.Score selectScore(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;

    public java.util.HashMap getScores(java.lang.String in0) throws java.rmi.RemoteException;

    public int getPlayerScore(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1) throws java.rmi.RemoteException;

    public java.lang.Object[] getScorePossibilities(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getHighscores() throws java.rmi.RemoteException;

    public java.lang.Object[] getTop10Highscores() throws java.rmi.RemoteException;

    public void saveHighscore(be.kdg.yahtzee.model.remoteObjects.users.User in0, int in1, java.util.Calendar in2) throws java.rmi.RemoteException;

    public int getHighestScore(be.kdg.yahtzee.model.remoteObjects.users.User in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getMessages(java.lang.String in0) throws java.rmi.RemoteException;

    public void addGlobalMessage(java.lang.String in0) throws java.rmi.RemoteException;

    public java.lang.Object[] getGlobalMessages() throws java.rmi.RemoteException;
}

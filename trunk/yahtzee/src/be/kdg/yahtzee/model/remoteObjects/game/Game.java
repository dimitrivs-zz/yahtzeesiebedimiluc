/**
 * Game.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.model.remoteObjects.game;

public class Game implements java.io.Serializable {
    private be.kdg.yahtzee.model.remoteObjects.users.User activePlayer;

    private be.kdg.yahtzee.model.remoteObjects.chat.Chat chat;

    private be.kdg.yahtzee.model.remoteObjects.users.User creator;

    private java.lang.Object[] diceList;

    private be.kdg.yahtzee.model.remoteObjects.game.Die[] die;

    private java.lang.String gameName;

    private int maxPlayer;

    private int numberOfPlayers;

    private be.kdg.yahtzee.model.remoteObjects.game.Score score;

    private java.lang.Object[] scorePossibilities;

    private java.util.HashMap scores;

    private java.lang.String state;

    private java.lang.Object[] users;

    public Game() {
    }

    public Game(
            be.kdg.yahtzee.model.remoteObjects.users.User activePlayer,
            be.kdg.yahtzee.model.remoteObjects.chat.Chat chat,
            be.kdg.yahtzee.model.remoteObjects.users.User creator,
            java.lang.Object[] diceList,
            be.kdg.yahtzee.model.remoteObjects.game.Die[] die,
            java.lang.String gameName,
            int maxPlayer,
            int numberOfPlayers,
            be.kdg.yahtzee.model.remoteObjects.game.Score score,
            java.lang.Object[] scorePossibilities,
            java.util.HashMap scores,
            java.lang.String state,
            java.lang.Object[] users) {
        this.activePlayer = activePlayer;
        this.chat = chat;
        this.creator = creator;
        this.diceList = diceList;
        this.die = die;
        this.gameName = gameName;
        this.maxPlayer = maxPlayer;
        this.numberOfPlayers = numberOfPlayers;
        this.score = score;
        this.scorePossibilities = scorePossibilities;
        this.scores = scores;
        this.state = state;
        this.users = users;
    }


    /**
     * Gets the activePlayer value for this Game.
     *
     * @return activePlayer
     */
    public be.kdg.yahtzee.model.remoteObjects.users.User getActivePlayer() {
        return activePlayer;
    }


    /**
     * Sets the activePlayer value for this Game.
     *
     * @param activePlayer
     */
    public void setActivePlayer(be.kdg.yahtzee.model.remoteObjects.users.User activePlayer) {
        this.activePlayer = activePlayer;
    }


    /**
     * Gets the chat value for this Game.
     *
     * @return chat
     */
    public be.kdg.yahtzee.model.remoteObjects.chat.Chat getChat() {
        return chat;
    }


    /**
     * Sets the chat value for this Game.
     *
     * @param chat
     */
    public void setChat(be.kdg.yahtzee.model.remoteObjects.chat.Chat chat) {
        this.chat = chat;
    }


    /**
     * Gets the creator value for this Game.
     *
     * @return creator
     */
    public be.kdg.yahtzee.model.remoteObjects.users.User getCreator() {
        return creator;
    }


    /**
     * Sets the creator value for this Game.
     *
     * @param creator
     */
    public void setCreator(be.kdg.yahtzee.model.remoteObjects.users.User creator) {
        this.creator = creator;
    }


    /**
     * Gets the diceList value for this Game.
     *
     * @return diceList
     */
    public java.lang.Object[] getDiceList() {
        return diceList;
    }


    /**
     * Sets the diceList value for this Game.
     *
     * @param diceList
     */
    public void setDiceList(java.lang.Object[] diceList) {
        this.diceList = diceList;
    }


    /**
     * Gets the die value for this Game.
     *
     * @return die
     */
    public be.kdg.yahtzee.model.remoteObjects.game.Die[] getDie() {
        return die;
    }


    /**
     * Sets the die value for this Game.
     *
     * @param die
     */
    public void setDie(be.kdg.yahtzee.model.remoteObjects.game.Die[] die) {
        this.die = die;
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Die getDie(int i) {
        return this.die[i];
    }

    public void setDie(int i, be.kdg.yahtzee.model.remoteObjects.game.Die _value) {
        this.die[i] = _value;
    }


    /**
     * Gets the gameName value for this Game.
     *
     * @return gameName
     */
    public java.lang.String getGameName() {
        return gameName;
    }


    /**
     * Sets the gameName value for this Game.
     *
     * @param gameName
     */
    public void setGameName(java.lang.String gameName) {
        this.gameName = gameName;
    }


    /**
     * Gets the maxPlayer value for this Game.
     *
     * @return maxPlayer
     */
    public int getMaxPlayer() {
        return maxPlayer;
    }


    /**
     * Sets the maxPlayer value for this Game.
     *
     * @param maxPlayer
     */
    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }


    /**
     * Gets the numberOfPlayers value for this Game.
     *
     * @return numberOfPlayers
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


    /**
     * Sets the numberOfPlayers value for this Game.
     *
     * @param numberOfPlayers
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


    /**
     * Gets the score value for this Game.
     *
     * @return score
     */
    public be.kdg.yahtzee.model.remoteObjects.game.Score getScore() {
        return score;
    }


    /**
     * Sets the score value for this Game.
     *
     * @param score
     */
    public void setScore(be.kdg.yahtzee.model.remoteObjects.game.Score score) {
        this.score = score;
    }


    /**
     * Gets the scorePossibilities value for this Game.
     *
     * @return scorePossibilities
     */
    public java.lang.Object[] getScorePossibilities() {
        return scorePossibilities;
    }


    /**
     * Sets the scorePossibilities value for this Game.
     *
     * @param scorePossibilities
     */
    public void setScorePossibilities(java.lang.Object[] scorePossibilities) {
        this.scorePossibilities = scorePossibilities;
    }


    /**
     * Gets the scores value for this Game.
     *
     * @return scores
     */
    public java.util.HashMap getScores() {
        return scores;
    }


    /**
     * Sets the scores value for this Game.
     *
     * @param scores
     */
    public void setScores(java.util.HashMap scores) {
        this.scores = scores;
    }


    /**
     * Gets the state value for this Game.
     *
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Game.
     *
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the users value for this Game.
     *
     * @return users
     */
    public java.lang.Object[] getUsers() {
        return users;
    }


    /**
     * Sets the users value for this Game.
     *
     * @param users
     */
    public void setUsers(java.lang.Object[] users) {
        this.users = users;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.activePlayer == null && other.getActivePlayer() == null) ||
                        (this.activePlayer != null &&
                                this.activePlayer.equals(other.getActivePlayer()))) &&
                ((this.chat == null && other.getChat() == null) ||
                        (this.chat != null &&
                                this.chat.equals(other.getChat()))) &&
                ((this.creator == null && other.getCreator() == null) ||
                        (this.creator != null &&
                                this.creator.equals(other.getCreator()))) &&
                ((this.diceList == null && other.getDiceList() == null) ||
                        (this.diceList != null &&
                                java.util.Arrays.equals(this.diceList, other.getDiceList()))) &&
                ((this.die == null && other.getDie() == null) ||
                        (this.die != null &&
                                java.util.Arrays.equals(this.die, other.getDie()))) &&
                ((this.gameName == null && other.getGameName() == null) ||
                        (this.gameName != null &&
                                this.gameName.equals(other.getGameName()))) &&
                this.maxPlayer == other.getMaxPlayer() &&
                this.numberOfPlayers == other.getNumberOfPlayers() &&
                ((this.score == null && other.getScore() == null) ||
                        (this.score != null &&
                                this.score.equals(other.getScore()))) &&
                ((this.scorePossibilities == null && other.getScorePossibilities() == null) ||
                        (this.scorePossibilities != null &&
                                java.util.Arrays.equals(this.scorePossibilities, other.getScorePossibilities()))) &&
                ((this.scores == null && other.getScores() == null) ||
                        (this.scores != null &&
                                this.scores.equals(other.getScores()))) &&
                ((this.state == null && other.getState() == null) ||
                        (this.state != null &&
                                this.state.equals(other.getState()))) &&
                ((this.users == null && other.getUsers() == null) ||
                        (this.users != null &&
                                java.util.Arrays.equals(this.users, other.getUsers())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getActivePlayer() != null) {
            _hashCode += getActivePlayer().hashCode();
        }
        if (getChat() != null) {
            _hashCode += getChat().hashCode();
        }
        if (getCreator() != null) {
            _hashCode += getCreator().hashCode();
        }
        if (getDiceList() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getDiceList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiceList(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDie() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getDie());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDie(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGameName() != null) {
            _hashCode += getGameName().hashCode();
        }
        _hashCode += getMaxPlayer();
        _hashCode += getNumberOfPlayers();
        if (getScore() != null) {
            _hashCode += getScore().hashCode();
        }
        if (getScorePossibilities() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getScorePossibilities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getScorePossibilities(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getScores() != null) {
            _hashCode += getScores().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getUsers() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getUsers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUsers(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Game.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Game"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activePlayer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activePlayer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://chat.remoteObjects.model.yahtzee.kdg.be", "Chat"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diceList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diceList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("die");
        elemField.setXmlName(new javax.xml.namespace.QName("", "die"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Die"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gameName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gameName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxPlayer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxPlayer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfPlayers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfPlayers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Score"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scorePossibilities");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scorePossibilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("users");
        elemField.setXmlName(new javax.xml.namespace.QName("", "users"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}

/**
 * YahtzeeSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.model.remoteObjects;

public class YahtzeeSoapBindingSkeleton implements be.kdg.yahtzee.model.remoteObjects.YahtzeeController, org.apache.axis.wsdl.Skeleton {
    private be.kdg.yahtzee.model.remoteObjects.YahtzeeController impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
     * Returns List of OperationDesc objects with this name
     */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List) _myOperations.get(methodName);
    }

    /**
     * Returns Collection of OperationDescs
     */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc[] _params;
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("addMessage", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "addMessage"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addMessage") == null) {
            _myOperations.put("addMessage", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("addMessage")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getHighscore", _params, new javax.xml.namespace.QName("", "getHighscoreReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Highscore"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getHighscore"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHighscore") == null) {
            _myOperations.put("getHighscore", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getHighscore")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getScoreAspect", _params, new javax.xml.namespace.QName("", "getScoreAspectReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "ScoreAspect"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getScoreAspect"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getScoreAspect") == null) {
            _myOperations.put("getScoreAspect", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getScoreAspect")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getRolesList", _params, new javax.xml.namespace.QName("", "getRolesListReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getRolesList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRolesList") == null) {
            _myOperations.put("getRolesList", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getRolesList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in4"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in5"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in6"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "Address"), be.kdg.yahtzee.model.remoteObjects.users.Address.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("createPlayer", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "createPlayer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createPlayer") == null) {
            _myOperations.put("createPlayer", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("createPlayer")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in4"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in5"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in6"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "Address"), be.kdg.yahtzee.model.remoteObjects.users.Address.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("createAdministrator", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "createAdministrator"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createAdministrator") == null) {
            _myOperations.put("createAdministrator", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("createAdministrator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in4"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in5"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "Address"), be.kdg.yahtzee.model.remoteObjects.users.Address.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in6"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "Role"), be.kdg.yahtzee.model.remoteObjects.users.Role.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("changeUser", _params, new javax.xml.namespace.QName("", "changeUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "changeUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("changeUser") == null) {
            _myOperations.put("changeUser", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("changeUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("changePassWord", _params, new javax.xml.namespace.QName("", "changePassWordReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "changePassWord"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("changePassWord") == null) {
            _myOperations.put("changePassWord", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("changePassWord")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("changePassWord", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "changePassWord"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("changePassWord") == null) {
            _myOperations.put("changePassWord", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("changePassWord")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("setOnline", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "setOnline"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setOnline") == null) {
            _myOperations.put("setOnline", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("setOnline")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("removeUser", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "removeUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("removeUser") == null) {
            _myOperations.put("removeUser", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("removeUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("findUser", _params, new javax.xml.namespace.QName("", "findUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "findUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findUser") == null) {
            _myOperations.put("findUser", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("findUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getUsers", _params, new javax.xml.namespace.QName("", "getUsersReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getUsers"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUsers") == null) {
            _myOperations.put("getUsers", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getUsers")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("findUsersByKeyword", _params, new javax.xml.namespace.QName("", "findUsersByKeywordReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "findUsersByKeyword"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findUsersByKeyword") == null) {
            _myOperations.put("findUsersByKeyword", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("findUsersByKeyword")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getOnlineUsers", _params, new javax.xml.namespace.QName("", "getOnlineUsersReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getOnlineUsers"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getOnlineUsers") == null) {
            _myOperations.put("getOnlineUsers", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getOnlineUsers")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("isPlayer", _params, new javax.xml.namespace.QName("", "isPlayerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "isPlayer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isPlayer") == null) {
            _myOperations.put("isPlayer", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("isPlayer")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("isAdministrator", _params, new javax.xml.namespace.QName("", "isAdministratorReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "isAdministrator"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isAdministrator") == null) {
            _myOperations.put("isAdministrator", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("isAdministrator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("isLastAdministrator", _params, new javax.xml.namespace.QName("", "isLastAdministratorReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "isLastAdministrator"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isLastAdministrator") == null) {
            _myOperations.put("isLastAdministrator", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("isLastAdministrator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("blockUser", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "blockUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("blockUser") == null) {
            _myOperations.put("blockUser", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("blockUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("unblockUser", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "unblockUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("unblockUser") == null) {
            _myOperations.put("unblockUser", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("unblockUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getRoles", _params, new javax.xml.namespace.QName("", "getRolesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getRoles"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRoles") == null) {
            _myOperations.put("getRoles", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getRoles")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("createGame", _params, new javax.xml.namespace.QName("", "createGameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "createGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createGame") == null) {
            _myOperations.put("createGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("createGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("removeGame", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "removeGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("removeGame") == null) {
            _myOperations.put("removeGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("removeGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getGame", _params, new javax.xml.namespace.QName("", "getGameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Game"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGame") == null) {
            _myOperations.put("getGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getCreator", _params, new javax.xml.namespace.QName("", "getCreatorReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getCreator"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCreator") == null) {
            _myOperations.put("getCreator", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getCreator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getGames", _params, new javax.xml.namespace.QName("", "getGamesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getGames"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGames") == null) {
            _myOperations.put("getGames", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getGames")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getUsersOfGame", _params, new javax.xml.namespace.QName("", "getUsersOfGameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getUsersOfGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUsersOfGame") == null) {
            _myOperations.put("getUsersOfGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getUsersOfGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("startGame", _params, new javax.xml.namespace.QName("", "startGameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "startGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("startGame") == null) {
            _myOperations.put("startGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("startGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("joinGame", _params, new javax.xml.namespace.QName("", "joinGameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "joinGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("joinGame") == null) {
            _myOperations.put("joinGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("joinGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("leaveGame", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "leaveGame"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("leaveGame") == null) {
            _myOperations.put("leaveGame", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("leaveGame")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("playGameRound", _params, new javax.xml.namespace.QName("", "playGameRoundReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "playGameRound"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("playGameRound") == null) {
            _myOperations.put("playGameRound", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("playGameRound")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getDiceList", _params, new javax.xml.namespace.QName("", "getDiceListReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getDiceList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDiceList") == null) {
            _myOperations.put("getDiceList", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getDiceList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("fixDie", _params, new javax.xml.namespace.QName("", "fixDieReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "fixDie"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("fixDie") == null) {
            _myOperations.put("fixDie", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("fixDie")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("unfixDie", _params, new javax.xml.namespace.QName("", "unfixDieReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "unfixDie"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("unfixDie") == null) {
            _myOperations.put("unfixDie", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("unfixDie")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getActivePlayer", _params, new javax.xml.namespace.QName("", "getActivePlayerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getActivePlayer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getActivePlayer") == null) {
            _myOperations.put("getActivePlayer", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getActivePlayer")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getGameState", _params, new javax.xml.namespace.QName("", "getGameStateReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getGameState"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGameState") == null) {
            _myOperations.put("getGameState", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getGameState")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("selectScore", _params, new javax.xml.namespace.QName("", "selectScoreReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://game.remoteObjects.model.yahtzee.kdg.be", "Score"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "selectScore"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("selectScore") == null) {
            _myOperations.put("selectScore", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("selectScore")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getScores", _params, new javax.xml.namespace.QName("", "getScoresReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getScores"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getScores") == null) {
            _myOperations.put("getScores", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getScores")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getPlayerScore", _params, new javax.xml.namespace.QName("", "getPlayerScoreReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getPlayerScore"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getPlayerScore") == null) {
            _myOperations.put("getPlayerScore", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getPlayerScore")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getScorePossibilities", _params, new javax.xml.namespace.QName("", "getScorePossibilitiesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getScorePossibilities"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getScorePossibilities") == null) {
            _myOperations.put("getScorePossibilities", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getScorePossibilities")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getHighscores", _params, new javax.xml.namespace.QName("", "getHighscoresReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getHighscores"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHighscores") == null) {
            _myOperations.put("getHighscores", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getHighscores")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getTop10Highscores", _params, new javax.xml.namespace.QName("", "getTop10HighscoresReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getTop10Highscores"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getTop10Highscores") == null) {
            _myOperations.put("getTop10Highscores", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getTop10Highscores")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false),
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("saveHighscore", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "saveHighscore"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("saveHighscore") == null) {
            _myOperations.put("saveHighscore", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("saveHighscore")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://users.remoteObjects.model.yahtzee.kdg.be", "User"), be.kdg.yahtzee.model.remoteObjects.users.User.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getHighestScore", _params, new javax.xml.namespace.QName("", "getHighestScoreReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getHighestScore"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHighestScore") == null) {
            _myOperations.put("getHighestScore", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getHighestScore")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("getMessages", _params, new javax.xml.namespace.QName("", "getMessagesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getMessages"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getMessages") == null) {
            _myOperations.put("getMessages", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getMessages")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
                new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false),
        };
        _oper = new org.apache.axis.description.OperationDesc("addGlobalMessage", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "addGlobalMessage"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("addGlobalMessage") == null) {
            _myOperations.put("addGlobalMessage", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("addGlobalMessage")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc[]{
        };
        _oper = new org.apache.axis.description.OperationDesc("getGlobalMessages", _params, new javax.xml.namespace.QName("", "getGlobalMessagesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "ArrayOf_xsd_anyType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "getGlobalMessages"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGlobalMessages") == null) {
            _myOperations.put("getGlobalMessages", new java.util.ArrayList());
        }
        ((java.util.List) _myOperations.get("getGlobalMessages")).add(_oper);
    }

    public YahtzeeSoapBindingSkeleton() {
        this.impl = new be.kdg.yahtzee.model.remoteObjects.YahtzeeSoapBindingImpl();
    }

    public YahtzeeSoapBindingSkeleton(be.kdg.yahtzee.model.remoteObjects.YahtzeeController impl) {
        this.impl = impl;
    }

    public void addMessage(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        impl.addMessage(in0, in1);
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Highscore getHighscore() throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.game.Highscore ret = impl.getHighscore();
        return ret;
    }

    public be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect getScoreAspect() throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.game.ScoreAspect ret = impl.getScoreAspect();
        return ret;
    }

    public java.lang.Object[] getRolesList() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getRolesList();
        return ret;
    }

    public void createPlayer(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException {
        impl.createPlayer(in0, in1, in2, in3, in4, in5, in6);
    }

    public void createAdministrator(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, be.kdg.yahtzee.model.remoteObjects.users.Address in6) throws java.rmi.RemoteException {
        impl.createAdministrator(in0, in1, in2, in3, in4, in5, in6);
    }

    public be.kdg.yahtzee.model.remoteObjects.users.User changeUser(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, be.kdg.yahtzee.model.remoteObjects.users.Address in5, be.kdg.yahtzee.model.remoteObjects.users.Role in6) throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.users.User ret = impl.changeUser(in0, in1, in2, in3, in4, in5, in6);
        return ret;
    }

    public boolean changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException {
        boolean ret = impl.changePassWord(in0, in1, in2, in3);
        return ret;
    }

    public void changePassWord(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException {
        impl.changePassWord(in0, in1, in2);
    }

    public void setOnline(be.kdg.yahtzee.model.remoteObjects.users.User in0, boolean in1) throws java.rmi.RemoteException {
        impl.setOnline(in0, in1);
    }

    public void removeUser(java.lang.String in0) throws java.rmi.RemoteException {
        impl.removeUser(in0);
    }

    public be.kdg.yahtzee.model.remoteObjects.users.User findUser(java.lang.String in0) throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.users.User ret = impl.findUser(in0);
        return ret;
    }

    public java.lang.Object[] getUsers() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getUsers();
        return ret;
    }

    public java.lang.Object[] findUsersByKeyword(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.findUsersByKeyword(in0);
        return ret;
    }

    public java.lang.Object[] getOnlineUsers() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getOnlineUsers();
        return ret;
    }

    public boolean isPlayer(java.lang.String in0) throws java.rmi.RemoteException {
        boolean ret = impl.isPlayer(in0);
        return ret;
    }

    public boolean isAdministrator(java.lang.String in0) throws java.rmi.RemoteException {
        boolean ret = impl.isAdministrator(in0);
        return ret;
    }

    public boolean isLastAdministrator() throws java.rmi.RemoteException {
        boolean ret = impl.isLastAdministrator();
        return ret;
    }

    public void blockUser(java.lang.String in0) throws java.rmi.RemoteException {
        impl.blockUser(in0);
    }

    public void unblockUser(java.lang.String in0) throws java.rmi.RemoteException {
        impl.unblockUser(in0);
    }

    public java.util.HashMap getRoles() throws java.rmi.RemoteException {
        java.util.HashMap ret = impl.getRoles();
        return ret;
    }

    public boolean createGame(java.lang.String in0, int in1, be.kdg.yahtzee.model.remoteObjects.users.User in2) throws java.rmi.RemoteException {
        boolean ret = impl.createGame(in0, in1, in2);
        return ret;
    }

    public void removeGame(java.lang.String in0) throws java.rmi.RemoteException {
        impl.removeGame(in0);
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Game getGame(java.lang.String in0) throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.game.Game ret = impl.getGame(in0);
        return ret;
    }

    public java.lang.String getCreator(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.String ret = impl.getCreator(in0);
        return ret;
    }

    public java.lang.Object[] getGames() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getGames();
        return ret;
    }

    public java.lang.Object[] getUsersOfGame(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getUsersOfGame(in0);
        return ret;
    }

    public java.lang.String startGame(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.String ret = impl.startGame(in0);
        return ret;
    }

    public boolean joinGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException {
        boolean ret = impl.joinGame(in0, in1);
        return ret;
    }

    public void leaveGame(java.lang.String in0, be.kdg.yahtzee.model.remoteObjects.users.User in1) throws java.rmi.RemoteException {
        impl.leaveGame(in0, in1);
    }

    public java.lang.Object[] playGameRound(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.playGameRound(in0);
        return ret;
    }

    public java.lang.Object[] getDiceList(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getDiceList(in0);
        return ret;
    }

    public boolean fixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException {
        boolean ret = impl.fixDie(in0, in1);
        return ret;
    }

    public boolean unfixDie(java.lang.String in0, int in1) throws java.rmi.RemoteException {
        boolean ret = impl.unfixDie(in0, in1);
        return ret;
    }

    public java.lang.String getActivePlayer(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.String ret = impl.getActivePlayer(in0);
        return ret;
    }

    public java.lang.String getGameState(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.String ret = impl.getGameState(in0);
        return ret;
    }

    public be.kdg.yahtzee.model.remoteObjects.game.Score selectScore(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        be.kdg.yahtzee.model.remoteObjects.game.Score ret = impl.selectScore(in0, in1);
        return ret;
    }

    public java.util.HashMap getScores(java.lang.String in0) throws java.rmi.RemoteException {
        java.util.HashMap ret = impl.getScores(in0);
        return ret;
    }

    public int getPlayerScore(be.kdg.yahtzee.model.remoteObjects.users.User in0, java.lang.String in1) throws java.rmi.RemoteException {
        int ret = impl.getPlayerScore(in0, in1);
        return ret;
    }

    public java.lang.Object[] getScorePossibilities(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getScorePossibilities(in0);
        return ret;
    }

    public java.lang.Object[] getHighscores() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getHighscores();
        return ret;
    }

    public java.lang.Object[] getTop10Highscores() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getTop10Highscores();
        return ret;
    }

    public void saveHighscore(be.kdg.yahtzee.model.remoteObjects.users.User in0, int in1, java.util.Calendar in2) throws java.rmi.RemoteException {
        impl.saveHighscore(in0, in1, in2);
    }

    public int getHighestScore(be.kdg.yahtzee.model.remoteObjects.users.User in0) throws java.rmi.RemoteException {
        int ret = impl.getHighestScore(in0);
        return ret;
    }

    public java.lang.Object[] getMessages(java.lang.String in0) throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getMessages(in0);
        return ret;
    }

    public void addGlobalMessage(java.lang.String in0) throws java.rmi.RemoteException {
        impl.addGlobalMessage(in0);
    }

    public java.lang.Object[] getGlobalMessages() throws java.rmi.RemoteException {
        java.lang.Object[] ret = impl.getGlobalMessages();
        return ret;
    }

}

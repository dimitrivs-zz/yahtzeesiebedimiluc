/**
 * Score.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects.game;

public class Score implements java.io.Serializable {
    private int carre;

    private boolean carreFixed;

    private int chance;

    private boolean chanceFixed;

    private int fives;

    private boolean fivesFixed;

    private int fours;

    private boolean foursFixed;

    private int fullHouse;

    private boolean fullHouseFixed;

    private int largeStreet;

    private boolean largeStreetFixed;

    private int ones;

    private boolean onesFixed;

    private int sixes;

    private boolean sixesFixed;

    private int smallStreet;

    private boolean smallStreetFixed;

    private int threeOfAKind;

    private boolean threeOfAKindFixed;

    private int threes;

    private boolean threesFixed;

    private int totalLowerHalf;

    private int totalScore;

    private int totalUpperHalf;

    private int twos;

    private boolean twosFixed;

    private int upperHalfBonus;

    private int upperHalfWithoutBonus;

    private int yahtzee;

    private int yahtzeeBonus;

    private boolean yahtzeeFixed;

    public Score() {
    }

    public Score(
            int carre,
            boolean carreFixed,
            int chance,
            boolean chanceFixed,
            int fives,
            boolean fivesFixed,
            int fours,
            boolean foursFixed,
            int fullHouse,
            boolean fullHouseFixed,
            int largeStreet,
            boolean largeStreetFixed,
            int ones,
            boolean onesFixed,
            int sixes,
            boolean sixesFixed,
            int smallStreet,
            boolean smallStreetFixed,
            int threeOfAKind,
            boolean threeOfAKindFixed,
            int threes,
            boolean threesFixed,
            int totalLowerHalf,
            int totalScore,
            int totalUpperHalf,
            int twos,
            boolean twosFixed,
            int upperHalfBonus,
            int upperHalfWithoutBonus,
            int yahtzee,
            int yahtzeeBonus,
            boolean yahtzeeFixed) {
        this.carre = carre;
        this.carreFixed = carreFixed;
        this.chance = chance;
        this.chanceFixed = chanceFixed;
        this.fives = fives;
        this.fivesFixed = fivesFixed;
        this.fours = fours;
        this.foursFixed = foursFixed;
        this.fullHouse = fullHouse;
        this.fullHouseFixed = fullHouseFixed;
        this.largeStreet = largeStreet;
        this.largeStreetFixed = largeStreetFixed;
        this.ones = ones;
        this.onesFixed = onesFixed;
        this.sixes = sixes;
        this.sixesFixed = sixesFixed;
        this.smallStreet = smallStreet;
        this.smallStreetFixed = smallStreetFixed;
        this.threeOfAKind = threeOfAKind;
        this.threeOfAKindFixed = threeOfAKindFixed;
        this.threes = threes;
        this.threesFixed = threesFixed;
        this.totalLowerHalf = totalLowerHalf;
        this.totalScore = totalScore;
        this.totalUpperHalf = totalUpperHalf;
        this.twos = twos;
        this.twosFixed = twosFixed;
        this.upperHalfBonus = upperHalfBonus;
        this.upperHalfWithoutBonus = upperHalfWithoutBonus;
        this.yahtzee = yahtzee;
        this.yahtzeeBonus = yahtzeeBonus;
        this.yahtzeeFixed = yahtzeeFixed;
    }


    /**
     * Gets the carre value for this Score.
     *
     * @return carre
     */
    public int getCarre() {
        return carre;
    }


    /**
     * Sets the carre value for this Score.
     *
     * @param carre
     */
    public void setCarre(int carre) {
        this.carre = carre;
    }


    /**
     * Gets the carreFixed value for this Score.
     *
     * @return carreFixed
     */
    public boolean isCarreFixed() {
        return carreFixed;
    }


    /**
     * Sets the carreFixed value for this Score.
     *
     * @param carreFixed
     */
    public void setCarreFixed(boolean carreFixed) {
        this.carreFixed = carreFixed;
    }


    /**
     * Gets the chance value for this Score.
     *
     * @return chance
     */
    public int getChance() {
        return chance;
    }


    /**
     * Sets the chance value for this Score.
     *
     * @param chance
     */
    public void setChance(int chance) {
        this.chance = chance;
    }


    /**
     * Gets the chanceFixed value for this Score.
     *
     * @return chanceFixed
     */
    public boolean isChanceFixed() {
        return chanceFixed;
    }


    /**
     * Sets the chanceFixed value for this Score.
     *
     * @param chanceFixed
     */
    public void setChanceFixed(boolean chanceFixed) {
        this.chanceFixed = chanceFixed;
    }


    /**
     * Gets the fives value for this Score.
     *
     * @return fives
     */
    public int getFives() {
        return fives;
    }


    /**
     * Sets the fives value for this Score.
     *
     * @param fives
     */
    public void setFives(int fives) {
        this.fives = fives;
    }


    /**
     * Gets the fivesFixed value for this Score.
     *
     * @return fivesFixed
     */
    public boolean isFivesFixed() {
        return fivesFixed;
    }


    /**
     * Sets the fivesFixed value for this Score.
     *
     * @param fivesFixed
     */
    public void setFivesFixed(boolean fivesFixed) {
        this.fivesFixed = fivesFixed;
    }


    /**
     * Gets the fours value for this Score.
     *
     * @return fours
     */
    public int getFours() {
        return fours;
    }


    /**
     * Sets the fours value for this Score.
     *
     * @param fours
     */
    public void setFours(int fours) {
        this.fours = fours;
    }


    /**
     * Gets the foursFixed value for this Score.
     *
     * @return foursFixed
     */
    public boolean isFoursFixed() {
        return foursFixed;
    }


    /**
     * Sets the foursFixed value for this Score.
     *
     * @param foursFixed
     */
    public void setFoursFixed(boolean foursFixed) {
        this.foursFixed = foursFixed;
    }


    /**
     * Gets the fullHouse value for this Score.
     *
     * @return fullHouse
     */
    public int getFullHouse() {
        return fullHouse;
    }


    /**
     * Sets the fullHouse value for this Score.
     *
     * @param fullHouse
     */
    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }


    /**
     * Gets the fullHouseFixed value for this Score.
     *
     * @return fullHouseFixed
     */
    public boolean isFullHouseFixed() {
        return fullHouseFixed;
    }


    /**
     * Sets the fullHouseFixed value for this Score.
     *
     * @param fullHouseFixed
     */
    public void setFullHouseFixed(boolean fullHouseFixed) {
        this.fullHouseFixed = fullHouseFixed;
    }


    /**
     * Gets the largeStreet value for this Score.
     *
     * @return largeStreet
     */
    public int getLargeStreet() {
        return largeStreet;
    }


    /**
     * Sets the largeStreet value for this Score.
     *
     * @param largeStreet
     */
    public void setLargeStreet(int largeStreet) {
        this.largeStreet = largeStreet;
    }


    /**
     * Gets the largeStreetFixed value for this Score.
     *
     * @return largeStreetFixed
     */
    public boolean isLargeStreetFixed() {
        return largeStreetFixed;
    }


    /**
     * Sets the largeStreetFixed value for this Score.
     *
     * @param largeStreetFixed
     */
    public void setLargeStreetFixed(boolean largeStreetFixed) {
        this.largeStreetFixed = largeStreetFixed;
    }


    /**
     * Gets the ones value for this Score.
     *
     * @return ones
     */
    public int getOnes() {
        return ones;
    }


    /**
     * Sets the ones value for this Score.
     *
     * @param ones
     */
    public void setOnes(int ones) {
        this.ones = ones;
    }


    /**
     * Gets the onesFixed value for this Score.
     *
     * @return onesFixed
     */
    public boolean isOnesFixed() {
        return onesFixed;
    }


    /**
     * Sets the onesFixed value for this Score.
     *
     * @param onesFixed
     */
    public void setOnesFixed(boolean onesFixed) {
        this.onesFixed = onesFixed;
    }


    /**
     * Gets the sixes value for this Score.
     *
     * @return sixes
     */
    public int getSixes() {
        return sixes;
    }


    /**
     * Sets the sixes value for this Score.
     *
     * @param sixes
     */
    public void setSixes(int sixes) {
        this.sixes = sixes;
    }


    /**
     * Gets the sixesFixed value for this Score.
     *
     * @return sixesFixed
     */
    public boolean isSixesFixed() {
        return sixesFixed;
    }


    /**
     * Sets the sixesFixed value for this Score.
     *
     * @param sixesFixed
     */
    public void setSixesFixed(boolean sixesFixed) {
        this.sixesFixed = sixesFixed;
    }


    /**
     * Gets the smallStreet value for this Score.
     *
     * @return smallStreet
     */
    public int getSmallStreet() {
        return smallStreet;
    }


    /**
     * Sets the smallStreet value for this Score.
     *
     * @param smallStreet
     */
    public void setSmallStreet(int smallStreet) {
        this.smallStreet = smallStreet;
    }


    /**
     * Gets the smallStreetFixed value for this Score.
     *
     * @return smallStreetFixed
     */
    public boolean isSmallStreetFixed() {
        return smallStreetFixed;
    }


    /**
     * Sets the smallStreetFixed value for this Score.
     *
     * @param smallStreetFixed
     */
    public void setSmallStreetFixed(boolean smallStreetFixed) {
        this.smallStreetFixed = smallStreetFixed;
    }


    /**
     * Gets the threeOfAKind value for this Score.
     *
     * @return threeOfAKind
     */
    public int getThreeOfAKind() {
        return threeOfAKind;
    }


    /**
     * Sets the threeOfAKind value for this Score.
     *
     * @param threeOfAKind
     */
    public void setThreeOfAKind(int threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
    }


    /**
     * Gets the threeOfAKindFixed value for this Score.
     *
     * @return threeOfAKindFixed
     */
    public boolean isThreeOfAKindFixed() {
        return threeOfAKindFixed;
    }


    /**
     * Sets the threeOfAKindFixed value for this Score.
     *
     * @param threeOfAKindFixed
     */
    public void setThreeOfAKindFixed(boolean threeOfAKindFixed) {
        this.threeOfAKindFixed = threeOfAKindFixed;
    }


    /**
     * Gets the threes value for this Score.
     *
     * @return threes
     */
    public int getThrees() {
        return threes;
    }


    /**
     * Sets the threes value for this Score.
     *
     * @param threes
     */
    public void setThrees(int threes) {
        this.threes = threes;
    }


    /**
     * Gets the threesFixed value for this Score.
     *
     * @return threesFixed
     */
    public boolean isThreesFixed() {
        return threesFixed;
    }


    /**
     * Sets the threesFixed value for this Score.
     *
     * @param threesFixed
     */
    public void setThreesFixed(boolean threesFixed) {
        this.threesFixed = threesFixed;
    }


    /**
     * Gets the totalLowerHalf value for this Score.
     *
     * @return totalLowerHalf
     */
    public int getTotalLowerHalf() {
        return totalLowerHalf;
    }


    /**
     * Sets the totalLowerHalf value for this Score.
     *
     * @param totalLowerHalf
     */
    public void setTotalLowerHalf(int totalLowerHalf) {
        this.totalLowerHalf = totalLowerHalf;
    }


    /**
     * Gets the totalScore value for this Score.
     *
     * @return totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }


    /**
     * Sets the totalScore value for this Score.
     *
     * @param totalScore
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


    /**
     * Gets the totalUpperHalf value for this Score.
     *
     * @return totalUpperHalf
     */
    public int getTotalUpperHalf() {
        return totalUpperHalf;
    }


    /**
     * Sets the totalUpperHalf value for this Score.
     *
     * @param totalUpperHalf
     */
    public void setTotalUpperHalf(int totalUpperHalf) {
        this.totalUpperHalf = totalUpperHalf;
    }


    /**
     * Gets the twos value for this Score.
     *
     * @return twos
     */
    public int getTwos() {
        return twos;
    }


    /**
     * Sets the twos value for this Score.
     *
     * @param twos
     */
    public void setTwos(int twos) {
        this.twos = twos;
    }


    /**
     * Gets the twosFixed value for this Score.
     *
     * @return twosFixed
     */
    public boolean isTwosFixed() {
        return twosFixed;
    }


    /**
     * Sets the twosFixed value for this Score.
     *
     * @param twosFixed
     */
    public void setTwosFixed(boolean twosFixed) {
        this.twosFixed = twosFixed;
    }


    /**
     * Gets the upperHalfBonus value for this Score.
     *
     * @return upperHalfBonus
     */
    public int getUpperHalfBonus() {
        return upperHalfBonus;
    }


    /**
     * Sets the upperHalfBonus value for this Score.
     *
     * @param upperHalfBonus
     */
    public void setUpperHalfBonus(int upperHalfBonus) {
        this.upperHalfBonus = upperHalfBonus;
    }


    /**
     * Gets the upperHalfWithoutBonus value for this Score.
     *
     * @return upperHalfWithoutBonus
     */
    public int getUpperHalfWithoutBonus() {
        return upperHalfWithoutBonus;
    }


    /**
     * Sets the upperHalfWithoutBonus value for this Score.
     *
     * @param upperHalfWithoutBonus
     */
    public void setUpperHalfWithoutBonus(int upperHalfWithoutBonus) {
        this.upperHalfWithoutBonus = upperHalfWithoutBonus;
    }


    /**
     * Gets the yahtzee value for this Score.
     *
     * @return yahtzee
     */
    public int getYahtzee() {
        return yahtzee;
    }


    /**
     * Sets the yahtzee value for this Score.
     *
     * @param yahtzee
     */
    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
    }


    /**
     * Gets the yahtzeeBonus value for this Score.
     *
     * @return yahtzeeBonus
     */
    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }


    /**
     * Sets the yahtzeeBonus value for this Score.
     *
     * @param yahtzeeBonus
     */
    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
    }


    /**
     * Gets the yahtzeeFixed value for this Score.
     *
     * @return yahtzeeFixed
     */
    public boolean isYahtzeeFixed() {
        return yahtzeeFixed;
    }


    /**
     * Sets the yahtzeeFixed value for this Score.
     *
     * @param yahtzeeFixed
     */
    public void setYahtzeeFixed(boolean yahtzeeFixed) {
        this.yahtzeeFixed = yahtzeeFixed;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Score)) return false;
        Score other = (Score) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.carre == other.getCarre() &&
                this.carreFixed == other.isCarreFixed() &&
                this.chance == other.getChance() &&
                this.chanceFixed == other.isChanceFixed() &&
                this.fives == other.getFives() &&
                this.fivesFixed == other.isFivesFixed() &&
                this.fours == other.getFours() &&
                this.foursFixed == other.isFoursFixed() &&
                this.fullHouse == other.getFullHouse() &&
                this.fullHouseFixed == other.isFullHouseFixed() &&
                this.largeStreet == other.getLargeStreet() &&
                this.largeStreetFixed == other.isLargeStreetFixed() &&
                this.ones == other.getOnes() &&
                this.onesFixed == other.isOnesFixed() &&
                this.sixes == other.getSixes() &&
                this.sixesFixed == other.isSixesFixed() &&
                this.smallStreet == other.getSmallStreet() &&
                this.smallStreetFixed == other.isSmallStreetFixed() &&
                this.threeOfAKind == other.getThreeOfAKind() &&
                this.threeOfAKindFixed == other.isThreeOfAKindFixed() &&
                this.threes == other.getThrees() &&
                this.threesFixed == other.isThreesFixed() &&
                this.totalLowerHalf == other.getTotalLowerHalf() &&
                this.totalScore == other.getTotalScore() &&
                this.totalUpperHalf == other.getTotalUpperHalf() &&
                this.twos == other.getTwos() &&
                this.twosFixed == other.isTwosFixed() &&
                this.upperHalfBonus == other.getUpperHalfBonus() &&
                this.upperHalfWithoutBonus == other.getUpperHalfWithoutBonus() &&
                this.yahtzee == other.getYahtzee() &&
                this.yahtzeeBonus == other.getYahtzeeBonus() &&
                this.yahtzeeFixed == other.isYahtzeeFixed();
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
        _hashCode += getCarre();
        _hashCode += (isCarreFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getChance();
        _hashCode += (isChanceFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getFives();
        _hashCode += (isFivesFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getFours();
        _hashCode += (isFoursFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getFullHouse();
        _hashCode += (isFullHouseFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getLargeStreet();
        _hashCode += (isLargeStreetFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getOnes();
        _hashCode += (isOnesFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getSixes();
        _hashCode += (isSixesFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getSmallStreet();
        _hashCode += (isSmallStreetFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getThreeOfAKind();
        _hashCode += (isThreeOfAKindFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getThrees();
        _hashCode += (isThreesFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTotalLowerHalf();
        _hashCode += getTotalScore();
        _hashCode += getTotalUpperHalf();
        _hashCode += getTwos();
        _hashCode += (isTwosFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getUpperHalfBonus();
        _hashCode += getUpperHalfWithoutBonus();
        _hashCode += getYahtzee();
        _hashCode += getYahtzeeBonus();
        _hashCode += (isYahtzeeFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Score.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.yahtzee.kdg.be", "Score"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carreFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carreFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chanceFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chanceFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fives");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fives"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fivesFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fivesFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fours");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foursFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foursFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullHouse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullHouse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullHouseFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullHouseFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largeStreet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largeStreet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largeStreetFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largeStreetFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onesFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onesFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sixes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sixes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sixesFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sixesFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallStreet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smallStreet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallStreetFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smallStreetFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threeOfAKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "threeOfAKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threeOfAKindFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "threeOfAKindFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "threes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("threesFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "threesFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalLowerHalf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalLowerHalf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalScore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalUpperHalf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalUpperHalf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("twos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "twos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("twosFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "twosFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upperHalfBonus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upperHalfBonus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upperHalfWithoutBonus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upperHalfWithoutBonus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yahtzee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yahtzee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yahtzeeBonus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yahtzeeBonus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yahtzeeFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yahtzeeFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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

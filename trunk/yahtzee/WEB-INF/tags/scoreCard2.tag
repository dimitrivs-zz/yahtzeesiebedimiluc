<%@ tag import="be.kdg.yahtzee.model.users.User" %>
<%@ tag body-content="empty" %>
<jsp:useBean id="gameBean" class="be.kdg.yahtzee.beans.GameBean" scope="session"/>



<h:dataTable value='#{items}' var='item'>


    <h:column>

        <%-- left column components --%>

        <h:outputText value='#{item.propertyName}'/>

    </h:column>



    <h:column>

        <%-- next column components --%>

        <h:outputText value='#{item.anotherPropertyName}'/>

    </h:column>



    <%-- add more columns, as desired --%>

</h:dataTable>










<table border="1" cellpadding="0" cellspacing="0">
<tr>
    <% Object[] players = gameBean.getUsersOfGame().toArray(); %>
    <td>Players</td>
    <td id="p1name"><% User player = (User) players[0]; %><%= player.getUsername() %>
    </td>
    <td></td>
</tr>
<tr>
    <td>count all ones</td>
    <td id="p1ones" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>count all two's</td>
    <td id="p1twos" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>count all threes</td>
    <td id="p1threes" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>count all fours</td>
    <td id="p1fours" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>count all fives</td>
    <td id="p1fives" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>count all sixes</td>
    <td id="p1sixes" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td><b>Total upper half</b></td>
    <td id="p1upper"></td>
    <td></td>
</tr>
<tr>
    <td><b>Bonus</b></td>
    <td id="p1upperbonus"></td>
    <td></td>
</tr>
<tr>
    <td><b>Total upper half (+bonus)</b></td>
    <td id="p1upperTotal"></td>
    <td></td>
</tr>
<tr>
    <td>three of a kind</td>
    <td id="p1threeOfAKind" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>carr&eacute;</td>
    <td id="p1carre" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>full house</td>
    <td id="p1fullHouse" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>small street</td>
    <td id="p1smallStreet" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>large street</td>
    <td id="p1largeStreet" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>yahtzee</td>
    <td id="p1yahtzee" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>chance</td>
    <td id="p1chance" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td>yahtzee bonus</td>
    <td id="p1yahtzeebonus" onclick="selectScore(this.id)"></td>
    <td></td>
</tr>
<tr>
    <td><b>total lower half</b></td>
    <td id="p1lowerTotal"></td>
    <td></td>
</tr>
<tr>
    <td><b>total score</b></td>
    <td id="p1total"></td>
    <td></td>
</tr>

</table>

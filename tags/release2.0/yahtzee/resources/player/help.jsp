<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view locale="#{language}">
<f:loadBundle basename="bundles.resources" var="labels"/>
<html>
<head>
    <link href="../css/helpStyle.css" rel="stylesheet" type="text/css"/>
    <title>Help</title>
</head>
<body>
<div id="help">
<h1>INHOUDSTAFEL</h1>
<ul>
    <li><a href="#doel">Doel van het spel</a></li>
    <li><a href="#spel">Het spel in het kort</a></li>
    <li><a href="#dobbel">Dobbelstenen gooien</a></li>
    <li><a href="#score">Punten scoren</a></li>
    <li><a href="#mogelijkheden">De verschillende scoremogelijkheden</a></li>
    <li><a href="#optellen">Al je punten bij elkaar optellen</a></li>
    <li><a href="#winnaar">De winnaar</a></li>
    <li><a href="#strategie">Strategie</a></li>
</ul>
<a id="doel"></a>

<h1>DOEL VAN HET SPEL</h1>
Gooi verschillende dobbelsteencombinaties om alle 13 categorie&euml;n van het scoreblaadje te vullen en op deze manier
een zo hoog mogelijke score te behalen.<br/><br/>
<a id="spel"></a>

<h1>HET SPEL IN HET KORT</h1>
Als je aan de beurt bent, gooi je de dobbelstenen maximaal drie keer in een poging een van de mogelijke scorecombinaties
te verkrijgen. Kies je score in een van de 13 scorevakjes: er staan zes van die vakjes op de bovenste
helft van de scoretabel en zeven op de onderste helft.
Je mag de vakjes in willekeurige volgorde kiezen, maar je moet na elke beurt &eacute;&eacute;n vakje nemen. Als alle
vakjes
zijn ingevuld, worden de punten bij elkaar geteld &ndash; inclusief de eventuele bonuspunten die je tijdens het spel
verdiend hebt &ndash;
tot een Eindtotaal.
De speler met het hoogste Eindtotaal is de winnaar.<br/>
<br/>
<strong>Let op:</strong> je kunt Yahtzee spelen met maximum 4 spelers. Maar je kunt
natuurlijk ook in je eentje spelen en steeds proberen je eigen record te verbeteren.<br/><br/>
<a id="dobbel"></a>

<h1>DOBBELSTENEN GOOIEN</h1>
<ol>
    <li>Als je aan de beurt bent, mag je de dobbelstenen maximaal drie keer gooien. Je mag echter ook na je eerste of
        tweede worp stoppen.
    </li>
    <li>Voor je eerste worp gooi je met <strong>alle dobbelstenen</strong> in de dobbelbak</li>
    <li>Voor je tweede en derde worp mag je <strong>een aantal</strong> of <strong>alle</strong> dobbelstenen weer
        oppakken en nog eens gooien. Klik de dobbelstenen die je wilt houden zodat deze naar het andere vak worden
        verplaatst.
    </li>
    <li>Je derde worp bepaalt je score.</li>
</ol>
<a id="score"></a>

<h1>PUNTEN SCOREN</h1>
De scoretabel bestaat uit twee helften. Je kunt de volgende scores in de bijbehorende vakjes van de bovenste helft laten
invullen.
<h2>Bovenste helft</h2>
<strong>Van enen tot zessen:</strong><br>
Als je één of meer enen gooit, klik je op het vakje van de enen; gooi je één of meer tweeën, dan klik je op het vakje
van de tweeën, enz. enz.<br>
<br>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die3.png" alt="3"><img src="../images/die3.png" alt="3"><img
        src="../images/die5.png" alt="5"><img src="../images/die1.png" alt="1"><img src="../images/die2.png"
                                                                                    alt="2"><br/>
<br/>
Tel alleen de drieën bij elkaar en negeer je andere dobbelstenen. Je noteert je score van 6 punten in het vakje voor de
drieën.<br>

<h2>Onderste helft</h2>
Op de onderste helft van de scoretabel staan een aantal speciale scorecombinaties:<br/>
<br/>
<strong>Drie dezelfde:</strong><br>
Gooi drie dezelfde dobbelstenen en twee willekeurige andere.<br>
<br>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die3.png" alt="3"><img src="../images/die3.png" alt="3"><img
        src="../images/die3.png" alt="3"><img src="../images/die6.png" alt="6"><img src="../images/die4.png"
                                                                                    alt="4"><br>
<br>
Je hebt drieën gegooid. De score wordt opgeteld zoals hierboven dus in dit voorbeeld scoor je 19 punten.<br>
<br>
<strong>Carré:</strong><br>
Gooi vier dezelfde dobbelstenen en één andere.<br>
<br>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die5.png" alt="5"><img src="../images/die5.png" alt="5"><img
        src="../images/die5.png" alt="5"><img src="../images/die5.png" alt="5"><img src="../images/die1.png"
                                                                                    alt="1"><br/>
<br/>
Je hebt vier vijven gegooid. De score wordt opgeteld zoals hierboven dus in dit voorbeeld scoor je 21 punten.<br/>
<br/>
<strong>Full House:</strong><br/>
Gooi drie dezelfde en twee dezelfde.<br/>
<br/>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die5.png" alt="5"><img src="../images/die5.png" alt="5"><img
        src="../images/die5.png" alt="5"><img src="../images/die2.png" alt="2"><img src="../images/die2.png"
                                                                                    alt="2"><br/>
<br/>
Je hebt drie vijven en twee vieren gegooid. De score voor Full House is altijd 25.<br/>
<br/>
<strong>Kleine straat:</strong><br/>
Gooi vier opvolgende getallen.<br/>
<br/>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die2.png" alt="2"><img src="../images/die3.png" alt="3"><img
        src="../images/die4.png" alt="4"><img src="../images/die5.png" alt="5"><img src="../images/die3.png"
                                                                                    alt="3"><br/>
<br/>
Je gooit een ononderbroken reeks van vier getallen (2, 3, 4, 5). Andere mogelijkheden zijn 1, 2, 3, 4 en 3, 4, 5,
6.<br/>
De score voor een kleine straat is altijd 30..<br/>
<br/>
<strong>Grote straat:</strong><br/>
Gooi vijf opvolgende getallen.<br/>
<br/>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die1.png" alt="1"><img src="../images/die2.png" alt="2"><img
        src="../images/die3.png" alt="3"><img src="../images/die4.png" alt="4"><img src="../images/die5.png"
                                                                                    alt="5"><br/>
<br/>
Je gooit een ononderbroken reeks van vijf getallen (1, 2, 3, 4, 5). De andere mogelijkheid is 2, 3, 4, 5, 6.<br/>
De score voor een grote straat is altijd 40.<br/>
<strong>Let op:</strong> je kunt een grote straat ook altijd nog scoren als een kleine straat met 30 punten.<br/>
<br/>
<strong>Yahtzee:</strong><br/>
Gooi vijf dezelfde getallen.<br/>
<br/>
<strong id="bv">Bijvoorbeeld:</strong><img src="../images/die3.png" alt="3"><img src="../images/die3.png" alt="3"><img
        src="../images/die3.png" alt="3"><img src="../images/die3.png" alt="3"><img src="../images/die3.png"
                                                                                    alt="3"><br/>
<br/>
Je hebt vijf drieën gegooid. Je hebt een Yahtzee! De score voor een Yahtzee is altijd 50.<br/>
<br/>
<strong>Chance:</strong><br/>
Gebruik het vakje van Chance als je een combinatie gooit waarvoor je al gescoord hebt, of wanneer je niet KUNT
scoren in een van de nog beschikbare vakjes.<br/>
<br/>
<a id="mogelijkheden"></a>

<h1>DE VERSCHILLENDE SCOREMOGELIJKHEDEN</h1>
Hier komen vaardigheid en strategie te pas! Als je Yahtzee speelt, beslis JIJ in welk vakje je een bepaalde score
noteert. Dat is afhankelijk van jouw persoonlijke strategie. Als je maar niet vergeet dat je in elk vakje maar één score
kunt invullen. Je doel is en blijft de hoogst mogelijke score te noteren in alle 13 de scorevakjes. Na je derde worp
met de dobbelstenen kies je in welk vakje je de punten noteert.<br/>
<br/>
<strong id="bv">Bijvoorbeeld:</strong><br/>
Stel dat je na je derde worp dit in de dobbelbak hebt liggen:<br/>
<br/>
<center>
    <img src="../images/die3.png" alt="3"><img src="../images/die3.png" alt="3"><img src="../images/die3.png"
                                                                                     alt="3"><img
        src="../images/die5.png" alt="5"><img src="../images/die5.png" alt="5">
</center>
<br/>
<table>
    <tr>
        <th colspan="3">Nu kun je kiezen uit de volgende scoremogelijkheden:</th>
        <th>Score</th>
    </tr>
    <tr>
        <td>A</td>
        <td>Drieën</td>
        <td>Tel alleen de drieën</td>
        <td>9</td>
    </tr>
    <tr>
        <td>B</td>
        <td>Vijven</td>
        <td>Tel alleen de vijven</td>
        <td>10</td>
    </tr>
    <tr>
        <td>C</td>
        <td>3 dezelfde</td>
        <td>Totaal van alle stenen</td>
        <td>19</td>
    </tr>
    <tr>
        <td>D</td>
        <td>Full House</td>
        <td>Vaste score</td>
        <td>25</td>
    </tr>
    <tr>
        <td>E</td>
        <td>Chance</td>
        <td>Totaal van alle stenen</td>
        <td>19</td>
    </tr>
</table>
<h3>NUL NOTEREN</h3>
Als het spel vordert, zul je soms ondervinden dat alle mogelijke scorevakjes al zijn ingevuld. In dat geval zul je een 0
(nul) moeten noteren in een van de overgebleven vakjes. Denk eraan dat je aan het eind van elke beurt één vakje
moet invullen.<br/>
Als de vakjes voor mogelijkheid A t/m E in het voorbeeld hierboven al zijn ingevuld, dan MOET je een 0 noteren in
een van je andere nog lege vakjes.
<h3>35 BONUSPUNTEN</h3>
Als je in de bovenste helft van de tabel een totaalscore van 63 of meer behaalt, dan verdien je een bonus van 35
punten die genoteerd worden in het Bonusvak op de scoretabel.<br/>
<br/>
<strong>Tip:</strong> als je minimaal drie dezelfde in elk van de
zes vakjes van de bovenste helft scoort, dan bereik je het vereiste aantal van 63 punten precies
<h3>YAHTZEE BONUS</h3>
Als je een Yahtzee gooit, scoor je 50 punten. Maar voor elke Yahtzee die je daarna gooit verdien je een bonus van
maar liefst 100 punten. Daar is echter één voorwaarde aan verbonden; en dat is dat er al een Yahtzee gescoord is
in het Yahtzee-vakje (dus geen 0). Zonder eerste Yahtzee heb je namelijk geen recht op Yahtzee Bonuspunten!<br/><br/>
<a id="optellen"></a>

<h1>AL JE PUNTEN BIJ ELKAAR OPTELLEN</h1>
Het algemeen totaal voor elk spel wordt als volgt bij elkaar geteld:<br/>
<ol>
    <li>Het totaal van de zes scorevakjes in de bovenste helft bij elkaar, plus</li>
    <li>35 bonuspunten als het totaal van de bovenste helft 63 punten is of meer, plus</li>
    <li>alle eventueel verdiende Yahtzee Bonuspunten, plus</li>
    <li>het totaal van de zeven scorevakjes in de onderste helft.</li>
</ol>
<a id="winnaar"></a>

<h1>DE WINNAAR</h1>
Als alle spelers hun 13 vakjes hebben ingevuld, worden alle scores opgeslagen. De speler met de
meeste punten wint het spel.<br/><br/>
<a id="strategie"></a>

<h1>STRATEGIE</h1>
Hier volgen een paar nuttige strategische tips:<br/>
<br/>
<strong>Bovenste helft</strong>
<ul>
    <li>Probeer de 35 bonuspunten voor de bovenste helft van de scoretabel zo snel mogelijk te bemachtigen door
        63 punten (of meer) te scoren. Als je te lang wacht, wordt je wellicht gedwongen ergens een 0 te noteren.
    </li>
    <li>Vul als je niet anders kan een 0 in op het vakje van de enen. Dit verlies kun je namelijk al goedmaken met een
        extra drie, vier, vijf of zes in de bovenste helft om toch de 63 punten te bereiken voor je 35 felbegeerde
        bonuspunten.
    </li>
</ul>
<strong>Onderste helft</strong>
<ul>
    <li>Probeer je Chance-vakje zo lang mogelijk open te houden. Tegen het eind van het spel heb je nu eenmaal
        steeds minder mogelijkheden.
    </li>
    <li>Als het spel bijna voorbij is, kun je een 0 noteren in het Yahtzee-vakje, of in een van de andere lastige
        vakjes.
        Maar als je tegenstander(s) deze vakjes op hun tabel wél hebben ingevuld, moet je misschien alles op alles
        zetten en gokken op een fantastische worp!
    </li>
</ul>
</div>
</body>
</html>
</f:view>

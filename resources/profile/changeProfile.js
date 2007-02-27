function checkProfileForm() {
    var form = document.changeProfile;
    var message = "";

    if (!form.mail.value) {
        message += "Het email adres moet een waarde hebben\n";
        return false;
    }

    if (form.number.value && !form.number.value.match(illegalNums)) {
        alert("fout");
        return false;
    } else if (form.zip.value && (!form.zip.value.match(illegalNums) || form.zip.value.length != 4)) {
        alert("fout");
        return false;
    } else if (message != "") {
        var mes = "fout\n" + message;
        alert(mes);
        return false;
    }
    return true;
}
function checkPassForm() {
    var form = document.changePassword;
    var message = "";
    if (!form.orgPass.value) message += "* Het veld origineel password mag niet leeg zijn\n";
    if (!form.pw.value) message += "* Het veld password mag niet leeg zijn\n";
    if (!form.pw2.value) message += "* Het veld bevestig password mag niet leeg zijn\n";
    var illegalChars = /^[0-9a-zA-Z]+$/;
    var illegalNums = /[0-9]+$/;

    if (!form.orgPass.value.match(illegalChars)) {
        alert("Het origineel passwoord bevat illegale karakters");
        return false;
    }

    if (form.pw.value.length < 6 || !form.pw.value.match(illegalChars)) {
        alert("Het passwoord is te klein of bevat illegale karakters");
        return false;
    } else if (form.pw.value != form.pw2.value) {
        alert("Het password en de bevestiging van het password zijn niet gelijk");
        return false;
    }

    if (message != "") {
        var mes = "fout\n" + message;
        alert(mes);
        return false;
    }
    return true;
}
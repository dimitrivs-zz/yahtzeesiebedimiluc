package be.kdg.yahtzee;

public class TestAllUsers {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main(
                "be.kdg.yahtzee.users.TestBlockUser",
                "be.kdg.yahtzee.users.TestChangePassword",
                "be.kdg.yahtzee.users.TestChangeProfile",
                "be.kdg.yahtzee.users.TestLogin",
                "be.kdg.yahtzee.users.TestOnlineUsers",
                "be.kdg.yahtzee.users.TestRegistratieUser",
                "be.kdg.yahtzee.users.TestRemoveUser",
                "be.kdg.yahtzee.users.TestSearch");
    }
}

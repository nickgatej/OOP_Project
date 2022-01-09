package start;

import controller.LoginPageController;
import model.IDandPasswords;
import view.LoginPage;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        IDandPasswords iDandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage();
        LoginPageController loginPageController = new LoginPageController(loginPage, iDandPasswords.getLoginInfo());
    }
}
package run;

import router.Router;
import router.Option;
import views.JFrameMain;
import controllers.PersonController;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        PersonController personController = new PersonController();
        JFrameMain jFrameMain = new JFrameMain();
        /*jFrameLoginIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrameLoginIn.setBounds(0, 0, 1000, 1000);
        jFrameLoginIn.setLocationRelativeTo(null);*/
       // jFrameMain.setVisible(true);

        Router.instance = new Router(jFrameMain);
        Router.instance.navigate(Option.login, personController);
    }
}

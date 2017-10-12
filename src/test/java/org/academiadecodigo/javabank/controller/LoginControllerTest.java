package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    private LoginController loginController;
    private View view;
    private AuthServiceImpl authService;
    private Controller controller;

    @Before
    public void setupUp(){
        loginController = new LoginController();
        view = Mockito.mock(View.class);
        loginController.setView(view);

        authService = Mockito.mock(AuthServiceImpl.class);
        controller = Mockito.mock(Controller.class);
        loginController.setNextController(controller);
        loginController.setAuthService(authService);
    }

    @Test
    public void initTest(){
        loginController.init();
        Mockito.verify(view).show();
    }

    @Test
    public void onLoginTest(){

        int fakeID = 1;

        when(authService.authenticate(fakeID)).thenReturn(true);

        loginController.onLogin(fakeID);

        Mockito.verify(controller).init();

    }

    @Test
    public void onLoginFail(){

        int fakeID = 1;

        when(authService.authenticate(fakeID)).thenReturn(false);

        loginController.onLogin(fakeID);

        Mockito.verify(controller, never()).init();


    }

}

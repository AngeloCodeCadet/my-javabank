package io.codeforall.bootcamp.javabank.controller;

import io.codeforall.bootcamp.javabank.service.AuthServiceImp;
import io.codeforall.bootcamp.javabank.service.CustomerServiceImp;
import io.codeforall.bootcamp.javabank.view.LoginView;

/**
 * The {@link LoginView} controller
 */
public class LoginController extends AbstractController {

    private Controller nextController;

    private CustomerServiceImp customerServiceImp;
    private AuthServiceImp authServiceImp;

    /**
     * Sets the next controller
     *
     * @param nextController the next controller to be set
     */
    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    /**
     * Sets the bank
     *
     * @param bank the bank to be set
     */
    public void setBank(CustomerServiceImp customerServiceImp) {
        this.customerServiceImp = customerServiceImp;
    }

    /**
     * Identifies the logged in customer
     *
     * @param id the customer id
     */
    public void onLogin(int id) {
        if (authServiceImp.authenticate(id)) {
            nextController.init();
        } else {
            init();

        }
    }

    public void setAuthService(AuthServiceImp authServiceImp){
            this.authServiceImp = authServiceImp;
        }

}

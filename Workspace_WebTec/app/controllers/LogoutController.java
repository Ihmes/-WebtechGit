package controllers;


import play.api.mvc.Session;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;



/**
 * Created by Markus on 19.01.14.
 */
//@Security.Authenticated(Secured.class)
public class LogoutController extends Controller {

    public static Result logout() {
    session().clear();
    return ok(views.html.index.render("Du hast Dich erfolgreich ausgeloggt"));
    }
}

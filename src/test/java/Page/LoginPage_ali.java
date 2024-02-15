package Page;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_ali {
    ReusableMethods ru=new ReusableMethods();
        public LoginPage_ali() {
            PageFactory.initElements(Driver.getDriver(), this);

        }



@FindBy(xpath = "(//button[@data-variant='normal'])[1]")
    WebElement joinButton;

        public void joinButtonClick(){
            ru.waitFor(2);
            joinButton.click();

        }
@FindBy(id="email")
    WebElement email;
public void emailClick(){
    ru.waitFor(2);
    email.click();
    email.clear();
    email.sendKeys("ali2@gmail.com");
    email.click();
}

    @FindBy(id="password")
    WebElement password;
public void passwordClick(){
    ru.waitFor(2);

    password.click();
    password.clear();
    password.sendKeys("123456");
    password.click();
}

@FindBy(xpath = "*//button[text()=\"Login\"]")
    WebElement loginButton;


public void loginButtonClick(){
    ru.waitFor(2);


    loginButton.click();
}
        }

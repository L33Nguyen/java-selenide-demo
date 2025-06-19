package pages.OrangeHRMPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;


public class OrangeHRMPage {
	
	private final SelenideElement userName = $("[name='username']");
    private final SelenideElement inputFieldErrorMessage = $("span.oxd-input-field-error-message");
    
	public void openHome() {
        open("https://opensource-demo.orangehrmlive.com/");
    }
	 public void enterUserName(String uname) {
		 userName.setValue(uname).pressEnter();
	    }

    public void verifyErrorMessageVisible() {
    	inputFieldErrorMessage.shouldHave(text("Required"));
    }

	
}

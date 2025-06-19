package controls;

import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.SelenideElement;

public class DropDown implements CustomElement {
	private final SelenideElement dropdown ;
    public DropDown(SelenideElement dropdown) {
        this.dropdown = dropdown;
    }
    
    @Override
    public SelenideElement getWrappedElement() {
        return dropdown;
    }

    public void selectByVisibleText(String text) {
        dropdown.selectOption(text);
    }

    public void selectByValue(String value) {
        dropdown.selectOptionByValue(value);
    }

    public void shouldHaveSelected(String text) {
        dropdown.getSelectedOption().shouldHave(text(text));
    }
}

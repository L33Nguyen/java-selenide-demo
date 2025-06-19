package controls;

import com.codeborne.selenide.SelenideElement;

public class ShadowHost implements CustomElement{
	private final SelenideElement host;
    public ShadowHost(SelenideElement host) {
        this.host = host;
    }
	@Override
	public SelenideElement getWrappedElement() {
		// TODO Auto-generated method stub
		return null;
	}
	public SelenideElement shadowFind(String cssSelector) {
        return ((SelenideElement) host.getShadowRoot()).find(cssSelector);
    }

    public String shadowText(String cssSelector) {
        return shadowFind(cssSelector).getText();
    }
    
}

package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import utils.Utilities;

public class CommonSteps extends Utilities {

    @Before
    public void startDriver(){initialize();}

    @After
    public void terminateDriver(){terminate();}

    @Given("Navigate to {}")
    public void browserNavigate(String url){driver.get(url);}

    @Given("Go to {} page")
    public void predeterminedNavigation(String pageName){predeterminedNavigate(pageName);}

    @Given("Wait for {}")
    public void browserNavigate(double duration){waitFor(duration);}

}

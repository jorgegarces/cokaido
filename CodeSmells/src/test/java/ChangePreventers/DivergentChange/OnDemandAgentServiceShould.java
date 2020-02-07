package ChangePreventers.DivergentChange;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OnDemandAgentServiceShould {

    @Test
    public void startingANewVMFillHostAnIPOnOnDEmandAgent()
    {
        OnDemandAgentService service = new OnDemandAgentService();
        List<String> log = new ArrayList<>();
        service.log = log;
        service.password = "passw0rd";
        service.username = "admin";

        OnDemandAgent agent = service.startNewOnDemandMachine();

        assertNotEquals(agent.getHost(), "");
        assertNotEquals(agent.getIp(), "");
    }

    @Test
    public void throwsNotUthorizedIfInvalidCredentials()
    {
        OnDemandAgentService service = new OnDemandAgentService();
        List<String> log = new ArrayList<>();
        service.log = log;
        service.password = "";
        service.username = "";

        assertThrows(RuntimeException.class, () -> service.startNewOnDemandMachine());
    }
}

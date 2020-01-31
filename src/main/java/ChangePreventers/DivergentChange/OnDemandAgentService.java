package ChangePreventers.DivergentChange;

import java.util.List;

public class OnDemandAgentService {
    public String username;
    public String password;
    public List<String> log;

    public OnDemandAgent startNewOnDemandMachine()
    {
        loginfo("Starting on-demand agent startup logic");

        try
        {
            if (isAuthorized(username, password)) return startMachine();
            return warningAndUnauthorized();
        }
        catch (Exception ex)
        {
            return throwException(ex);
        }
    }

    private OnDemandAgent throwException(Exception ex) {
        log.add("ERROR: " + "Exception in on-demand agent creation logic");
        throw new RuntimeException(ex);
    }

    private OnDemandAgent warningAndUnauthorized() {
        log.add("WARNING: " + ("User " + username + " attempted to start a new on-demand agent."));
        throw new RuntimeException("Unauthorized access to StartNewOnDemandMachine method.");
    }

    private OnDemandAgent startMachine() {
        loginfo(String.format("User %s will attempt to start a new on-demand agent.", username));
        OnDemandAgent agent = startNewAmazonServer();
        sendEmailToAdmin(String.format("User %s has successfully started a machine with ip %s.", username, agent.getIp()));
        return agent;
    }


    private OnDemandAgent startNewAmazonServer()
    {
        // Call Amazon API and start a new EC2 instance, implementation omitted
        OnDemandAgent amazonAgent = new OnDemandAgent();
        amazonAgent.setHost("usweav-ec2.mycompany.local");
        amazonAgent.setIp("54.653.234.23");
        amazonAgent.setImageId("ami-784930");
        return amazonAgent;
    }

    private void loginfo(String info) {
        log.add("INFO: " + info);
    }

    private boolean isAuthorized(String username, String password)
    {
        return username.equals("admin") && password.equals("passw0rd");
    }

    private void sendEmailToAdmin(String message)
    {
        String emailHost = "email.mycompany.com";
        String recipient = "admin@mycompany.com";

        // actual email sending implementation omitted
    }

}

package army.helpful.app.it;
public class Environment {
    public static Environment LOCAL = new Environment("http://localhost:8080");

    private final String service;

    Environment(String url) {
        this.service = url+ "/";
    }

    public String getService() {
        return service;
    }

    public static Environment current() {
        final String environment = System.getProperty("IT_TARGET");
        if (environment != null) {
            return new Environment(environment);
        }
        return Environment.LOCAL;
    }
}

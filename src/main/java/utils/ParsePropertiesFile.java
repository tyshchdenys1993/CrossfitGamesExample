package utils;

public class ParsePropertiesFile {
    private String login;
    private String password;

    public ParsePropertiesFile() {
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
        login = propertiesUtil.get("credentials.properties", "login");
        password = propertiesUtil.get("credentials.properties", "password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

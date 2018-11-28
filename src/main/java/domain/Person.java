package domain;

public class Person {
    private String name;
    private String rNumber;
    private String githubUrl;

    public Person(String name, String rNumber, String githubUrl) {
        this.name = name;
        this.rNumber = rNumber;
        this.githubUrl = githubUrl;
    }

    public String getName() {
        return name;
    }

    public String getrNumber() {
        return rNumber;
    }

    public String getGithubUrl() {
        return githubUrl;
    }
}

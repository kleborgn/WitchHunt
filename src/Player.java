public abstract class Player {

    private String name;
    private int points;
    private IdentityCard identityCard;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void pickIdentity(Identities identity) {
        this.identityCard = new IdentityCard(identity);
    }



    public void addPoints(int points) {
        this.points += points;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}

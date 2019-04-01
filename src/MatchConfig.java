public class MatchConfig {
    public int playerAvatar,match,level,livesLeft,ammo,targets;

    public MatchConfig(int playerAvatar,int match,int level,int livesLeft,int ammo,int targets){
        this.playerAvatar=playerAvatar;
        this.match=match;
        this.level=level;
        this.livesLeft=livesLeft;
        this.ammo=ammo;
        this.targets=targets;
    }
// default match builder
    public MatchConfig() {
        playerAvatar =1;
        match=1;
        level=1;
        livesLeft=5;
        ammo=50;
        targets=50;
    }

    public int getPlayerAvatar() {
        return playerAvatar;
    }

    public void setPlayerAvatar(int playerAvatar) {
        this.playerAvatar = playerAvatar;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getTargets() {
        return targets;
    }

    public void setTargets(int targets) {
        this.targets = targets;
    }
}

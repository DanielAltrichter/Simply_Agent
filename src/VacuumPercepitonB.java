/**
 * Created by daniel on 30.03.17.
 */
public class VacuumPercepitonB extends  VacuumPerception {
    boolean clean;
    VacuumWorld.world position;

    public boolean isClean() {
        return clean;
    }

    public VacuumWorld.world getPosition() {
        return position;
    }

    public VacuumPercepitonB(boolean clean, VacuumWorld.world position) {
        this.clean = clean;
        this.position = position;

    }
}

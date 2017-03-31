/**
 * Created by daniel on 30.03.17.
 */
public class VacuumPercepitonA extends VacuumPerception {
    private VacuumWorld.world position;
    private VacuumWorld world;

    public VacuumPercepitonA(VacuumWorld.world position, VacuumWorld world) {
        this.position = position;
        this.world = world;
    }

    public VacuumWorld.world getPosition() {
        return position;
    }

    public VacuumWorld getWorld() {
        return world;
    }
}

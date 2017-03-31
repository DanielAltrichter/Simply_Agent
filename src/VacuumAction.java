import javax.management.RuntimeErrorException;

/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumAction {
    public enum Aecktion  {LEFT, RIGHT, CLEAN, STOP}

    public static int countActions = 0;

    public static VacuumWorld action(Aecktion aecktion, VacuumWorld world) {
        countActions++;
        System.out.println("\nIncoming Action: " + aecktion);
        System.out.println("Vorher:\nworld:   " + world.clean + "\nposition:   " + world.agentPosition );

        switch (aecktion) {
            case LEFT:
                switch (world.agentPosition) {
                    case MIDDLE:
                        world.agentPosition = VacuumWorld.world.LEFT;
                        break;

                    case RIGHT:
                        if (VacuumWorld.secondWorld) {
                            world.agentPosition = VacuumWorld.world.LEFT;
                        }else {
                            world.agentPosition = VacuumWorld.world.MIDDLE;
                        }
                        break;

                    default:
                        throw new RuntimeException("Der Roboter ist vom Rand der Welt gefallen");
                }
                break;
            case RIGHT:
                switch (world.agentPosition) {
                    case MIDDLE:
                        world.agentPosition = VacuumWorld.world.RIGHT;
                        break;

                    case LEFT:
                        if (VacuumWorld.secondWorld) {
                            world.agentPosition = VacuumWorld.world.RIGHT;
                        }else {
                            world.agentPosition = VacuumWorld.world.MIDDLE;
                        }
                        break;

                    default:
                        throw new RuntimeException("Der Roboter ist vom Rand der Welt gefallen");
                }
                break;
            case CLEAN:
                world.clean.replace(world.agentPosition, true);
                break;
            case STOP:
                System.out.println("Roboter beendet den shit, benötigte Schritte: " + countActions + "\n");
                System.out.println("world:   " + world.clean + "\nposition:   " + world.agentPosition );
                return null;
            default:
                throw new RuntimeException("Alles kaputt");
        }

        System.out.println("------------\nNachher:\nworld:   " + world.clean + "\nposition:   " + world.agentPosition );
        return world;
    }
}

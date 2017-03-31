import javax.management.RuntimeErrorException;
import java.util.ArrayList;

/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumReflexAgent {

    public static ArrayList<String> table = new ArrayList<String>();
    public static char PERCEPTION_TYPE = 'a'; //Perception Type a oder b
    private VacuumAction.Aecktion lastAecktion = null;
    private String worldState = "";


    public VacuumAction.Aecktion agentFunction(VacuumPerception perception) {
        if (PERCEPTION_TYPE == 'a') {
            System.out.println("VacuumPerceptionA.");
            return agentFunction((VacuumPercepitonA) perception);
        } else if (PERCEPTION_TYPE == 'b') {
            System.out.println("VacuumPerceptionB.");
            return agentFunction((VacuumPercepitonB) perception);
        }


        throw new IllegalArgumentException("Perception_Type falsch gesetztz");
    }

    public VacuumAction.Aecktion agentFunction(VacuumPercepitonB percepiton) {
        if (percepiton.clean == false) {
            return lastAecktion = VacuumAction.Aecktion.CLEAN;
        } else {
            VacuumWorld.world myPosition = percepiton.getPosition();
            switch (myPosition) {
                case LEFT: //Wir stehen links, und es ist sauber, können nur nach rechts.
                    return lastAecktion = VacuumAction.Aecktion.RIGHT;

                case RIGHT: //Wir stehen rechts und es ist sauber, also nach links.
                    return lastAecktion = VacuumAction.Aecktion.STOP;

                case MIDDLE: //Wir stehen in der Mitte und es ist sauber, also nach links oder rechts?
                    if (lastAecktion == null || lastAecktion == VacuumAction.Aecktion.CLEAN) {
                        return lastAecktion = VacuumAction.Aecktion.LEFT;
                    } else if (lastAecktion == VacuumAction.Aecktion.RIGHT) {
                        return lastAecktion = VacuumAction.Aecktion.RIGHT;
                    } else {
                        throw new RuntimeException("Hier geht gerade alles daneben, angeblich nicht alles sauber, aber doch alles sauber...");
                    }
            }
        }
        throw new RuntimeException("sollte nicht erreichbar sein");
    }

    public VacuumAction.Aecktion agentFunction(VacuumPercepitonA percepiton) {
        if (percepiton.getWorld().clean.containsKey(VacuumWorld.world.MIDDLE)){
            worldState = worldState + "[" + percepiton.getWorld().clean.get(VacuumWorld.world.LEFT) +
                    ", " + percepiton.getWorld().clean.get(VacuumWorld.world.MIDDLE) + ", "
                    + percepiton.getWorld().clean.get(VacuumWorld.world.RIGHT) + ", " +
                    percepiton.getPosition() + "]";
        }
        else {
            worldState = worldState + "[" + percepiton.getWorld().clean.get(VacuumWorld.world.LEFT) +
                    ", " + percepiton.getWorld().clean.get(VacuumWorld.world.RIGHT) + ", " +
                    percepiton.getPosition() + "]";
        }

        VacuumWorld.world myPosition = percepiton.getPosition();
        VacuumWorld myWorld = percepiton.getWorld();

        if (myWorld.clean.get(myPosition) == false) {//Das Feld auf dem wir stehen ist dreckig?
            table.add(worldState + "; " + VacuumAction.Aecktion.CLEAN);
            return VacuumAction.Aecktion.CLEAN;
        } else { //Das Feld, auf dem wir stehen ist sauber

            //Überhaupt dreckige Felder vorhanden?
            if (!(myWorld.clean.values().contains(false))) {
                //Alle sauber (kein dreckiges enthalten)
                table.add(worldState + "; " + VacuumAction.Aecktion.STOP);
                return VacuumAction.Aecktion.STOP;
            } else { //nicht alle Felder sauber
                switch (myPosition) {
                    case LEFT: //Wir stehen links, und es ist sauber, können nur nach rechts.
                        table.add(worldState + "; " + VacuumAction.Aecktion.RIGHT);
                        return VacuumAction.Aecktion.RIGHT;

                    case RIGHT: //Wir stehen rechts und es ist sauber, also nach links.
                        table.add(worldState + "; " + VacuumAction.Aecktion.LEFT);
                        return VacuumAction.Aecktion.LEFT;

                    case MIDDLE: //Wir stehen in der Mitte und es ist sauber, also nach links oder rechts?
                        if (myWorld.clean.get(VacuumWorld.world.LEFT) == false) { //links dreckig?
                            table.add(worldState + "; " + VacuumAction.Aecktion.LEFT);
                            return VacuumAction.Aecktion.LEFT;
                        } else if (myWorld.clean.get(VacuumWorld.world.RIGHT) == false) { //rechts dreckig?
                            table.add(worldState + "; " + VacuumAction.Aecktion.RIGHT);
                            return VacuumAction.Aecktion.RIGHT;
                        } else {
                            throw new RuntimeException("Hier geht gerade alles daneben, angeblich nicht alles sauber, aber doch alles sauber...");
                        }
                }
            }
        }

        throw new RuntimeException("sollte nicht erreichbar sein");
    }

}

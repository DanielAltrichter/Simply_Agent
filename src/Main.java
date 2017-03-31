import java.util.HashMap;

/**
 * Created by s-daltri on 31.03.17.
 */
public class Main {
    public static void main(String[] args) {

        printTable();
//
        /*compareAgents(false, false, false);
        compareAgents(true, false, false);
        compareAgents(false, true, false);
        compareAgents(false, false, true);
        compareAgents(true, true, false);
        compareAgents(true, false, true);
        compareAgents(true, false, true);
        compareAgents(true, true, true);*/
    }

    public static void printTableBinary() {
        runBinaryWorld(true, true, VacuumWorld.world.LEFT);
        runBinaryWorld(true, true, VacuumWorld.world.RIGHT);
        runBinaryWorld(true, false, VacuumWorld.world.LEFT);
        runBinaryWorld(true, false, VacuumWorld.world.RIGHT);
        runBinaryWorld(false, true, VacuumWorld.world.LEFT);
        runBinaryWorld(false, true, VacuumWorld.world.RIGHT);
        runBinaryWorld(false, false, VacuumWorld.world.LEFT);
        runBinaryWorld(false, false, VacuumWorld.world.RIGHT);

        System.out.println("\n\n\n");
        int i = 1;
        for (String s : VacuumReflexAgent.table) {
            System.out.println(i + "\t" + s);
            i++;
        }
    }

    public static void printTable() {
        runAgent(true, true, true, VacuumWorld.world.LEFT);
        runAgent(true, true, true, VacuumWorld.world.RIGHT);
        runAgent(true, true, true, VacuumWorld.world.MIDDLE);

        runAgent(true, false, true, VacuumWorld.world.LEFT);
        runAgent(false, true, true, VacuumWorld.world.LEFT);
        runAgent(true, true, false, VacuumWorld.world.LEFT);

        runAgent(true, false, true, VacuumWorld.world.MIDDLE);
        runAgent(false, true, true, VacuumWorld.world.MIDDLE);
        runAgent(true, true, false, VacuumWorld.world.MIDDLE);

        runAgent(true, false, true, VacuumWorld.world.RIGHT);
        runAgent(false, true, true, VacuumWorld.world.RIGHT);
        runAgent(true, true, false, VacuumWorld.world.RIGHT);

        runAgent(false, false, true, VacuumWorld.world.RIGHT);
        runAgent(false, true, false, VacuumWorld.world.RIGHT);
        runAgent(true, false, false, VacuumWorld.world.RIGHT);

        runAgent(false, false, true, VacuumWorld.world.MIDDLE);
        runAgent(false, true, false, VacuumWorld.world.MIDDLE);
        runAgent(true, false, false, VacuumWorld.world.MIDDLE);

        runAgent(false, false, true, VacuumWorld.world.LEFT);
        runAgent(false, true, false, VacuumWorld.world.LEFT);
        runAgent(true, false, false, VacuumWorld.world.LEFT);

        runAgent(false, false, false, VacuumWorld.world.RIGHT);
        runAgent(false, false, false, VacuumWorld.world.RIGHT);
        runAgent(false, false, false, VacuumWorld.world.RIGHT);

        runAgent(false, false, false, VacuumWorld.world.MIDDLE);
        runAgent(false, false, false, VacuumWorld.world.MIDDLE);
        runAgent(false, false, false, VacuumWorld.world.MIDDLE);

        runAgent(false, false, false, VacuumWorld.world.LEFT);
        runAgent(false, false, false, VacuumWorld.world.LEFT);
        runAgent(false, false, false, VacuumWorld.world.LEFT);

        System.out.println("\n\n\n");
        int i = 1;
        for (String s : VacuumReflexAgent.table) {
            System.out.println(i + "\t" + s);
            i++;
        }
    }

    public static void compareAgents(Boolean left, Boolean middle, Boolean right){
        System.out.println("Variante A:\n");
        VacuumReflexAgent.PERCEPTION_TYPE = 'a';
        int counterA = runAgent(left, middle, right, VacuumWorld.world.MIDDLE);

        System.out.println("\n\n----------------------------------------------------------------\n----------------------------------------------------------------\n\nVarianteB:\n");
        VacuumReflexAgent.PERCEPTION_TYPE = 'b';
        int counterB = runAgent(left, middle, right, VacuumWorld.world.MIDDLE);

        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nLeft: "
                        + left + ", middle: " + middle + ", right: " + right +
                "\n Ergebnis Variante A: " + counterA + "\n Ergebnis Variante B: " + counterB);
    }

    public static int runAgent(Boolean left, Boolean middle, Boolean right, VacuumWorld.world position) {
        VacuumAction.countActions = 0;

        HashMap<VacuumWorld.world, Boolean> clean = new HashMap<VacuumWorld.world, Boolean>();
        clean.put(VacuumWorld.world.LEFT, left);
        clean.put(VacuumWorld.world.MIDDLE, middle);
        clean.put(VacuumWorld.world.RIGHT, right);

        VacuumWorld world = new VacuumWorld(clean, position);
        VacuumPerception perception = VacuumPerception.createPerception(world);
        VacuumReflexAgent agent = new VacuumReflexAgent();

        world = VacuumAction.action(agent.agentFunction(perception), world);

        while (world != null) {
            perception = VacuumPerception.createPerception(world);
            world = VacuumAction.action(agent.agentFunction(perception), world);
        }

        return VacuumAction.countActions;
    }

    public static void runBinaryWorld(Boolean left, Boolean right, VacuumWorld.world position) {
        HashMap<VacuumWorld.world, Boolean> clean = new HashMap<VacuumWorld.world, Boolean>();
        clean.put(VacuumWorld.world.LEFT, left);
        clean.put(VacuumWorld.world.RIGHT, right);

        VacuumWorld.secondWorld = true;
        VacuumReflexAgent.PERCEPTION_TYPE = 'a';

        VacuumWorld world = new VacuumWorld(clean, position);
        VacuumPerception perception = VacuumPerception.createPerception(world);
        VacuumReflexAgent agent = new VacuumReflexAgent();

        world = VacuumAction.action(agent.agentFunction(perception), world);

        while (world != null) {
            perception = VacuumPerception.createPerception(world);
            world = VacuumAction.action(agent.agentFunction(perception), world);
        }

        VacuumWorld.secondWorld = false;
    }
}

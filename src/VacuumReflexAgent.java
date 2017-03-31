
/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumReflexAgent {

    public static final class PERCEPTION_TYPE = VacuumPercepitonA.class;

    public void run(VacuumWorld world) {

    }


    public VacuumAction.Aecktion agentFunction(VacuumPerception perception){
        if(perception.getClass().equals(VacuumPercepitonA.class)) {
            System.out.println("VacuumPerceptionA.");
            return agentFunction((VacuumPercepitonA) perception);
        }



        return new VacuumAction;
    }

    public VacuumAction.Aecktion agentFunction(VacuumPercepitonA percepiton) {
        System.out.println("Blub test");

        if (percepiton.world.clean.get(percepiton.position) == false) {//Das Feld auf dem wir stehen ist dreckig?
            return VacuumAction.Aecktion.CLEAN;
        }

    }

}


/**
 * Created by s-daltri on 28.03.17.
 */
public abstract class VacuumPerception {

    public static VacuumPerception createPerception(VacuumWorld world) {
        if (VacuumReflexAgent.PERCEPTION_TYPE == 'a') {
            return new VacuumPercepitonA(world.agentPosition, world);
        }

        else if(VacuumReflexAgent.PERCEPTION_TYPE == 'b') {
            // TODO: 31.03.17 Do it. Do it now. To the chopper
            return new VacuumPercepitonB(world.clean.get(world.agentPosition), world.agentPosition);
        }

        throw new IllegalArgumentException("Perception Type ist falsch gesetzt");
    }


}

package com.nathan.learn.base.grammar.enumerated;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by nathan on 17/6/17.
 */
public class EnumMapLearn {
    public enum Phase {
        SOLID, LIQUID, GAS;
        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID);

            private final Phase src;
            private final Phase dst;

            Transition(Phase src, Phase dst) {
                this.src = src;
                this.dst = dst;
            }

            private static final Map<Phase, Map<Phase, Transition>> m =
                    new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);
            static {
                for (Phase phase : Phase.values()) {
                    m.put(phase, new EnumMap<Phase, Transition>(Phase.class));
                }
                for (Transition transition : Transition.values()) {
                    m.get(transition.src).put(transition.dst, transition);
                }
            }

            public static Transition from(Phase src, Phase dst) {
                return m.get(src).get(dst);
            }
        }
    }
}

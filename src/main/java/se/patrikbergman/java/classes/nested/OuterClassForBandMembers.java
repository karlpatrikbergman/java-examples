package se.patrikbergman.java.classes.nested;

class OuterClassForBandMembers {

    final String instanceTourMemory;
    static final String STATIC_TOUR_MEMORY = "Static Tour Memory: I don't remember";

    OuterClassForBandMembers(String instanceTourMemory) {
        this.instanceTourMemory = instanceTourMemory;
    }

    String getInstanceTourMemory() {
        return instanceTourMemory;
    }

    /**
     * Nested classes that are declared static are called "static nested classes".
     * As with class methods and variables, a static nested class is associated with its outer class.
     * And like static class methods, a static nested class cannot refer directly to instance variables or
     * methods defined in its enclosing class: it can use them only through an object reference.
     */
    static final class StaticNestedClassBandMember {
        private final String name;

        public StaticNestedClassBandMember(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        /**
         * See StaticNestedClassBandMember description
         */
        public String getTourMemory() {
        //Compile error
        //return tourMemory;
          return STATIC_TOUR_MEMORY;
        }
    }

    /**
     * Non-static nested classes are called "inner classes"
     * Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they
     * are declared private (in this example TOUR_MEMORY)
     *
     * As with instance methods and variables, an inner class is associated with an instance of its enclosing class
     * and has direct access to that object's methods and fields.
     *
     * Also, because an inner class is associated with an instance, it cannot define any static members itself.
     *
     * Objects that are instances of an inner class exist within an instance of the outer class.
     *
     * An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods
     * and fields of its enclosing instance.
     *
     * To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within
     * the outer object with this syntax:
     * OuterClass.InnerClass innerObject = outerObject.new InnerClass();
     *
     */
    final class InnerClassBandMember {
        //Does not compile, "inner classes cannot have static declarations"
        //static String myString = "";

        private final String name;

        public InnerClassBandMember(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getTourMemory() {
            return getInstanceTourMemory();
        }
    }
}

/**
 * This is a turtle subclass
 *
 * Class: ICS4U1
 * Date: March 10 2022
 * @author Jessica Lu
 * @author James Wong
 */

public class Turtle extends Animal {
    /* attributes */

    /** whether the turtle is a pet or not */
    private boolean isPet;
    /** whether the turtle has a home or not */
    private boolean hasHome;

    /* constructors */

    /**
     Name: Turtle
     Description: creates a basic turtle
     @param name the name of the turtle
     @param breed the breed of the turtle
     @param colour the colour of the turtle
     @param age the age of the turtle
     @param weight the weight of the turtle in kg
     @param isTired whether the turtle is tired or not
     @param isColdBlooded whether the turtle is cold blooded or not
     */
    public Turtle(String name, String breed, String colour, int age, int energyLevel, double weight, boolean isTired, boolean isColdBlooded) {
        super(name, breed, colour, age, weight, energyLevel, isTired, isColdBlooded);
        this.isPet = false;
        this.hasHome = false;
    }

    /**
     Name: Turtle
     Description: creates a basic turtle
     @param name the name of the turtle
     @param breed the breed of the turtle
     @param colour the colour of the turtle
     @param age the age of the turtle
     @param weight the weight of the turtle in kg
     @param isPet whether the turtle is a pet or not
     @param isTired whether the turtle is tired or not
     @param hasHome whether the turtle has a home or not
     @param isColdBlooded whether the turtle is cold blooded or not
     */
    public Turtle(String name, String breed, String colour, int age, int energyLevel, double weight, boolean isPet, boolean isTired, boolean hasHome, boolean isColdBlooded) {
        super(name, breed, colour, age, weight, energyLevel, isTired, isColdBlooded);

        this.isPet = isPet;

        // can only have a home if they are not a pet
        if (!isPet) {
            this.hasHome = hasHome;
        } else {
            this.hasHome = false;
        }
    }

    /* accessors */

    /**
     Name: getIsPet
     Description: return whether the turtle is a pet or not
     @return whether the turtle is a pet or not
     */
    public boolean getIsPet() {
        return this.isPet;
    }

    /**
     Name: getHasHome
     Description: return whether the turtle has a home or not
     @return whether the turtle has a home or not
     */
    public boolean getHasHome() {
        return this.hasHome;
    }

    /* mutators */

    /**
     Name: setIsPet
     Description: set if the turtle is a pet or not
     @param newIsPet if the turtle is now a pet or not
     */
    public void setIsPet(boolean newIsPet) {
        this.isPet = newIsPet;

        // if they become a pet then their outside home is destroyed and gone
        if (this.hasHome) {
            this.hasHome = false;
        }
    }

    /**
     Name: setHasHome
     Description: set if the turtle has a home or not
     @param newHasHome if the turtle has a home or not
     */
    public void setHasHome(boolean newHasHome) {
        this.hasHome = newHasHome;
    }

    /* other methods */

    @Override
    /**
     Name: run
     Description: turtle runs and loses energy. for each 40 metres = -1% energy (not multiplied, added)
     @param metres the distance ran in metres
     */
    public void run(int metres) {
        final int METRES_TO_ENERGY = 40; // 40 metres = -1%

        int energyUsed = metres / METRES_TO_ENERGY; // how much energy needed to run that distance (may exceed turtle's energy level)

        if (energyUsed > getEnergyLevel()) { // only runs if they have enough energy
            System.out.println(getName() + " doesn't have enough energy to run this far. (Try sleeping!)");
        } else if (metres > 0) { // only run if the distance is positive (it actually exists)
            super.setEnergyLevel(getEnergyLevel() - metres / METRES_TO_ENERGY);

            System.out.println(getName() + " went on a run. They ran for " + metres + "m and lost some energy.");
            System.out.println("They now have an energy level of " + getEnergyLevel() + "%.");
        }
    }

    /**
     Name: swim
     Description: turtle swims and loses energy. for each 80 metres = -1% energy (not multiplied, added)
     @param metres the distance swam in metres
     */
    public void swim(int metres) {
        final int METRES_TO_ENERGY = 80; // 80 metres = -1%

        int energyUsed = metres / METRES_TO_ENERGY; // how much energy needed to run that distance (may exceed turtle's energy level)

        if (energyUsed > getEnergyLevel()) { // only swims if they have enough energy
            System.out.println(getName() + " doesn't have enough energy to swim this far. (Try sleeping!)");
        } else if (metres > 0) { // only swim if the distance is positive (it actually exists)
            super.setEnergyLevel(getEnergyLevel() - metres / METRES_TO_ENERGY);

            System.out.println(getName() + " went on a swim. They ran for " + metres + "m and lost some energy.");
            System.out.println("They now have an energy level of " + getEnergyLevel() + "%.");
        }
    }

    @Override
    /**
     Name: eat
     Description: turtle eats food and gains energy level. for each 50 grams = + 1% energy (not multiplied, added)
     @param grams the amount of food eaten in grams
     */
    public void eat(double grams) {
        final int GRAMS_TO_ENERGY = 50; // 50 grams = 1%
        if (grams > 0) { // only if the weight is positive (it actually exists)
            super.setEnergyLevel(getEnergyLevel() + (int)(grams / GRAMS_TO_ENERGY)); // old energy + gained energy
            super.setWeight(getWeight() + grams); // gain weight
        }

        // if energy is more than 100%, bring down to 100% (max)
        if (getEnergyLevel() > 100) {
            super.setEnergyLevel(100);
        }
    }

    /**
     Name: buildHome
     Description: if the turtle is not a pet, it builds a home that it can sleep in
     */
    public void buildHome() {
        if (!this.isPet) { // if they're not a pet
            if (!this.hasHome) { // if they don't have a home
                this.hasHome = true;
                super.setIsTired(true);
                super.setEnergyLevel(0);
                System.out.println(getName() + " built a home. They are now exhausted.");
            } else { // they already have a home
                System.out.println(getName() + " already has a home! (They' can't build another one).");
            }
        } else { // they are a pet
            System.out.println(getName() + " can't build a home because they are a pet and their owner already has something for them!");
        }
    }

    /**
     Name: sleep
     Description: if the turtle has a home or is a pet, they go to sleep and get 100% energy level
     */
    public void sleep() {
        if (this.hasHome || this.isPet) {
            System.out.println(getName() + " went to sleep. They're rejuvenated and happy now! :)");
            super.setEnergyLevel(100);
            System.out.println("They also got all their energy back. They now have an energy level of " + getEnergyLevel() + "%.");
            setIsTired(false); // no longer tired
        } else {
            System.out.println(getName() + " has nowhere to sleep! (Try build them a home first).");
        }
    }

    @Override
    /**
     Name: toString
     Description: returns all turtle attributes
     @return all turtle attributes
     */
    public String toString() {
        String attributes;

        attributes = super.toString() +  "\nIs a pet: " + this.isPet + "\nHas a home: " + this.hasHome;

        return attributes;
    }
}
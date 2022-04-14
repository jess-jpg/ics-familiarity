/**
 * This is a dog class
 *
 * Class: ICS4U1
 * Date: March 03 2022
 * @author James Wong
 * @author Jessica Lu
 */

public class Dog extends Animal {

    /*
    Attributes
    */

    /* Is the dog Hypoallergenic or not */
    private boolean isHypoallergenic;

  /*
  Constructor
  */

    /**
     Name: Dog
     Description: creates a basic dog
     @param name the name of the dog
     @param colour the colour of the dog
     @param age the age of the dog
     @param weight the weight of the dog in kg
     @param energyLevel the energy level of the dog 0-100
     @param isTired whether the dog is tired or not
     @param isHypoallergenic whether the dog is hypoallergenic or not
     */
    public Dog(String name, String breed, String colour, int age, double weight, int energyLevel, boolean isTired, boolean isHypoallergenic, boolean isColdBlooded) {

        // calling from the super class
        super(name, breed, colour, age, weight, energyLevel, isTired, isColdBlooded);

        // declaring isHypoallergenic
        this.isHypoallergenic = isHypoallergenic;
    }

  /*
  Method
  */

    /**
     Name: getHypoallergenic
     Description: return whether the dog is hypoallergenic or not
     */
    public boolean getIsHypoallergenic() {return this.isHypoallergenic;}

  /*
  Mutators
  */

    /**
     Name: play
     Description: Dog plays and loses weight and energy
     For every minute of play, the dog gains weight of the time divide by 10
     For every minute of play, the dog's energy level is the time divided by 10 as a percentage of the original energy level subtracted from the energy level
     @param time the minutes the dog spent playing
     */
    public void play(int time) {

        if (getIsTired()) {        // if the dog is tired, the dog won't have enough energy to play
            System.out.println(getName() + " is too tired to play");
        } else {            // if the dog has enough energy, the dog can play

            setWeight(getWeight() - time / 10);         // the dog gains weight of the time divide by 10

            setEnergyLevel(getEnergyLevel() - (int) (0.01 * (time / 10)) * getEnergyLevel());    // the dog's energy level is the time divided by 10 as a percentage of the original energy level subtracted from the energy level

            // keep the energy level within 0-100
            if (getEnergyLevel() > 100) {          // if the energy level is greater than 100
                setEnergyLevel(100);
            } else if (getEnergyLevel() < 0) {    // if the energy level is less than 0
                setEnergyLevel(0);
            }

            // if the dog plays for over 100 minutes, then the dog will be tired
            if (time > 100) {
                setIsTired(true);
            } else {
                setIsTired(false);    // if the dog plays for less than 100 minutes, then the dog will not be tired
            }
            System.out.println(getName() + " is not tired to play and has a play time of " + time + " minutes");
            System.out.println(getName() + " has a new energy level of " + getEnergyLevel() + "% has a new weight of " + getWeight() + "kg");
        }
    }

    /**
     Name: run
     Description: Dog runs and loses energy.
     For each 50 metres = -1% energy (not multiplied, added)
     @param metres the distance ran in metres
     */
    public void run(int metres){
        if (getEnergyLevel() < 50) {
            System.out.print(getName() + " doesn't have enough energy to run this far. (Try sleeping!)");
        } else if (metres > 0) {
            super.setEnergyLevel(getEnergyLevel() - metres/50);

            System.out.println(getName() + " went on a run. They ran for " + metres + "m and lost some energy.");
            System.out.println("They now have an energy level of " + getEnergyLevel() + "%.");
        }
    }

    /**
     * Name: eat
     * Description: Dog eats and gains energy and weight
     For every gram of food, the dog's weight is the grams plus 10 added to the original weight
     For every gram of food, the dog's energy level is the grams divide by 10 as a percentage of the original energy level added to the energy level
     * @param grams
     */
    public void eat(double grams){

        setWeight(getWeight() + grams / 10);          // the dog's weight is the grams plus 10 added to the original weight

        setWeight(getEnergyLevel() + (int) (0.01 * (grams / 10)) * getEnergyLevel());    // the energy level is the grams divide by 10 as a percentage of the original energy level added to the energy level

        // keep the energy level within 0-100
        if (getEnergyLevel() > 100) {          // if the energy level is greater than 100
            setEnergyLevel(100);
        } else if (getEnergyLevel() < 0) {    // if the energy level is less than 0
            setEnergyLevel(0);
        }

        System.out.println(getName() + " ate food which weighted " + grams + "kg");
        System.out.println(getName() + " has a new energy level of " + getEnergyLevel() + "% and has a new weight of " + getWeight() + "kg");
    }

    /**
     Name: sleep
     Description: Dog sleeps and gains energy
     If the dog is tired then it goes to sleep
     If the dog sleeps for more than 60 minutes, it will no longer be tired and will have an energy level of 100
     If the dog sleeps for less than 60 minutes, add 25 to the original energy level
     @param sleep the minutes the dog spent sleeping
     */
    public void sleep (int sleep) {
        if (getIsTired()) {
            if (sleep > 60) {
                setIsTired(false);

                setEnergyLevel(100);

                System.out.println(getName() + "fell asleep and woke up with a replenishing energy level of 100%");

            } else if (sleep < 60 && sleep > 0) {
                setEnergyLevel(getEnergyLevel() + 25) ;
                // keep the energy level within 0-100
                if (getEnergyLevel() > 100) {          // if the energy level is greater than 100
                    setEnergyLevel(100);
                } else if (getEnergyLevel() < 0) {                      //  if energy level is less than 0
                    setEnergyLevel(0);
                }
                System.out.println(getName() + " fell asleep and woke up with a new energy level of " + getEnergyLevel());
            }
        } else {
            System.out.println(getName() + " is not tired enough to sleep");
        }

    }
    /**
     Name: birthday
     Description: the dog gets one year older!
     */
    public void birthday() {
        setAge(getAge() + 1);
        System.out.println("It's " + getName() + "'s birthday! " + getName() + " is now " + getAge() + " years old.");
    }

    /**
     Name: toString
     Description: returns all dog attributes
     @return all turtle attributes
     */
    public String toString() {

        // String name, String colour, int age, double weight, int energyLevel, boolean isTired, boolean isHypoallergenic
        return "Name: " + getName() + "\nColour: " + getColour() + "\nAge: " + getAge() + "\nWeight: " + getWeight() + "kg\nEnergy Level: " + getEnergyLevel() + "%\nIs tired: " + getIsTired() + "\nIs Hypoallergenic: " + this.isHypoallergenic;
    }
}
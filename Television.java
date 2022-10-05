//Used with TelevisionDemo
// The purpose of this class is to model a television
// Dan Imbimbo 11/12/17 

public class Television {
    private String MANUFACTURER;
    private int SCREEN_SIZE;
    private boolean powerOn;
    private int channel;
    private int volume;
    
    /**
     * Constructor for Television class, initializes values for all instance fields
     * @param brand String value used for MANUFACTURER field
     * @param size  int value used for SCREEN_SIZE field
     */
    public Television(String brand, int size){
        MANUFACTURER = brand;
        SCREEN_SIZE = size;
        powerOn = false;
        volume = 20;
        channel = 2;
    }
    /**
     * Accessor method for volume field
     * @return value of volume field
     */
    public int getVolume(){
        return volume;
    }
    /**
     * Accessor method for channel field
     * @return value of channel field
     */
    public int getChannel(){
        return channel;
    }
    /**
     * Accessor method for MANUFACTURER field
     * @return value of MANUFACTURER field
     */
    public String getManufacturer(){
        return MANUFACTURER;
    }
    /**
     * Accessor method for SCREEN_SIZE field
     * @return value of SCREEN_SIZE field
     */
    public int getScreenSize(){
        return SCREEN_SIZE;
    }
    /**
     * Mutator method for channel field
     * @param chan int value used for channel field
     */
    public void setChannel(int chan){
        channel = chan;
    }
    /**
     * Mutator method for powerOn field (sets to opposite of current boolean value)
     */
    public void power(){
        powerOn = !powerOn;
    }
    /**
     * Mutator method for volume field (increments volume by 1)
     */
    public void increaseVolume(){
        volume++;
    }
    /**
     * Mutator method for volume field (decrements volume by 1)
     */
    public void decreaseVolume(){
        volume--;
    }
}


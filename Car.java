
package lab1;
import java.awt.*;

public abstract class Car implements Movable {

    private final int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public final String modelName; // The car model name
    public double xPos;
    public double yPos;
    public String direction = "North";

    public Car(int nrDoors, double enginePower, Color color, String modelName) {

       this.nrDoors = nrDoors;
       this.enginePower = enginePower;
       this.color = color;
       this.modelName = modelName;
       stopEngine();


    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount <= 1 && amount >= 0){
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount <= 1 && amount >= 0){
            decrementSpeed(amount);
        }
    }

    public void move(){
        switch (direction){
            case "North":
                yPos += currentSpeed;
                break;
            case "East":
                xPos += currentSpeed;
                break;
            case "South":
                yPos -= currentSpeed;
                break;
            case "West":
                xPos -= currentSpeed;
                break;
        }
    }

    public void turnRight(){
        switch (direction){
            case "North":
                direction = "East";
                break;
            case "East":
                direction = "South";
                break;
            case "South":
                direction = "West";
                break;
            case "West":
                direction = "North";
                break;
        }
    }

    public void turnLeft(){
        switch (direction){
            case "North":
                direction = "West";
                break;
            case "East":
                direction = "North";
                break;
            case "South":
                direction = "East";
                break;
            case "West":
                direction = "South";
                break;
        }
    }

}

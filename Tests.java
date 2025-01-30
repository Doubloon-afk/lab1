package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

import java.awt.*;

// storing subclass objects
public class Tests {
    Volvo240 Volvo = new Volvo240();
    Saab95 Saab = new Saab95();

// Testing method getNrDoors with the cars predetermined amount of doors
    @Test
    void TestDoors() {
        assertEquals(2, Saab.getNrDoors());
        assertEquals(4, Volvo.getNrDoors());
    }
// Testing method getEnginePower with the cars predetermined engine power
    @Test
    void TestEngine() {
        assertEquals(125, Saab.getEnginePower());
        assertEquals(100, Volvo.getEnginePower());
    }
// Testing method getColor with the cars predetermined Color
    @Test
    void TestColor() {
        assertEquals(Color.red, Saab.getColor());
        assertEquals(Color.black, Volvo.getColor());

        Saab.setColor(Color.green);
        Volvo.setColor(Color.blue);

        assertEquals(Color.green, Saab.getColor());
        assertEquals(Color.blue, Volvo.getColor());
    }

    // Testing if the cars model is being stored in its variable
    @Test
    void TestModelName() {
        assertEquals("Saab95", Saab.modelName);
        assertEquals("Volvo240", Volvo.modelName);
    }
    // Testing the cars current speed if its being stored correctly
    @Test
    void TestEngineState() {
        assertEquals(0, Saab.getCurrentSpeed());
        assertEquals(0, Volvo.getCurrentSpeed());

        Saab.startEngine();
        Volvo.startEngine();

        assertEquals(0.1,  Saab.getCurrentSpeed());
        assertEquals(0.1, Volvo.getCurrentSpeed());

        Saab.stopEngine();
        Volvo.stopEngine();

        assertEquals(0, Saab.getCurrentSpeed());
        assertEquals(0, Volvo.getCurrentSpeed());

    }
// Testing the Saabs speed factor by calculating its value and then running the method
    @Test
    void TestSpeedFactorSaab() {
        assertEquals(1.25, Saab.speedFactor());

        Saab.setTurboOn();
        assertEquals(1.625, Saab.speedFactor());

        Saab.setTurboOff();
        assertEquals(1.25, Saab.speedFactor());

    }
// Testing the Volvos speed factor by calculating its value and then running the method
    @Test
    void TestSpeedFactorVolvo() {
        assertEquals(1.25, Volvo.speedFactor());
    }

// Testing if the car is turning to the right direction if we're calling turnleft() and turnright methods
    @Test
    void TestTurning() {
        Saab.turnLeft();
        Volvo.turnLeft();
        assertEquals("West", Saab.direction);
        assertEquals("West", Volvo.direction);

        Saab.turnRight();
        Saab.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        assertEquals("East", Saab.direction);
        assertEquals("East", Volvo.direction);

    }
// testing the move method to see if the cars x and y position values are being adjusted correctly
    @Test
    void TestMove() {
        Saab.startEngine();
        Volvo.startEngine();
        Saab.move();
        Volvo.move();
        assertEquals(0.1,Saab.yPos );
        assertEquals(0.1,Volvo.yPos);

        Saab.turnLeft();
        Volvo.turnRight();
        Saab.move();
        Volvo.move();
        assertEquals(-0.1,Saab.xPos );
        assertEquals(0.1,Volvo.xPos);

        Volvo.turnLeft();
        Volvo.turnLeft();
        Volvo.move();
        assertEquals(0,Volvo.xPos);

    }

// Testing the gas method to see if the cars can increase its speed without exceeding its enginepower
    @Test
    void TestGas() {
        Volvo.gas(1);
        Volvo.gas(-1);
        Saab.setTurboOn();
        Saab.gas(1);
        Saab.gas(-1);
        assertEquals(1.25, Volvo.currentSpeed);
        assertEquals(1.625, Saab.currentSpeed);

        Volvo.currentSpeed = 99;
        Saab.currentSpeed = 124;
        Volvo.gas(1);
        Saab.gas(1);
        assertEquals(100, Volvo.currentSpeed);
        assertEquals(125, Saab.currentSpeed);
    }

//testing the brake method to see if cars current speed doesn't go below 0
    @Test
    void TestBrake() {
        Volvo.brake(1);
        Saab.brake(1);
        assertEquals(0, Volvo.currentSpeed);
        assertEquals(0, Saab.currentSpeed);

        Volvo.currentSpeed = 100;
        Saab.currentSpeed = 125;
        Volvo.brake(1);
        Saab.brake(1);
        assertEquals(98.75, Volvo.currentSpeed);
        assertEquals(123.75, Saab.currentSpeed);
    }
}

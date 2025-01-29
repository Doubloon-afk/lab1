package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class Tests {
    Volvo240 Volvo = new Volvo240();
    Saab95 Saab = new Saab95();


    @Test
    void TestDoors() {
        assertEquals(2, Saab.getNrDoors());
        assertEquals(4, Volvo.getNrDoors());
    }

    @Test
    void TestEngine() {
        assertEquals(125, Saab.getEnginePower());
        assertEquals(100, Volvo.getEnginePower());
    }

    @Test
    void TestColor() {
        assertEquals(Color.red, Saab.getColor());
        assertEquals(Color.black, Volvo.getColor());

        Saab.setColor(Color.green);
        Volvo.setColor(Color.blue);

        assertEquals(Color.green, Saab.getColor());
        assertEquals(Color.blue, Volvo.getColor());
    }

    @Test
    void TestModelName() {
        assertEquals("Saab95", Saab.modelName);
        assertEquals("Volvo240", Volvo.modelName);
    }

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

    @Test
    void TestSpeedFactorSaab() {
        assertEquals(1.25, Saab.speedFactor());

        Saab.setTurboOn();
        assertEquals(1.625, Saab.speedFactor());

        Saab.setTurboOff();
        assertEquals(1.25, Saab.speedFactor());

    }

    @Test
    void TestSpeedFactorVolvo() {
        assertEquals(1.25, Volvo.speedFactor());
    }

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

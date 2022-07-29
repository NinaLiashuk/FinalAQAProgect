package com.pattern.behaviour;

public class BowAndArrowBehaviour implements WeaponBehaviour{

    @Override
    public void useWeapon() {
        System.out.println("выстрел стрелы");
    }
}

package com.pattern.behaviour;

public class KnifeBehaviour implements WeaponBehaviour, TypeWeapon {

    @Override
    public void useWeapon() {
        System.out.println("удар ножом");
    }

    @Override
    public String getType() {
        return null;
    }
}

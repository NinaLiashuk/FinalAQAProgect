package com.pattern.behaviour;

public abstract class Character{

    private TypeWeapon typeWeapon;
    void fight(TypeWeapon typeWeapon){
        System.out.println(typeWeapon);
    }
}

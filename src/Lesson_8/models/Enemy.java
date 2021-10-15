package Lesson_8.models;


import Lesson_8.Tools;

public class Enemy {

    private int health;
    private int power;
    private int enemyValueMin = 30;
    private int enemyValueMax = 60;

    private int x;
    private int y;

    private int countEnemies;

    public Enemy(int count) {
        this.health = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.power = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.countEnemies = count;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void decreaseHealth(int value) {
        health -= value;
    }

    public void killEnemy() {
        --countEnemies;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isExistEnemies() {
        return countEnemies > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getCountEnemies() {
        return countEnemies;
    }
}

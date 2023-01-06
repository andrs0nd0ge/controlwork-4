package entity;

import java.util.Random;

public class Cat {
    private String name;
    private Integer age;
    private Integer satietyLevel;
    private Integer moodLevel;
    private Integer healthLevel;
    private Integer average;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
        satietyLevel = new Random().nextInt(81) + 20;
        moodLevel = new Random().nextInt(81) + 20;
        healthLevel = new Random().nextInt(81) + 20;
        average = average(healthLevel, moodLevel, satietyLevel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSatietyLevel() {
        return satietyLevel;
    }

    public void setSatietyLevel(Integer satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public Integer getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(Integer moodLevel) {
        this.moodLevel = moodLevel;
    }

    public Integer getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(Integer healthLevel) {
        this.healthLevel = healthLevel;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public static int average(Integer health, Integer mood, Integer satiety) {
        return (health + mood + satiety) / 3;
    }

    @Override
    public String toString() {
        return String.format("%10s |%6s   |%5s   |%5s   |%6s   |", name, age, healthLevel, moodLevel, satietyLevel);
    }
}

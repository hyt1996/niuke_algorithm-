package com.hyt.chap4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description： 猫狗队列问题 设计问题
 * Author: yitao huang
 * Date: Created in 2020/1/6 21:40
 */
public class DogCatQueue {

    private Queue<PetEnter> dogQueue;
    private Queue<PetEnter> catQueue;
    private long count;


    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
           count = 0;
    }

    public void add(Pet pet){
        String petType = pet.getPetType();
        if ("dog".equalsIgnoreCase(petType)){
            //dogQueue.add(new)
            PetEnter petEnter = new PetEnter(pet,++count);
            dogQueue.add(petEnter);
        }else if ("cat".equalsIgnoreCase(petType)){
            PetEnter petEnter = new PetEnter(pet,++count);
            catQueue.add(petEnter);
        }else {
            throw new RuntimeException("the type is undifiend");
        }
    }

    public Pet poll(){
        if(!isDogEmpty() && !isCatEmpty()){
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()){
                return dogQueue.poll().getPet();
            }else {
                return catQueue.poll().getPet();
            }
        }else if (isDogEmpty()){
            return catQueue.poll().getPet();
        }else if (isCatEmpty()){
            return dogQueue.poll().getPet();
        }else {
            throw new RuntimeException("err the queue is empty");
        }
    }

    public Dog pollDog(){
        if (!isDogEmpty()){
            return (Dog) dogQueue.poll().getPet();
        }
        throw new RuntimeException("err the dogqueue is empty");
    }

    public Cat pollCat(){
        if (!isCatEmpty()){
            return (Cat) catQueue.poll().getPet();
        }
        throw new RuntimeException("err the catqueue is empty");
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return  catQueue.isEmpty();
    }

    public boolean isEmpty() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()){
            return true;
        }
        return false;
    }
}


//宠物
class Pet{
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet{
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet{
    public Cat() {
        super("cat");
    }
}

/**
 * 存入队列中宠物
 */
class PetEnter{
    private Pet pet;
    private long count;

    public PetEnter(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }


    public long getCount() {
        return count;
    }

    public String getPetType(){
        return pet.getPetType();
    }
}
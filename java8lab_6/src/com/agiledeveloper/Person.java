package com.agiledeveloper;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {

    private final String firstName;
    private final String lastName;
    private List<Person> friends = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    public List<String> followFriends(BinaryOperator<String> theFunction) {
        return friends.stream()
                .map(x-> theFunction.apply(x.firstName,x.lastName))
                .collect(Collectors.toList());
    }

    public List<String> followFriends(Function<Person,String> theFunction){
//        ArrayList<String> result = new ArrayList<>();
//
//        for (Person friend : friends) {
//            result.add(theFunction.apply(friend));
//        }
//
//        return result;

        return friends.stream()
                .map(x-> theFunction.apply(x))
                .collect(Collectors.toList());
    }

    public void iterateFriends(BiConsumer<String,String> theFunction){
        friends.forEach(x -> theFunction.accept(x.firstName, x.lastName));
    }

}

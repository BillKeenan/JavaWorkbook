package com.agiledeveloper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import java.util.*;
import java.util.concurrent.CompletableFuture;

//Start with one test at a time. Uncomment only one test or one assert at a time.
//Run the test, see it fail. Then write minimum code to make that test or assert to pass.
//Once the test passes, move on to the next test/assert.

//import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
class PersonTest { 
  Person person;

  @BeforeEach
   void init() {
     person = new Person("Christopher", "Johnson");
   }
   
  @Test
  void personSHouldHaveAFirstAndLastName() {
    assertAll(
      () -> assertTrue(true)
      , () -> assertEquals("Christopher", person.getFirstName())
      , () -> assertEquals("Johnson", person.getLastName())
    );
  }
  
  @Test
  void aNewPersonHasNoFriends() {
    assertEquals(0,  person.getFriends().size());
  }
  
  @Test
  void afterAddFriendAPersonShouldHaveOneFriend() {
     person.addFriend(new Person("John", "Smith"));
     assertEquals(1,  person.getFriends().size());
  }
                
  @Test
  void afterTwoAddFriendsPersonShouldHaveTwoFriends() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));
     assertEquals(2,  person.getFriends().size());
  }
  
  @Test
  void followFriendsShouldReturnFirstNamesCollected() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));
    
//    Hint: Implement followFriends using imperative style first.
//    Then change it to functional style
  
     List<String> firstNames = person.followFriends(person -> person.getFirstName());

     assertEquals("John", firstNames.get(0));
     assertEquals("Sara", firstNames.get(1));
  }
  
  @Test
  void followFriendsShouldWorkWellWithMethodRef() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));

     List<String> firstNames = person.followFriends(Person::getFirstName);

     assertEquals("John", firstNames.get(0));
     assertEquals("Sara", firstNames.get(1));
  }
  
  @Test
  void followFriendsShouldReturnLastNamesCollected() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));

     List<String> lastNames = person.followFriends(person -> person.getLastName());

     assertEquals("Smith", lastNames.get(0));
     assertEquals("Smith", lastNames.get(1));
  }
  
  @Test
  void followFriendsShouldReturnFullNameCollected() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));

     List<String> fullNames = person.followFriends((first, last) -> first + last);

     assertEquals("JohnSmith", fullNames.get(0));
     assertEquals("SaraSmith", fullNames.get(1));
  }
  
  @Test
  void followFriendsShouldReturnFullNameInUpperCaseCollected() {
     person.addFriend(new Person("John", "Smith"));
     person.addFriend(new Person("Sara", "Smith"));

     List<String> fullNames = person.followFriends((first, last) -> first.toUpperCase() + last.toUpperCase());

     assertEquals("JOHNSMITH", fullNames.get(0));
     assertEquals("SARASMITH", fullNames.get(1));
  }
  
  @Test
  void iterateFriendsShouldProvideFirstAndLastName() {
     person.addFriend(new Person("John", "Smith"));
     CompletableFuture<Boolean> done = new CompletableFuture<>();

     person.iterateFriends((first, last) -> {
       assertEquals("John", first);
       assertEquals("Smith", last);
       done.complete(true);
     });

     assertTrue(done.getNow(false));
  }
}
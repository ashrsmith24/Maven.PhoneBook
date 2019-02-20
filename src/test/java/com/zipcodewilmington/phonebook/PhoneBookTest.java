package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneBookTest {

    private PhoneBook testPhoneBook;

    @Before
    public void setup(){
     testPhoneBook = new PhoneBook();
    }

//    @Test
//    public void hasEntryTest() {
//        //given
//        String fullName = "Ashley Smith";
//        Boolean hasEntryTest = true;
//        //when
//        testPhoneBook.add("Ashley Smith", "");
//        Boolean actual = PhoneBook.hasEntry("Ashley Smith");
//
//        //then
//        Assert.assertEquals(hasEntryTest, actual);
//    }

     @Test
    public void addTest(){
        //Given - i created a new instance of the class PhoneBook
        PhoneBook phoneBook = new PhoneBook();
        Integer expected = 1;

         //When
        phoneBook.add("Ashley","646-884-2468");

         //Then
        Integer actual = phoneBook.size();
        Assert.assertEquals(expected,actual);
//
//    @Test
//    public void addEntryTest(){
//        //given
//        String fullName =  "Ashley Smith";
//        String number = "646-884-2468";
//        testPhoneBook.add(fullName, number);
//        //when
//        Arraylist<String> contacts = testPhoneBook.getPhoneBook();
//        //then
//        assertTrue(contacts.contains(fullName));

    }
    @Test
    public void removeTest(){
            //Given
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.add("Ashley Smith","646-884-2468");
            Integer expected = 0;

            //When i remove the name from the phone book
            phoneBook.remove("Ashley Smith");

            //Then
            Integer actual = phoneBook.size();
            Assert.assertEquals(expected,actual);
        }


        @Test
        public void loopUpTest(){
            //Given
            PhoneBook phoneBook = new PhoneBook();
            String expected = "646-884-0720";
            String name = "Ashley";
            phoneBook.add(name, expected);


            //when the method returns, store the result into a variable actual
            String actual = phoneBook.lookUp(name);

            //Then
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void reverseLoopUpTest() {
            //Given
            PhoneBook phoneBook = new PhoneBook();
            String expected = "Ashley";
            String phoneNumber = "646-884-0720";
            phoneBook.add(expected,phoneNumber);

            //When
            String actual = phoneBook.reverseLookUp(phoneNumber);

            //Then
            Assert.assertEquals(expected, actual);

        }
        @Test
        public void displayTest(){
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.add("Ashley", "646-884-2468");
            phoneBook.add("Ajah", "646-884-0204");

            //When
            String actual = phoneBook.display();
            String expected = "Ashley 646-884-2468\n" +
                    "Ajah 646-884-0204\n";
            //Then
            Assert.assertEquals(expected,actual);



        }


    }



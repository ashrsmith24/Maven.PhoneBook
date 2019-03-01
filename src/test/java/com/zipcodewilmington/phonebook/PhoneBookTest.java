package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhoneBookTest {

    private PhoneBook testPhoneBook;
    @Test
    public void addTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Ashley";
        String phonenumber = "6468840246";
        String phonenumber2 = "6468840248";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(phonenumber);

        // When
        phonebook.add(name, phonenumber);
        ArrayList<String> actual = map.get(name);

        // Then
        Assert.assertEquals(phonenumber, map.get(name).get(0));
        Assert.assertEquals(expected, actual);
        Assert.assertNull(map.get("notakey"));

        // When
        phonebook.add(name, phonenumber2);
        expected.add(phonenumber2);

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(phonenumber2, map.get(name).get(1));
    }

    @Test
    public void removeTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Ashley";
        String phonenumber = "6468840246";
        String phonenumber2 = "6468840248";
        phonebook.add(name, phonenumber);
        phonebook.add(name, phonenumber2);

        // When
        phonebook.remove(name, phonenumber);

        // Then
        Assert.assertEquals(phonenumber2, map.get(name).get(0));

        // When
        phonebook.remove(name, phonenumber2);

        // Then
        Assert.assertNull(map.get(name));
        Assert.assertEquals(0, map.size());

    }

    @Test
    public void lookupTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Ashley";
        String phonenumber = "6468840246";
        phonebook.add(name, phonenumber);

        // When
        ArrayList<String> actual = phonebook.lookup(name);

        // Then
        Assert.assertEquals(phonenumber, actual.get(0));
    }

    @Test
    public void reverseLookupTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Ashley";
        String phonenumber = "6468840246";
        String phonenumber2 = "6468840248";
        phonebook.add(name, phonenumber);
        phonebook.add(name, phonenumber2);

        // When
        String actual = phonebook.reverseLookup(phonenumber);
        String actual2 = phonebook.reverseLookup(phonenumber2);

        // Then
        Assert.assertEquals(name, actual);
        Assert.assertEquals(name, actual2);
        Assert.assertNull(phonebook.reverseLookup("itsnotaphonenumer"));
    }

    @Test
    public void removeRecordTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Ashley";
        String phonenumber = "6468840246";
        phonebook.add(name, phonenumber);

        // When
        phonebook.removeRecord(name);

        // Then
        Assert.assertNull(map.get(name));
        Assert.assertEquals(0, map.size());

    }

    }



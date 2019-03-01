package com.zipcodewilmington.phonebook;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**	/**
 * Created by leon on 1/23/18.	 * Created by leon on 1/23/18.
 */

public class PhoneBook {


    private TreeMap<String, ArrayList<String>> phonebookMap;


    public PhoneBook(){
        this.phonebookMap = new TreeMap<String, ArrayList<String>>();
    }

    public TreeMap<String, ArrayList<String>> getPhonebookMap() {
        return phonebookMap;
    }

    // next adds an entry to the composite associate data type
    public void add(String name, String phoneNumber){
        if (phonebookMap.containsKey(name)){
            phonebookMap.get(name).add(phoneNumber);
        }
        else {
            ArrayList<String> numbers = new ArrayList<String>();
            numbers.add(phoneNumber);
            phonebookMap.put(name, numbers);
        }
    }

    // remove the entry to the composite associate data type
    public void remove(String name, String phoneNumber){
        try{
            if (phonebookMap.get(name).size() == 1){
                this.removeRecord(name);
            }
            else {
                phonebookMap.get(name).remove(phoneNumber);
            }
        }
        catch(NullPointerException e){
            System.out.println("Entry does not exist in this Phonebook");
        }
    }

    // i have to return the phone number for the respective input name
    public ArrayList<String> lookup(String name){
        return phonebookMap.get(name);
    }

    // i have to return the name for the respective input phoneNumber
    public String reverseLookup(String phoneNumber){
        for (Map.Entry<String, ArrayList<String>> entry : phonebookMap.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    // print a human-readable list of all entries
    // names and numbers(phone) in order.
    public void display(){
        for (Map.Entry<String, ArrayList<String>> entry : phonebookMap.entrySet()){
            System.out.println(entry.getKey() + ": ");
            for (String number : entry.getValue()){
                System.out.println(number);
            }
        }
    }

    // i have to removeRecord method for
    // removing an entire entry from your PhoneBook.
    public void removeRecord(String name){
        phonebookMap.remove(name);
    }




    }













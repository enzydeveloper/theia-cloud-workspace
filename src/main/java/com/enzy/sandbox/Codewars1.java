package com.enzy.sandbox;

import java.util.Stack;
import java.lang.Character;

public class Codewars1 {
    public static void main(String[] args) 
    {
        //System.out.println("Hello Death");
        testValid();
    }
    

    public static void testValid()
    {
        BraceChecker checker = new BraceChecker();
        System.out.println( checker.isValid("()}"));
        System.out.println( checker.isValid("[(])")); 

        System.out.println( checker.isValid("([{}])"));
        System.out.println( checker.isValid("(}"));

        System.out.println( checker.isValid("[(])(}(}))(}{]["));
        System.out.println( checker.isValid("[(])(}(}))(}{][())({}}{()][][(((({{"));
        
        System.out.println( checker.isValid("(((({{"));
        System.out.println( checker.isValid("()"));
        
        
    }
    

    //Valid Braces
    //https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java

    public static class BraceChecker 
    {
        public boolean isValid(String braces) 
        {
            boolean result = true;
            braces = braces.replace(" ", "");

            //create last-in-first-out stack
            Stack<Character> stack = new Stack<Character>();

            //We can do easy check to make sure it's an even number of characters 
            if(braces.length() % 2 == 0 )
            {
                for(int i = 0; i < braces.length(); i++)
                {
                    Character checkCharacter = braces.charAt(i);
                    // if we are a beginning bracket, place it on stack
                    if(checkCharacter.equals('(') || checkCharacter.equals('{') || checkCharacter.equals('[') )
                    {
                        stack.push(checkCharacter);
                    }
                    // otherwise we want to check if the ending bracket matches
                    else
                    {
                        Character checkCharacterPop;
                        try 
                        { 
                            checkCharacterPop= stack.pop();

                            if(checkCharacterPop.equals('(') && !checkCharacter.equals(')'))
                            {
                                result = false;
                            }
                            else if(checkCharacterPop.equals('[') && !checkCharacter.equals(']'))
                            {
                                result = false;
                            }
                            else if(checkCharacterPop.equals('{') && !checkCharacter.equals('}'))
                            {
                                result = false;
                            }
                        } catch (Exception e) {
                            result = false;
                        }
                        
                        
                    }
                }

                //If we still have more on the stack, then we didn't have ending braces and therefore it's already wrong
                if(stack.size() > 0)
                    result = false;
            }
            else
            {
                result = false;
            }
            return result;
        }
    }

    
    public static class WordOrder 
    {
        //https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java
        public static String order(String words) {
            String result = "";

            return result;
        }
    }
}
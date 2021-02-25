package com.enzy.sandbox;

import java.util.Stack;

public class Codewars1 {
    public static void main(String[] args) {
        //System.out.println("Hello Death");
        testValid();
    }
    

	public static void testValid() {
        BraceChecker checker = new BraceChecker();
        System.out.println( checker.isValid("()"));
        System.out.println( checker.isValid("([{}])"));
        System.out.println( checker.isValid("(}"));
    }
    

    //Valid Braces
    //https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java

    public static class BraceChecker {

        public boolean isValid(String braces) {
            boolean result = true;

            //create last-in-first-out stack
            Stack<Character> stack = new Stack<Character>();

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
                    Character endingBracket = stack.pop();
                    if(checkCharacter.equals('(') && !endingBracket.equals(')'))
                    {
                        result = false;
                    }
                    else if(checkCharacter.equals('[') && !endingBracket.equals(']'))
                    {
                        result = false;
                    }
                    else if(checkCharacter.equals('{') && !endingBracket.equals('}'))
                    {
                        result = false;
                    }
                }
            }

            return result;
        }

    }
}
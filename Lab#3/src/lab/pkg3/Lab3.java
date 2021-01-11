package lab.pkg3;

import java.util.Scanner;

/**
 *
 * @author work
 */
public class Lab3 {

   //Method to check if a String of parenthesis' are balanced
   @SuppressWarnings("unchecked")
   public static void balanced(String s) throws IndexOutOfBoundsException
   { 
       IndexOutOfBoundsException problem = new IndexOutOfBoundsException(s + " is not balanced");
       Stack stack = new Stack();//Create's a new stack
       char[] input = s.toCharArray();//Converts string into an array
       char pop;//Variable to catch whats popped off of the stack
       
       for(int i = 0; i < input.length; i++)//Scans through the input array
          {
            if(input[i] == '(' || input[i] == '{' || input[i] == '[')
              {
                stack.push(input[i]);//Pushes the data in the current array index  
              }                      //If it's (,{, or [ and ignores anything else
            
            //If the current array index is a closing bracket
            else if(input[i] == ')' || input[i] == '}' || input[i] == ']')
              {
               if(stack.size() == 0)//If there is no opening brackets on the stack,
                 {                  //it will report an error
                   throw problem;  
                 } 
               
               pop = (char)stack.pop();//Pops off the top of the stack and stores it.  
               switch(pop)//Takes what was popped off the stack and compares with
                    {     //the current index
                   
                     //If pop is equal to '('
                     case '(':
                         if(input[i] == ')')
                            {
                             break; //Breaks the switch loop and moves to the next index
                            }
                         else throw problem;//If the parenthesis don't match, reports error
                         
                     //If pop is equal to '{'    
                     case '{':
                          if(input[i] == '}')
                            {
                             break; //Breaks the loop and moves to the next index   
                            }
                          else throw problem; //If the parenthesis don't match, reports error
                     
                     //If pop is equal to '['     
                     case '[':
                          if(input[i] == ']')
                            {
                             break; //Breaks the switch loop and moves to the next index
                            }
                          else throw problem; //If the parenthesis don't match, reports error
                    }
              }
          }
       System.out.println(s + " is balanced!"); //If you get through with no error reporting
   }                                           //then the input is balanced!
   
   //Method to determine precedence of operators
   private static boolean isLowerPrecedence(char op1, char op2)
   {
    switch (op1)
    {
        case '+':
        case '-':
            return !(op2 == '+' || op2 == '-');

        case '*':
        case '/':
            return op2 == '^' || op2 == '(';

        case '^':
            return op2 == '(';

        case '(':
            return true;

        default:
            return false;
    }
   }
   
   //Changes infix to postfix
   @SuppressWarnings("unchecked")
   public static void infixToPostfix (String s)
   {
     Stack stack = new Stack();
     StringBuilder output = new StringBuilder(); 
     char[] input = s.toCharArray();//Turns the input string into an array
     char temp;
     char pop = ' ';
     
     //Scans through the array
     for(int i = 0; i < input.length; i++)
        {
         temp = input[i];//Adds the data in the current index to a variable for comparing
         //Stack ignores operators and pushes operands into the outuput
         if(temp != '%' && temp != '/' && temp != '*' && temp != '+' && temp != '-' && temp != '^')
           {
             output.append(temp);
           }
         
         //If the current index in the array is a right bracket
         else if(temp == ')')
           {
             while(pop != '(')//Pops the stack until it reaches a left bracket
               {
                 pop = (char)stack.pop();
                 output.append(pop);
               } 
           }
         
         //Pops until it hits an operand of a higher precedence or the stack is empty
         else if(temp == '(' || temp == '%' || temp == '/' || temp == '*' || temp == '+' || temp == '-' || temp == '^')
           {   
            while(stack.size() != 0 && isLowerPrecedence(temp, (char)stack.peek()))
                {
                 pop = (char)stack.pop(); 
                 output.append(pop);
                }
            
             //Pushes the next operand onto the stack afterwards
             stack.push(temp);
           }        
        }
    
    //Pops the stack until it's empty 
    while(stack.size() != 0)
        {
         pop = (char)stack.pop();
         output.append(pop);
        }
    
    //Prints the output out as a postfix expression
    System.out.println(output);     
   }
   
   //Method to evaluate postfix expressions
   @SuppressWarnings("unchecked")
   public static void evaluatePostfix(String s)
   { 
    Stack stack = new Stack();
    char[] input = s.toCharArray();//Converts input string to an array
    int var1 = 0;//Variable to hold int value of data
    int var2 = 0;//Variable to hold in value of data
    int result = 0;//Variable to store the results of two operands
      
    for(int i = 0; i < input.length; i++)
      { //Pushes operands onto the stack, ignores operators.
        if(input[i] != '+' && input[i] != '-' && input[i] != '*' && input[i] != '/' && input[i] != '%' && input[i] != '^')
         {
          stack.push(input[i]);
         }  
        
        //If the current index is an operator, it will pop the top 2 variables on the stack
        else if(input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/' || input[i] == '%' || input[i] == '^')
         { 
             var1 = Integer.parseInt(String.valueOf(stack.pop()));//Stores the first variable
             var2 = Integer.parseInt(String.valueOf(stack.pop()));//Stores the second variable
             
           //Determines how to operate on the two variables, pushes the result back onto the stack
           if(input[i] == '+')
             {
              result = var2 + var1;
              stack.push(result);
             } 
           
           else if(input[i] == '-')
             {
              result = var2 - var1;
              stack.push(result);
             }
           
            else if(input[i] == '*')
             {
              result = var2 * var1;
              stack.push(result);
             }
           
            else if(input[i] == '/')
             {
              result = var2 - var1;
              stack.push(result);
             }
           
            else if(input[i] == '%')
             {
              result = var2 % var1;
              stack.push(result);
             }
           
            else if(input[i] == '^')
             {
              result = var2 ^ var1;
              stack.push(result);
             }
         }
      }
    //Prints out the remaining variable in the stack which is the result
    System.out.println(stack.peek());
   }
   
   //Checks if a stack has consecutive pairs
   public static boolean checkStackPairwiseOrder(Stack<Integer> s)
   { 
       Stack<Integer> temp = new Stack<Integer>();//Creates a temp stack to scan through;
       
       while(!s.isEmpty())
          {
            temp.push(s.pop());//Fills the temp stack with all of the elements of the
          }                    //Parameter stack
   
        boolean result = false;//Boolean variable to determine outcome
        while(temp.size() > 1)
          {
            int var1 = temp.pop();//Pops the first variable
            int var2 = temp.pop();// pops the second variable
           
            if(var2 == var1 + 1 || var2 == var1 - 1)//Determines if the variables are consecutive
              {
               result = true;   
              }
           
            s.push(var1);//Pushes the results back onto the original stack.
            s.push(var2);
          }
        
    return result;   
   }
   
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     Stack<Integer> stack = new Stack();
     String input;
     
     stack.push(1);
     stack.push(2);
     stack.push(3);
     stack.push(4);
     stack.push(5);
     stack.push(6);
     
     System.out.println("Testing checkStackPairwiseOrder Method: ");
     System.out.println(checkStackPairwiseOrder(stack));
     
     System.out.println("Testing Postfix Evaluation method: ");
     
     input = scan.nextLine();
     
     evaluatePostfix(input);
     
    System.out.println("Testing infix to postfix method: "); 
     input = scan.nextLine();
     
     infixToPostfix(input);
     
    System.out.println("Testing Parenthesis Balance method: ");
     input = scan.nextLine();
     
     try
       {
        balanced(input);   
       }
     
     catch (IndexOutOfBoundsException exception)
       {
        System.out.println(input + " is not balanced!");   
       }
     
    }
    
}
